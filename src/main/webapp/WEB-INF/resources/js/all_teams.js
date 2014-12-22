/**
 * Created by jsarafajr on 25.08.14.
 */

$(document).ready(function() {
        getTeams();
});

function getTeams() {
    var url = "/team/get-all";
    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        success: function(data) {
            mapToTable(data);
        },
        error: function() {
            alert("Error");
        }
    });
}

function mapToTable(data) {
    var table = $("#teams");

    for (var i = 0; i < data.length; i++) {
        table.append(
            "<tr>" +
                "<td>" + data[i].id + "</td>" +
                "<td>" + data[i].name + "</td>" +
                "<td>" + data[i].matches + "</td>" +
                "<td>" + data[i].wins + "</td>" +
                "<td>" + data[i].image + "</td>" +
            "</tr>"
        );
    }
}