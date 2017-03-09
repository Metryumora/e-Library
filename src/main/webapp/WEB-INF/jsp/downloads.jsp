<%--
  Created by IntelliJ IDEA.
  User: Supreme
  Date: 09.12.2016
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Welcome to e-Library!</title>

    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/jumbotron.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link href="css/custom.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">e-Library</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Books <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/books">All books</a></li>
                        <li><a href="/month_popular_books">Popular books this month</a></li>
                        <li><a href="/year_popular_books">Popular books this year</a></li>
                    </ul>
                </li>
                <li><a href="/about">About</a></li>
                
            </ul>
            <c:if test="${loggedin==true}">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/downloads">Downloads</a></li>
                    <li><a>Welcome, ${username}!</a></li>
                    <li>
                        <form class="navbar-form navbar-right" method="post" action="/logout">
                            <button type="submit" class="btn btn-success">Log out</button>
                        </form>
                    </li>
                </ul>
            </c:if>

        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="jumbotron">
    <div class="container">
        <h1>Downloads</h1>
        <p>Here you can see your downloads history.</p>
        <%--<p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>--%>
    </div>
</div>
<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <table class="table">
            <tbody>
            <tr>
                <th>Name</th>
                <th>Author</th>
                <th>Link</th>
                <th>Downloaded</th>
                <c:forEach items="${downloads}" var="download">
            <tr>
                <td>${download.getBook().getName()}</td>
                <td>${download.getBook().getStringAuthors()}</td>
                <td>
                    <form action="/download" method="post">
                        <input name="bookId" type="text" hidden value="${download.getBook().getId()}">
                        <input class="download-submit" value="" type="submit">
                    </form>
                </td>
                <td><fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"
                                    value="${download.getDownloadTimestamp()}"/></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="container">
        <form class="navbar-right" action="/deactivate_downloads" method="post">
            <button class="btn btn-primary" onclick="parentNode.submit()">Clear history</button>
        </form>
    </div>

    <hr>

    <footer>
        <p>&copy; 2016 Supreme Development, Inc.</p>
    </footer>
</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="dist/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

