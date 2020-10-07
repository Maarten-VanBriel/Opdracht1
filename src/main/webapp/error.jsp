<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/sample.css">
    <meta charset="UTF-8">
    <title>Countries</title>
</head>
<body>
<div id="container">
    <header>
        <h1>
            <span>XXX</span>
        </h1>
        <nav>
            <ul>
                <li id="actual"><a href="Controller">Home</a></li>
                <li><a href="Controller?command=Overview">Overview</a></li>
                <li><a href="Controller?command=Register">Register</a></li>
            </ul>
        </nav>
        <h2>Home</h2>

    </header>
    <main>	<article>
    </article>
        <p>${error}</p>
    </main>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg </footer>
</div>

</body>
</html>
