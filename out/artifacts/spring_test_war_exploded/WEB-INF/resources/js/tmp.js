/**
 * Created by jsarafajr on 18.08.14.
 */

$(document).ready(function() {
    $('#show_details1').click(function(){// на нажатие h1 вешаем обработчик, который
        $('#match_details1').slideToggle(300);        // у элемента с #toggler переключет видимость
        $('#match1').css({
            "borderBottom" : "0"
        });
    });
});
