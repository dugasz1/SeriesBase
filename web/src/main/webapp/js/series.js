// Builds the HTML Table out of myList.
function buildHtmlTable(selector, myList) {
    var columns = addAllColumnHeaders(myList, selector);

    for (var i = 0; i < myList.length; i++) {
        var row$ = $('<tr/>');
        for (var colIndex = 0; colIndex < columns.length; colIndex++) {
            var cellValue = myList[i][columns[colIndex]];
            if (cellValue == null) {
                cellValue = "";
            }
            if(colIndex ==0){
                var linkCell$ = $('</a>');
                linkCell$.attr('href', "actor/"+cellValue);
                linkCell$.text(cellValue)
                row$.append($('<td/>').html('<a href="series/'+cellValue+'">'+cellValue+'</a>'));
            }else{
                row$.append($('<td/>').html(cellValue));
            }
        }
        $(selector).append(row$);
    }
}

// Adds a header row to the table and returns the set of columns.
// Need to do union of keys from all records as some records may not contain
// all records.
function addAllColumnHeaders(myList, selector) {
    var columnSet = [];
    var headerTr$ = $('<tr/>');

    for (var i = 0; i < myList.length; i++) {
        var rowHash = myList[i];
        for (var key in rowHash) {
            if ($.inArray(key, columnSet) == -1) {
                if(key == "seasons"){
                    continue;
                }
                columnSet.push(key);
                headerTr$.append($('<th/>').html(key));
            }
        }
    }
    $(selector).append(headerTr$);

    return columnSet;
}

function searchActor() {
    var urlPath = "";
    if($("#searchTitle").val() == ""){
        urlPath = "api/series/get";
    }else{
        urlPath = "api/series/get/" + $("#searchTitle").val();
    }
    $.ajax({
        url: urlPath,
        contentType: 'application/json',
        success: function (data, textStatus, xhr) {
            var resultTarget = $('#seriesSearchResult')
            resultTarget.html("");
            buildHtmlTable(resultTarget, data);
        },
        failure:function () {
            console.log("fail");
        },
        error:function () {
            console.log("error");
        }
    });
}

$(document).ready(
    function () {
        console.log("ready");
        $("#searchTitle").on('input', searchActor);
        //$("#addForm").on('submit', addActor);
    }
)