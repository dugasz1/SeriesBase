
function timeConverter(timestamp){
    var a = new Date(timestamp);
    var months = ['Január','Február','Március','Április','Május','Június','Július','Augusztus','Szeptember','Október','November','December'];
    var year = a.getFullYear();
    var month = months[a.getMonth()];
    var date = a.getDate();
    var hour = a.getHours();
    if(hour < 10){hour = '0' + hour;}
    var min = a.getMinutes();
    if(min < 10){min = '0' + min;}
    var sec = a.getSeconds();
    if(sec < 10){
        sec = '0' + sec;
    }
    var time = year + ' ' + month + ' ' + date + ' ' +hour + ':' + min + ':' + sec ;
    return time;
}

$(document).ready(function () {
    $('#airTime').text(timeConverter(airTimeStamp));
})