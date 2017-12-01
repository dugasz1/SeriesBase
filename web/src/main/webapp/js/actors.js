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
            if(colIndex ==1){
                var linkCell$ = $('</a>');
                linkCell$.attr('href', "/actor/"+cellValue);
                linkCell$.text(cellValue)
                row$.append($('<td/>').html('<a href="/actor/'+cellValue+'">'+cellValue+'</a>'));
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
                columnSet.push(key);
                headerTr$.append($('<th/>').html(key));
            }
        }
    }
    $(selector).append(headerTr$);

    return columnSet;
}

function searchActor() {
    console.log("Hello");
    var urlPath = "";
    if($("#searchName").val() == ""){
        urlPath = "actor/get";
    }else{
        urlPath = "actor/get/" + $("#searchName").val();
    }
    $.ajax({
        url: urlPath,
        contentType: 'application/json',
        success: function (data, textStatus, xhr) {
            console.log(xhr.status);
            console.log(data);
            var resultTarget = $('#actorSeachResult')
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

function addActor(e) {
    console.log('addActor');
    var resultTarget = $('#addResult');
    resultTarget.html("");

    var data = {
        id:-1,
        name:$('#actorName').val(),
        gender:$('#actorGender').val()
    }

    $.ajax({
        url: '/actor/add/',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        beforeSend: function () {
            resultTarget.html("<i class=\"fa fa-gear fa-spin\" style=\"font-size:24px\"></i>");
        },
        success: function (data, textStatus, xhr) {
            resultTarget.text(data.name + " added to the db with id: " + data.id);
        },
        error:function (xhr, textStatus, errorThrown) {
            resultTarget.text(xhr.responseText);
        }
    });
    e.preventDefault();
}

$(document).ready(
    function () {
        console.log("ready");
        $("#searchName").on('input', searchActor);
        $("#addForm").on('submit', addActor);
    }
)