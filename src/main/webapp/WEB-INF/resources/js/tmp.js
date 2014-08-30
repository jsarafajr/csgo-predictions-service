/**
 * Created by jsarafajr on 18.08.14.
 */

$(document).ready(function() {
    $('#show_details1').click(function(){
        $('#match_details1').slideToggle(300);
        $('#match1').css({
            "borderBottom" : "0"
        });
    });
});
