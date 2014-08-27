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
        <!--[if lte IE 8]><script src="/resources/css/ie/html5shiv.js"></script><![endif]-->
        <script src="/resources/js/skel.min.js"></script>
        <script src="/resources/js/init.js"></script>
        <script src="/resources/js/index.js"></script>
        <noscript>
            <link rel="stylesheet" href="/resources/css/skel.css" />
            <link rel="stylesheet" href="/resources/css/style.css" />
            <link rel="stylesheet" href="/resources/css/style-desktop.css" />
        </noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="/resources/css/ie/v8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="/resources/css/ie/v9.css" /><![endif]-->
        <link rel="stylesheet" href="/resources/css/table.css">
	</head>

	<body>

		<!-- Nav -->
			<nav id="nav">
				<ul class="container" style="display: inline">
					<li><a href="#" id="reply_form_button">Reply</a></li>
					<li><a href="#" id="about_button">About</a></li>
				</ul>
                <div id="lang_panel">
                    <img src="/resources/images/flag_ru.gif">
                </div>
            </nav>

		<!-- Predictions -->
			<div class="wrapper style2" id="wraper">
				<article id="work">
					<header>
						<h2>Upcoming matches:</h2>
					</header>
					<div class="container" id="upc_match">
                        <!-- ROW #1 -->
						<!--
                        <div class="row match_row">
                            <div class="box style1" id="match1">
                                <div style="display: inline-block">
                                    <section style="padding-top: 1em">
                                        <img class="featured fa-comment-o" src="/resources/images/mouse.jpg">
                                        <h4>Mousesports</h4>
                                    </section>
                                </div>
                                <div class="progress">
                                    <ul class="percent-bar">
                                        <li class="percent-bar__fill" style="width:88%;"><span class="percent-bar__label">89%</span></li>
                                        <li class="percent-bar__fill blue" style="width:10%;"><span class="percent-bar__label">11%</span></li>
                                    </ul>
                                    <div class="details_bnt button" id="show_details1">Show details</div>
                                </div>
                                <div style="display:inline-block">
                                    <section style="padding-top: 1em">
                                        <img class="featured fa-comment-o" src="/resources/images/Epsilon.jpg">
                                        <h4>Epsilon</h4>
                                    </section>
                                </div>
							</div>
                            <div class="box style1 togler" id="match_details1">
                                <div class="details_team_div" style="float: left">
                                    <span>Won <b>3</b> of <b>5</b> matches - <b>35%</b></span> <br>
                                    <span>Won <b>4</b> of the latest <b>5</b> matches - <b>80%</b></span> <br>
                                </div>
                                <div class="details_team_div" style="float: right">
                                    <span>Won <b>80</b> of <b>158</b> matches - <b>66%</b></span> <br>
                                    <span>Won <b>3</b> of the latest <b>5</b> matches - <b>30%</b></span> <br>
                                </div>
                                <span style="display: inline-block">All <b>Mousesports</b> vs <b>Epsilon</b> matches:</span>
                                <br>
                                <div class="details_team_div" style="float: left">
                                    <span>Mousesports: <b>3</b> wins</span>
                                </div>
                                <div class="details_team_div">
                                    <span>Draw: <b>3</b></span> <br>
                                </div>
                                <div class="details_team_div" style="float: right">
                                    <span>Epsilon: <b>2</b> wins</span> <br>
                                </div>
                                <br>
                                <span>[show all]</span>
                            </div>
                        </div> -->
					</div>


				</article>
			</div>

        <%-- ABOUT --%>
        <div id="about" style="display: none">
            <h4>Work in progress...</h4>
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