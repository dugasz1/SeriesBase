<%--
  Created by IntelliJ IDEA.
  User: Dudu
  Date: 2017. 11. 30.
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Színész kezelő</title>

    <%@include file="/includes/meta.jsp"%>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="js/actors.js" ></script>
</head>
<body>
<%@include file="/includes/menu.jsp"%>
<div class="content" >
    <h1>Színész keresése:</h1>
    <form id="searchForm">
        <label>Adja meg a színész nevét: </label>
        <input type="text" id="searchName" />
    </form>

    <table id="actorSeachResult" border="1">

    </table>

    <span class="hr-line" />

    <h1>Színész hozzáadása:</h1>
    <form id="addForm">
        <label>Adja meg a színész nevét: </label>
        <input type="text" id="actorName" required/>
        <label>Adja meg a nemét: </label>
        <select id="actorGender">
            <option value="MALE">Férfi</option>
            <option value="FEMALE">Nő</option>
            <option value="OTHER">Egyéb</option>
        </select>
        <button type="submit">Hozzáad</button>
    </form>

    <div id="addResult" style="color: red;">

    </div>

    <span class="hr-line" />
</div>
<footer>

</footer>
</body>
</html>
