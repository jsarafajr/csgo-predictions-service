/**
 * Created by jsarafajr on 23.08.14.
 */

$(document).ready(function() {
    getAllTeams();

    var day = $("#day");
    var mounth = $("#mounth");
    var year = $("#year");

    for (var i = 0; i < 31; i++) {
        day.append("<option>" + (i + 1) + "</option>");
    }

    for (var i = 0; i < 12; i++) {
        mounth.append("<option>" + (i + 1) + "</option>");
    }

    year.append("<option>" + 2014 + "</option>");
    year.append("<option>" + 2015 + "</option>");
});

function setTeamsToSelects(teams) {
    var select1 = $("#team_1");
    var select2 = $("#team_2");

    for (var i = 0; i < teams.length; i++) {
        select1.append(
                "<option>" + teams[i].name + "</option>"
        );
        select2.append(
                "<option>" + teams[i].name + "</option>"
        );
    }
}

function getAllTeams() {
    var url = "/team/get-all";
    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        success: function(data) {
            setTeamsToSelects(data);
        },
        error: function() {
            teams = [];
        }
    });
}