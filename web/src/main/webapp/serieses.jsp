<%--
  Created by IntelliJ IDEA.
  User: Dudu
  Date: 2017. 11. 26.
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sorozat kezelő</title>

    <%@include file="/includes/meta.jsp"%>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.min.js" integrity="sha384-FzT3vTVGXqf7wRfy8k4BiyzvbNfeYjK+frTVqZeNDFl8woCbF0CYG6g2fMEFFo/i" crossorigin="anonymous"></script>
    <script src="js/series.js" ></script>
</head>
<body>
<%@include file="/includes/menu.jsp"%>
<div class="content">
    <h1>Sorozat keresése:</h1>
    <form id="seriesSearchForm">
        <label>Adja meg a sorozat nevét: </label>
        <input type="text" id="searchTitle" />
    </form>

    <table id="seriesSearchResult" border="1">

    </table>

    <span class="hr-line" />

    <h1>Sorozat hozzáadása:</h1>
    <form id="seriesAddForm">
        <label>Adja meg a sorozat címét: </label>
        <input type="text" id="seriesTitle" required/>
        <label>Adja meg az érékelést (0-10): </label>
        <input type="number" id="seriesRating" required/>
        <label>Adja megy egy rész átlagos hosszát:</label>
        <input type="number" id="seriesDuration" required/>
        <button type="submit">Hozzáad</button>
    </form>

    <div id="seriesAddResult" style="color: red;">

    </div>

    <span class="hr-line" />
</div>
<footer>

</footer>
</body>
</html>

