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
    <script src="/resources/js/custom_match.js"></script>
</head>
<body>
<div id="custom_match" >
    <form id="get_custom_match" style="width: 100%">
        <h4>Custom match: </h4>
        <div class="row" style="line-height: 55px">
            <div>
                <select id="custom_team_1" style="padding: 0">
                    <option value="" style='display:none;' disabled selected >Select team</option>
                </select>
            </div>
            <div>
                <span>VS</span>
            </div>
            <div>
                <select id="custom_team_2" style="padding: 0">
                    <option value="" style='display:none;' disabled selected >Select team</option>
                </select>
            </div>
        </div>
        <input type="submit" id="custom_match_btn" value="Predict!">
    </form>
    <div class="row" id="custom_match_div">
    </div>
</div>

</body>
</html>
