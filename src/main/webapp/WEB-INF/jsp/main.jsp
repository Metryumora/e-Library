<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Metr_yumora
  Date: 05.12.2016
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
                <li class="active"><a href="/">Home</a></li>
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
            <c:if test="${loggedin==false}">
                <form class="navbar-form navbar-right" method="post" action="/login">
                    <div class="form-group">
                        <input type="text" required placeholder="Login" class="form-control" name="login">
                    </div>
                    <div class="form-group">
                        <input type="password" required placeholder="Password" class="form-control" name="password">
                    </div>
                    <button type="submit" class="btn btn-success">Sign in</button>
                    <a class="btn btn-success" href="/sign_up">Register</a>
                </form>
            </c:if>
            <c:if test="${loggedin==true}">
                <ul class="nav navbar-nav">
                    <li><a href="/downloads">Downloads</a></li>
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
<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <c:if test="${loggedin==true}">
            <h1>Greetings, ${username}!</h1>
        </c:if>
        <c:if test="${loggedin==false}">
            <h1>Greetings, reader!</h1>
        </c:if>
        <c:if test="${registrationSuccessful==true}">
            <p>
            <div class="alert alert-success" role="alert">${message}</div>
            </p>
        </c:if>
        <c:if test="${registrationSuccessful==false}">
            <p>
            <div class="alert alert-danger" role="alert">${message}</div>
            </p>
        </c:if>
        <c:if test="${registrationSuccessful==null && loginSuccessful==null}">
            <p>${message}</p>
        </c:if>
        <c:if test="${loginSuccessful==true}">
            <p>
            <div class="alert alert-success" role="alert">${message}</div>
            </p>
        </c:if>
        <c:if test="${loginSuccessful==false}">
            <p>
            <div class="alert alert-danger" role="alert">${message}</div>
            </p>
        </c:if>
        <%--<p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>--%>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div id="myCarousel" class="carousel slide" style="width: 500px; margin: auto" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>
        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <center><img src="img/codexr.jpg"></center>
                <div class="carousel-caption">
                    <%--<h3>Codex Seraphinianus</h3>--%>
                    <%--<p>Originally published in 1981, is an illustrated encyclopedia of an imaginary world, created by--%>
                    <%--the Italian artist, architect, and industrial designer Luigi Serafini during thirty months, from--%>
                    <%--1976 to 1978.</p>--%>
                </div>
            </div>

            <div class="item">
                <center><img src="img/1984r.jpg"></center>
                <div class="carousel-caption">
                    <%--<h3>1984</h3>--%>
                    <%--<p>--%>
                    <%--Nineteen Eighty-Four, often published as 1984, is a dystopian novel by English author George--%>
                    <%--Orwell published in 1949.--%>
                    <%--</p>--%>
                </div>
            </div>

            <div class="item">
                <center><img src="img/devilinthedetailsr.jpg"></center>
                <div class="carousel-caption">
                    <%--<h3>Devil in Details</h3>--%>
                    <%--<p>--%>
                    <%--Recalling the agony of growing up as an obsessive-compulsive religious fanatic, Traig fearlessly--%>
                    <%--confesses the most peculiar behaviour - like scrubbing her hands for a full half-hour before--%>
                    <%--meals, feeding her stuffed animals before herself, and washing everything she owned because she--%>
                    <%--thought it was contaminated by pork fumes!--%>
                    <%--</p>--%>
                </div>
            </div>

            <div class="item">
                <center><img src="img/Enchantmentr.jpg"></center>
                <div class="carousel-caption">
                    <%--<h3>Enchantment</h3>--%>
                    <%--<p>--%>
                    <%--Enchantment, as defined by bestselling business guru Guy Kawasaki, is not about manipulating--%>
                    <%--people. It transforms situations and relationships. It con­verts hostility into civility and--%>
                    <%--civility into affinity. It changes skeptics and cynics into believers and the undecided into the--%>
                    <%--loyal.--%>
                    <%--</p>--%>
                </div>
            </div>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
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

