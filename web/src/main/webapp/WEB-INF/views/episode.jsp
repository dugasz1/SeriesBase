<%--
  Created by IntelliJ IDEA.
  User: Dudu
  Date: 2017. 12. 03.
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>${series.title} | ${season.id}. évad | ${episode.id}</title>
    <meta content="width=device-width, initial-scale=1" name="viewport">

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/font-awesome.min.css" />">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script>
        var airTimeStamp = ${episode.airTime.getTime()};
    </script>
    <script src="<c:url value="/js/episode.js"/> "></script>
</head>
<body>
<%@include file="/includes/menu.jsp"%>

<div class="content">
    <b><h1>${series.title}</h1></b> </br>
    <b>${season.id}. évad</b> </br>
    <b>${episode.id}. epizód | ${episode.title}</b> </br></br>

    Adás: <span id="airTime"></span>

    <h3>Színészek:</h3>
    <table>
        <tr>
            <th>Név</th>
        </tr>
        <c:forEach items="${episode.actors}" var="actor">
            <tr>
                <td><a href="<c:url value="/" />actor/${actor.name}">${actor.name}</a> </td>
            </tr>
        </c:forEach>
    </table>
</div>
<footer>

</footer>
</body>
</html>
