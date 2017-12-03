<%--
  Created by IntelliJ IDEA.
  User: Dudu
  Date: 2017. 12. 03.
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>${series.title} | ${season.id}. évad</title>
    <meta content="width=device-width, initial-scale=1" name="viewport">

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/font-awesome.min.css" />">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="<c:url value="/js/actors.js" />" ></script>
</head>
<body>
<%@include file="/includes/menu.jsp"%>

<div class="content">
    <b>${series.title}</b> </br>
    <b>${season.id}. évad</b> </br>

    <h3>Epizódok:</h3>
    <table>
        <tr>
            <th>Cím</th>
        </tr>
        <c:forEach items="${season.episodes}" var="episode">
            <tr>
                <td><a href="<c:url value="/" />series/${series.id}/${season.id}/${episode.id}">${episode.title}</a> </td>
            </tr>
        </c:forEach>
    </table>
</div>
<footer>

</footer>
</body>
</html>
