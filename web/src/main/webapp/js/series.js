// Builds the HTML Table out of myList.
function buildHtmlTableSeries(selector, myList) {
    var columns = addAllColumnHeadersSeries(myList, selector);

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
function addAllColumnHeadersSeries(myList, selector) {
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

function searchSeries() {
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
            buildHtmlTableSeries(resultTarget, data);
        },
        failure:function () {
            console.log("fail");
        },
        error:function () {
            console.log("error");
        }
    });
}

function addSeries(e) {
    console.log('addSeries');
    e.preventDefault();
    var resultTarget = $('#seriesAddResult');
    resultTarget.html("");

    var rating = parseInt($('#seriesRating').val());
    if(rating < 0 || rating >10){
        resultTarget.text('Értékelésnek 0 és 10 között kell lennie!');
        return;
    }

    var data = {
        id:-1,
        title:$('#seriesTitle').val(),
        rating:rating,
        seasons: [],
        duration: $('#seriesDuration').val()
    }

    $.ajax({
        url: 'api/series/add/',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        beforeSend: function () {
            resultTarget.html("<i class=\"fa fa-gear fa-spin\" style=\"font-size:24px\"></i>");
        },
        success: function (data, textStatus, xhr) {
            resultTarget.text(data.title + " added to the db with id: " + data.id);
        },
        error:function (xhr, textStatus, errorThrown) {
            resultTarget.text(xhr.responseText);
        }
    });

}

function regSeriesListeners() {
    $("#seriesSearchForm").on('input', searchSeries);
    $("#seriesAddForm").on('submit', addSeries);

}

$(document).ready(
    function () {
        regSeriesListeners();
    }
)