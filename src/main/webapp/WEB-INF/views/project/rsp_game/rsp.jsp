<%@ page import="com.kitri.springbasicboot.project.rsp_game.GameStatus" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/rsp_game/style.css" />
    <title>Rock & Scissors & Paper</title>
</head>
<body>
<%
    GameStatus status = (GameStatus) session.getAttribute("status");
%>
<div id="form">
    <img src="/rsp_game/rock.png">
    <img src="/rsp_game/scissors.png">
    <img src="/rsp_game/paper.png">
</div>
<hr/>
<hr/>
<ul>
    <li>Win count : ${status.getWinCount()}</li>
    <li>Lose count : ${status.getLoseCount()}</li>
    <li>Draw count : ${status.getDrawCount()}</li>
</ul>
<hr/>
<hr/>
<div id="result">
    <div id="you" class="${status.getWinner().equals("you") ? "winner" : ""}">
        <img src="${status.convertSrc(status.getYourSrc())}">
        You
    </div>
    <div id="computer" class="${status.getWinner().equals("computer") ? "winner" : ""}">
        <img src="${status.convertSrc(status.getComputerSrc())}">
        Computer
    </div>
</div>
<script src="/rsp_game/script.js"></script>
</body>
</html>

