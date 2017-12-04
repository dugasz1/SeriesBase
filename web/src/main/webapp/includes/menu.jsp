<%--
  Created by IntelliJ IDEA.
  User: Dudu
  Date: 2017. 11. 22.
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <ul class="menu">
        <li><a href="<c:url value="/indexOld.jsp"/> "><span><i class="fa fa-home" aria-hidden="true">&nbsp; Kezdőlap</i></span></a></li>
        <li><a href="<c:url value="/actors.jsp"/> "><span><i class="fa fa-address-book" aria-hidden="true">&nbsp; Színészek</i></span></a></li>
        <li><a href="<c:url value="/serieses.jsp"/> "><span><i class="fa fa-film" aria-hidden="true">&nbsp; Sorozatok</i></span></a></li>
    </ul>
</nav>