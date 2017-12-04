<%--
  Created by IntelliJ IDEA.
  User: dudu
  Date: 2017.12.04.
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>

    <%@include file="includes/meta.jsp"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="js/actors.js" ></script>
    <script src="js/series.js" ></script>
    <script src="js/loader.js" ></script>
</head>
<body>
<nav>
    <ul class="menu">
        <li><a href="javascript:loadFragment('<c:url value="/indexFragment.html"/>')"><span><i class="fa fa-home" aria-hidden="true">&nbsp; Kezdőlap</i></span></a></li>
        <li><a href="javascript:loadFragment('<c:url value="/actors.html"/>')"><span><i class="fa fa-address-book" aria-hidden="true">&nbsp; Színészek</i></span></a></li>
        <li><a href="javascript:loadFragment('<c:url value="/serieses.html"/>')"><span><i class="fa fa-film" aria-hidden="true">&nbsp; Sorozatok</i></span></a></li>
    </ul>
</nav>

<div class="content" id="content">

    <span class="hr-line" />

    <h2>Ez az oldal Bozó Dávid (TMN7C4) beadandója a következő tárgyakra: </h2>
    Tesztelek
    <ul>
        <li>Web technológiák 1</li>
        <li>Web-es alkalmazások (Java)</li>
        <li>Adatkezelés XML-ben</li>
    </ul>

    <span class="hr-line" />
</div>
<footer>

</footer>


</body>
</html>
