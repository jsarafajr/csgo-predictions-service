<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Add new match</title>
    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/js/match_add.js"></script>
</head>
<body>
    <form id="add_match">
        <label>Team 1 :</label><select id="team_1"></select>
        <br>
        <label>Team 2 :</label><select id="team_2"></select>
        <br>
        <label>Date :</label><select id="day"></select> : <select id="mounth"></select> : <select id="year"></select>
        <br>
        <input type="submit">
    </form>
    <span id="status"></span>
</body>
</html>