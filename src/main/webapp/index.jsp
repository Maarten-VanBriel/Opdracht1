<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Home</title>
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
			<h2>Home</h2>

		</header>
		<main>
			<p>
				Sed ut perspiciatis unde omnis iste natus error sit
				voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque
				ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae
				dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit
				aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos
				qui ratione voluptatem sequi nesciunt.
			</p>
			<c:if test="${errors != null}">
				<div class="alert-danger">
					<p>No valid userid/password</p>
				</div>
			</c:if>
			<c:if test="${person == null}">
				<form method="post" action="Controller?command=Login" novalidate="novalidate">
					<p>
						<label for="userid">User id</label>
						<input type="text" id="userid" name="userid" required>
					</p>
					<p>
						<label for="password">Password</label>
						<input type="password" id="password"  name="password" required>
					</p>
					<p>
						<input type="submit" id="logIn" value="Log in">
					</p>

				</form>
			</c:if>
			<c:if test="${person != null}">
				<p>Welcome, ${person.firstName}</p>
				<form method="post" action="Controller?command=Logout">
					<input type="submit" id="logOut" value="Log out">
				</form>
				<form method="post" action="Controller?command=Confirmation">
					<input type="submit" id="confirmation" value="Delete account">
				</form>
			</c:if>

		</main>
		<footer> &copy; Webontwikkeling 3, UC Leuven-Limburg </footer>
	</div>
</body>
</html>