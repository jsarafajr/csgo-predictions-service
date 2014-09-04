<%--
  Created by IntelliJ IDEA.
  User: jsarafajr
  Date: 28.08.14
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Custom match</title>
    <script src="/resources/js/jquery.min.js"></script>
    <link rel="stylesheet" href="/resources/css/table.css">
    <script src="/resources/js/custom_match.js"></script>
</head>
<body>
<div id="custom_match" >
    <h4>Custom match: </h4>
    <form id="get_custom_match" style="width: 100%;">
        <div class="row" style="line-height: 55px;margin-left: 85px;">
            <div style="display: inline-block;">
                <select id="custom_team_1" style="padding: 0">
                    <option value="" style='display:none;' disabled selected >Select team</option>
                </select>
            </div>
            <div style="display: inline-block; margin: 0 1em">
                <span>VS</span>
            </div>
            <div style="display: inline-block">
                <select id="custom_team_2" style="padding: 0">
                    <option value="" style='display:none;' disabled selected >Select team</option>
                </select>
            </div>
            <br>
        </div>
        <input type="submit" id="custom_match_btn" value="Predict!" style="display: inline-block; margin-left: 230px;">
    </form>
    <hr>
    <div class="row" id="custom_match_div">
        <h4>Latest custom predictions: </h4>
        <table id="recent_custom_predictions" style="width: 630px;cursor: pointer;">

        </table>
    </div>
</div>

</body>
</html>
