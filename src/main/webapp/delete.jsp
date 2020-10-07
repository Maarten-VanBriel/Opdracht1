<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Delete</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
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
        <h2>Delete</h2>

    </header>
    <main>
        <c:if test="${errors != null}">
            <div class="alert-danger">
                <ul>
                    <c:forEach items="${errors}" var="message">
                        <li>${message}</li>
                    </c:forEach>

                </ul>
            </div>
        </c:if>
        <p>Are you sure you want to delete your account? By doing this you will nog longer be in the contact tracing program.</p>
        <form method="post" action="Controller?command=Delete">
            <input type="submit" id="delete" value="Yes">
        </form>
        <form method="post" action="Controller">
            <input type="submit" id="no" value="No">
        </form>
    </main>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg </footer>
</div>
</body>
</html>