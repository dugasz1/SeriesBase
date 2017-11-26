<%--
  Created by IntelliJ IDEA.
  User: Dudu
  Date: 2017. 11. 22.
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kezdőlap</title>
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="js/index.js" ></script>
</head>
<body>
    <%@include file="includes/menu.jsp"%>
    <div class="content">
        <form>
            <label>Adja meg a színész nevét: </label>
            <input type="text" id="searchName" />
            <button type="button" id="searchButton">Keresés</button>
        </form>

        <table id="actorSeachResult" border="1">

        </table>

        <span class="hr-line" />

        <form>
            <label>Adja meg a színész nevét: </label>
            <input type="text" />
            <label>Adja meg a születési évét: </label>
            <input type="text" />
            <label>Adja meg a nemét: </label>
            <select>
                <option value="MALE">Férfi</option>
                <option value="FEMALE">Nő</option>
                <option value="OTHER">Egyéb</option>
            </select>
            <button type="button">Hozzáad</button>
        </form>

        <span class="hr-line" />
    </div>
    <footer>

    </footer>
</body>
</html>
