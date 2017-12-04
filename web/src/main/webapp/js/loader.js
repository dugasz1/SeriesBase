function loadFragment(fragment) {
    var resultTarget = $('#content');

    $.ajax({
        url: fragment,
        method: 'GET',
        beforeSend: function () {
            resultTarget.html("<i class=\"fa fa-gear fa-spin\" style=\"font-size:24px\"></i>");
        },
        success: function (data, textStatus, xhr) {
            resultTarget.html(data);
            regActorEventListeners();
            regSeriesListeners();
        },
        error:function (xhr, textStatus, errorThrown) {
            resultTarget.text(xhr.responseText);
        }
    });
}