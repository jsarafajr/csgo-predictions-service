/**
 * Created by jsarafajr on 26.08.14.
 */

$(document).ready(function() {
    $("#wraper").css("minHeight", $(window).height() - ($("#foot").height() * 5)); //todo O_O
    getMatches();
});

function getMatches() {
    var url = "/match/get-all-predictions"; // todo
    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        success: function(data) {
            mapMatches(data);
        }
    });
}

function showDetails(id){
    $('#match_details' + id).slideToggle(300);
    $('#match' + id).css({
        "borderBottom" : "0"
    });
}

function mapMatches(data) {
    var field = $("#upc_match");

    for (i = 0; i < data.length; i++) {
        field.append(
            "<div class='row match_row'>" +
                "<div class='box style1' id='match" + data[i].id + "'>" +
                    <!-- Team 1 -->
                    "<div style='display: inline-block'>" +
                        "<section style='padding-top: 1em'>" +
                            "<img class='featured fa-comment-o' src='/resources/images/" + data[i].team1image +"'>" +
                            "<h4>" + data[i].team1Name + "</h4>" +
                        "</section>" +
                    "</div>" +
                    "<div class='progress'>" +
                        "<ul class='percent-bar'>" +
                            "<li class='percent-bar__fill' style='width:" + (data[i].percent1 - 1) +"%;'><span class='percent-bar__label'>" + data[i].percent1 + "%</span></li>" +
                            "<li class='percent-bar__fill blue' style='width:" + (data[i].percent2 - 1) +"%;'><span class='percent-bar__label'>" + data[i].percent2 + "%</span></li>" +
                        "</ul>" +
                        "<div class='details_bnt button' id='show_details" + data[i].id + "' onclick='showDetails(" + data[i].id + ")'>Show details</div>" +
                    "</div>" +
                    <!-- Team 2 -->
                    "<div style='display: inline-block'>" +
                        "<section style='padding-top: 1em'>" +
                            "<img class='featured fa-comment-o' src='/resources/images/" + data[i].team2image +"'>" +
                            "<h4>" + data[i].team2Name + "</h4>" +
                        "</section>" +
                    "</div>" +
                "</div>" +
                "<!-- Details -->" +
                "<div class='box style1 togler' id='match_details" + data[i].id + "'>" +
                    "<div class='details_team_div' style='float: left'>" +
                        "<span>Won <b>" + data[i].team1wins +"</b> of <b>" + data[i].team1matches + "</b> matches - <b>" + data[i].team1Wincoef + "%</b> </span> <br><div style='text-align: center;margin-top: -10px;'>[show]</div>" +
                    "</div>" +
                    "<div class='details_team_div' style='float: right'>" +
                        "<span>Won <b>" + data[i].team2wins +"</b> of <b>" + data[i].team2matches + "</b> matches - <b>" + data[i].team2Wincoef + "%</b> </span> <br><div style='text-align: center;margin-top: -10px;'>[show]</div>" +
                    "</div>" +
                    "<div style='display: inline-block;margin-top: -20px;width: 90%'>" +
                        "<span style='display: inline-block'><b>" + data[i].team1Name + "</b> vs <b>" + data[i].team2Name + "</b> played <b>" + data[i].versusCount + "</b> matches:</span>" +
                        "<br>" +
                        "<div class='details_team_div' style='float: left'>" +
                            "<span>" + data[i].team1Name + ": <b>" + data[i].vsTeam1Wins + "</b> wins</span>" +
                        "</div>" +
                        "<div class='details_team_div'>" +
                            "<span>Draw: <b>" + (data[i].versusCount - (data[i].vsTeam1Wins + data[i].vsTeam2Wins)) + "</b></span> <br>" +
                        "</div>" +
                        "<div class='details_team_div' style='float: right'>" +
                            "<span>" + data[i].team2Name + ": <b>" + data[i].vsTeam2Wins + "</b> wins</span> <br>" +
                        "</div>" +
                        "<br>" +
                        "<span>[show]</span>" +
                    "</div>" +
                "</div>" +
            "</div>"
        );



    }
}