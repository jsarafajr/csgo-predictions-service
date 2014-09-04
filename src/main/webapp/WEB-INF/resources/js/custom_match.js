/**
 * Created by jsarafajr on 28.08.14.
 */
$("#custom_match").ready(function() {
    getAllTeamsNames();
    customMatchEvent();
    getLatestCustomPrediction();
});

function setTeamsToSelects(teams) {
    var select1 = $("#custom_team_1");
    var select2 = $("#custom_team_2");

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
        }
    });
}

function customMatchEvent() {
    $("#get_custom_match").submit(function() {
        var url = "/match/get-single-prediction";

        var team1 = $("#custom_team_1").val();
        var team2 = $("#custom_team_2").val();

        if (team1 == null || team2 == null) {
            $().toastmessage('showNoticeToast', "Select teams ...");
            return false;
        }

        if (team1 == team2) {
            $().toastmessage('showWarningToast', "Select different teams ...");
            return false;
        }

        $.ajax({
            type: "POST",
            url: url,
            data: {"team1" : team1, "team2" : team2},
            success: function(data) {
                mapMatch(data);
            }
        });

        return false;
    });
}

function mapMatch(match) {
    var field = $("#custom_match_div");
    field.html("");
    
    field.append(
            "<div class='row match_row' style='margin-top: -2px;margin-left: 0;'>" +
                "<div class='box style1' style='width: 100%; box-shadow: 0 0'>" +
                "<!-- Team 1 -->" + 
                    "<div style='display: inline-block'>" +
                        "<section style='padding-top: 1em'>" +
                            "<img class='featured fa-comment-o' src='/resources/images/" + match.team1image +"'>" +
                            "<h4>" + match.team1Name + "</h4>" +
                        "</section>" +
                    "</div>" +
                    "<div class='progress' style='position: relative; top: -70px;'>" +
                        "<ul class='percent-bar'>" +
                            "<li class='percent-bar__fill' style='width:" + (match.percent1 - 1) +"%;'>" +
                                "<span class='percent-bar__label'>" + match.percent1 + "%</span>" +
                            "</li>" +
                            "<li class='percent-bar__fill blue' style='width:" + (match.percent2 - 1) +"%;'>" +
                                "<span class='percent-bar__label'>" + match.percent2 + "%</span>" +
                            "</li>" +
                        "</ul>" +
                    "</div>" +
                    "<!-- Team 2 -->" + 
                    "<div style='display: inline-block'>" +
                        "<section style='padding-top: 1em'>" +
                            "<img class='featured fa-comment-o' src='/resources/images/" + match.team2image +"'>" +
                            "<h4>" + match.team2Name + "</h4>" +
                        "</section>" +
                    "</div>" +
                "</div>" +
                "<!-- Details -->" +
                "<div class='box style1 togler' style='display: block; width: 100%; box-shadow: 0 0'>" +
                    "<div class='details_team_div' style='float: left'>" +
                        "<span>Won <b>" + match.team1wins +"</b> of <b>" + match.team1matches + "</b> matches - <b>" + match.team1Wincoef + "%</b> </span>" +
                    "</div>" +
                    "<div class='details_team_div' style='float: right'>" +
                        "<span>Won <b>" + match.team2wins +"</b> of <b>" + match.team2matches + "</b> matches - <b>" + match.team2Wincoef + "%</b> </span>" +
                    "</div>" +
                    "<div style='display: inline-block;margin-top: -10px;width: 90%'>" +
                        "<span style='display: inline-block'><b>" + match.team1Name + "</b> vs <b>" + match.team2Name + "</b> played <b>" + match.versusCount + "</b> matches:</span>" +
                        "<br>" +
                        "<div class='details_team_div' style='float: left; padding-top: 0'>" +
                            "<span>" + match.team1Name + ": <b>" + match.vsTeam1Wins + "</b> wins</span>" +
                        "</div>" +
                        "<div class='details_team_div' style='padding-top: 0'>" +
                            "<span>Draw: <b>" + (match.versusCount - (match.vsTeam1Wins + match.vsTeam2Wins)) + "</b></span> <br>" +
                        "</div>" +
                        "<div class='details_team_div' style='float: right; padding-top: 0'>" +
                            "<span>" + match.team2Name + ": <b>" + match.vsTeam2Wins + "</b> wins</span> <br>" +
                        "</div>" +
                        "<br>" +
                        "<div style='text-align: center; width: 100%;display: inline-block; padding-top: 0'>" +
                        "<div class='button' id='popup_versus" + match.id + "'>see all</div>" +
                    "</div>" +
                "</div>" +
            "</div>"
           
    )
    
}

function getLatestCustomPrediction() {
    var url = "/match/get-custom-predictions";
    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        success: function(data) {
            mapCustomPredictions(data);
        }
    });
}

function mapCustomPredictions(data) {
    for (var i = 0; i < data.length; i++) {
        var date = getStringDate(data[i]);

        $("#recent_custom_predictions").append(
            "<tr onclick='getSinglePrediction(" + data[i].id + ")'>" +
                "<td id='team1_" + data[i].id + "'>" + data[i].team1 + "</td>" +
                "<td>vs</td>" +
                "<td id='team2_" + data[i].id + "'>" + data[i].team2 + "</td>" +
                "<td>" + date + "</td>" +
            "</tr>"
        );
    }
}

function getSinglePrediction(id) {
    $("#custom_match_div").html("");

    var team1 = $("#team1_" + id).html();
    var team2 = $("#team2_" + id).html();

    var url = "/match/get-single-prediction";

    $.ajax({
        type: "POST",
        url: url,
        data: {"team1" : team1, "team2" : team2},
        success: function(data) {
            mapMatch(data);
        }
    });

    return false;
}

function getStringDate(data) {
    if (data.day != 0) {
        return data.day + " days ago";
    }
    if (data.hour != 0) {
        return data.hour + " hours ago";
    }
    if (data.min != 0) {
        return data.min + " minutes ago";
    }

    return data.sec + " seconds ago";
}