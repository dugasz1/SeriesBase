<%--
  Created by IntelliJ IDEA.
  User: dudu
  Date: 2017.11.29.
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>${actor.name}</title>
    <%@include file="/includes/meta.jsp"%>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="<c:url value="/js/actors.js" />" ></script>
</head>
<body>
<%@include file="/includes/menu.jsp"%>

<div class="content">
    <b>Színész: ${actor.name}</b> <br>
    <b>Neme: ${actor.gender}</b>
</div>
<footer>

</footer>
</body>
</html>
