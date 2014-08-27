/**
 * Created by jsarafajr on 26.08.14.
 */

$(document).ready(function() {
    $("#wraper").css("minHeight", $(window).height() - ($("#foot").height())); //todo O_O
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
    var button = $('#show_details' + id);
    if (button.html() == 'Show details') {
        button.html("Hide details");
    } else {
        button.html("Show details");
    }

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
                        "<span>Won <b>" + data[i].team1wins +"</b> of <b>" + data[i].team1matches + "</b> matches - <b>" + data[i].team1Wincoef + "%</b> </span>" +
                    "</div>" +
                    "<div class='details_team_div' style='float: right'>" +
                        "<span>Won <b>" + data[i].team2wins +"</b> of <b>" + data[i].team2matches + "</b> matches - <b>" + data[i].team2Wincoef + "%</b> </span>" +
                    "</div>" +
                    "<div style='display: inline-block;margin-top: -10px;width: 90%'>" +
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
                        "<span class='button' id='popup_versus" + data[i].id + "'>see all</span>" +
                    "</div>" +
                "</div>" +
            "</div>"
        );

        $('#popup_versus' + data[i].id).popup({
            content : "<div><table id='popup_table' style='margin-bottom: 0'></table></div>",
            type : 'html',
            beforeOpen : function() {
                var popup = this;
                var id = this.matchId;

                $.get('/match/get-versus-matches/' + id,function(data){
                    var table = $('#popup_table');
                    table.html("");
                    if (data.length == 0) table.html("Empty");
                    for (var i = 0; i < data.length; i++) {
                        var match = data[i];
                        table.append(
                            "<tr style='border-top: 1pt solid grey;'>" +
                                "<td style='padding-left: 30px; padding-right: 30px'>" + match.date + "</td>" +
                                "<td style='padding-left: 30px; padding-right: 30px''>" + match.team1Name + " (" + match.team1Score + ")</td>" +
                                "<td style='padding-left: 30px; padding-right: 30px''>" + match.team2Name + " (" + match.team2Score + ")</td>" +
                            "</tr>"
                        );
                    }

                    popup.center();

                },'json');

            }
        });

        $('#popup_versus' + data[i].id).data('popup').matchId = data[i].id;
    }
}