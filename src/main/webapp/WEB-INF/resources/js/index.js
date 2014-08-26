/**
 * Created by jsarafajr on 26.08.14.
 */

$(document).ready(function() {
    $("#wraper").css("minHeight", $(window).height() - ($("#foot").height() * 2.3));
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

function mapMatches(data) {
    var field = $("#upc_match");

    for (var i = 0; i < data.length; i++) {
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
                        "<div class='details_bnt button' id='show_details1'>Show details</div>" +
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
                            "<span>Won <b>3</b> of <b>5</b> matches - <b>35%</b></span> <br>" +
                            "<span>Won <b>4</b> of the latest <b>5</b> matches - <b>80%</b></span> <br>" +
                        "</div>" +
                        "<div class='details_team_div' style='float: right'>" +
                            "<span>Won <b>80</b> of <b>158</b> matches - <b>66%</b></span> <br>" +
                            "<span>Won <b>3</b> of the latest <b>5</b> matches - <b>30%</b></span> <br>" +
                        "</div>" +
                        "<span style='display: inline-block'>All <b>Mousesports</b> vs <b>Epsilon</b> matches:</span>" +
                        "<br>" +
                        "<div class='details_team_div' style='float: left'>" +
                            "<span>Mousesports: <b>3</b> wins</span>" +
                        "</div>" +
                        "<div class='details_team_div'>" +
                            "<span>Draw: <b>3</b></span> <br>" +
                        "</div>" +
                        "<div class='details_team_div' style='float: right'>" +
                            "<span>Epsilon: <b>2</b> wins</span> <br>" +
                        "</div>" +
                        "<br>" +
                        "<span>[show all]</span>" +
                    "</div>" +
            "</div>"
        );
    }
}