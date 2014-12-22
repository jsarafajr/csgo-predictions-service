<!DOCTYPE HTML>
<html>
	<head>
		<title>Match Predictions CSGO</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
        <meta name="keywords" content="" />
        <script src="/resources/js/jquery.min.js"></script>
        <script src="/resources/js/jquery.scrolly.min.js"></script>
        <script src="/resources/js/popup.min.js"></script>
        <link rel="stylesheet" href="/resources/css/popup.css">
        <link rel="stylesheet" href="/resources/css/progress.css">
        <link rel="stylesheet" href="/resources/css/table.css">
        <!--[if lte IE 8]><script src="/resources/css/ie/html5shiv.js"></script><![endif]-->
        <script src="/resources/js/skel.min.js"></script>
        <script src="/resources/js/init.js"></script>
        <script src="/resources/js/index.js"></script>
        <link rel="stylesheet" href="/resources/css/jquery.toastmessage.css">
        <script src="/resources/js/jquery.toastmessage.js"></script>
        <noscript>
            <link rel="stylesheet" href="/resources/css/skel.css" />
            <link rel="stylesheet" href="/resources/css/style.css" />
            <link rel="stylesheet" href="/resources/css/style-desktop.css" />
        </noscript>
        <!--[if lte IE 8]><link rel="stylesheet" href="/resources/css/ie/v8.css" /><![endif]-->
        <!--[if lte IE 9]><link rel="stylesheet" href="/resources/css/ie/v9.css" /><![endif]-->
	</head>

	<body>

		<!-- Nav -->
			<nav id="nav">
				<ul class="container" style="display: inline">
                    <li><a href="custom_match" id="custom_button">Custom match</a></li>
                    <li><a href="#" id="reply_form_button">Reply</a></li>
                    <li><a href="#" id="about_button">About</a></li>
				</ul>
                <div id="lang_panel" style="display: none">
                    <img src="/resources/images/flag_ru.gif">
                </div>
            </nav>

		<!-- Predictions -->
			<div class="wrapper style2" id="wraper">
				<article>
					<header>
						<h2>Upcoming matches:</h2>
					</header>
					<div class="container" id="upc_match">
					</div>
				</article>
			</div>

        <%-- ABOUT --%>
        <div id="about" style="display: none">
            <div style="text-align: center">Hello! <br> This is a web platform which function is to predict <br> Counter-Strike official matches results.<br></div>
            <hr>
            <div style="margin-top: 5px">
                <div style="text-align: center;">My contacts : </div>
                <span>Email : evgeniy.baranuk@gmail.com</span><br>
                <span>Skype : evgeniy.baranuk</span><br>
            </div>
        </div>

        <%-- REPLY --%>
        <div class="row" id="reply_form" style="display: none">
            <div class="12u">
                <form action="#">
                    <div>
                        <h4>Send message: </h4>
                        <div class="row">
                            <div class="6u">
                                <input type="text" name="name" id="name" placeholder="Name" />
                            </div>
                            <div class="6u">
                                <input type="text" name="email" id="email" placeholder="Email" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="12u">
                                <input type="text" name="subject" id="subject" placeholder="Subject" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="12u">
                                <textarea name="message" id="message" placeholder="Message"></textarea>
                            </div>
                        </div>
                        <div class="row double">
                            <div class="12u" style="width: 100%; padding: 10px 0 0 50px;">
                                <ul class="actions" style="width: 100%; text-align: center">
                                    <li style="display: inline-block"><input type="submit" value="Send Message" /></li>
                                    <li style="display: inline-block"><input type="reset" value="Clear Form" class="alt" /></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <!-- Contact -->
        <div class="wrapper style4" id="foot">
            <div class="row">
                <div class="12u">
                    <h3></h3>
                </div>
            </div>
        </div>
    </body>
</html>