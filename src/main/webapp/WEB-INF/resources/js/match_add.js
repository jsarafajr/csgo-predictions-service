/**
 * Created by jsarafajr on 23.08.14.
 */

$(document).ready(function() {
    getAllTeamsNames();

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


    match_add();
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

function getAllTeamsNames() {
    var url = "/team/get-all-names";
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

function match_add() {
    $("#add_match").submit(function() {
        var url = "/match/add-prediction";

        var name1 = $("#team_1").val();
        var name2 = $("#team_2").val();
        var day = $("#day").val();
        var month = $("#mounth").val();
        var year = $("#year").val();

        $.ajax({
            type: "POST",
            url: url,
            data: {"name1" : name1, "name2" : name2,
                "day" : day, "month" : month, "year" : year},
            success: function(data) {
                alert("Ok")
            },
            error: function() {
                alert("Error")
            }
        });

        return false;
    });
}