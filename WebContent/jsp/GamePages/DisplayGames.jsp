<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<% List gamesList = (List)session.getAttribute("games");
request.setAttribute("games", gamesList);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game Details</title>

<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../../partials/menu.jsp" />
<h1 class="title">Game Details</h1>
<hr size="4" color="gray"/>
<div>
		<form name="searchGame" action="${pageContext.request.contextPath}/Game/List" method="GET" onSubmit="" style="display:flex">
			<select name="searchType" id="console">
				<option value="name" selected>Game Name</option>
				<option value="console">Game Console</option>
				<option value="type">Game Type</option>
			</select>
			<input class="input" type="text" name="searchString" placeholder="Search for..." id="name">
			<input type="submit" value="Search">
	</form>
</div>
<table class="table">
  <thead>
    <tr>
      <th><abbr title="Id">Id</abbr></th>
      <th><abbr title="Name">Name</abbr></th>
      <th><abbr title="Year">Year</abbr></th>
      <th><abbr title="Cost">Cost</abbr></th>
      <th><abbr title="Console">Console</abbr></th>
      <th><abbr title="Type">Type</abbr></th>
      <th><abbr title="Description">Description</abbr></th>
      <th><abbr title="Action">Action</abbr></th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${games}" var="game">
        <tr>
        	<td><c:out value="${game.id}"/></td>
            <td><c:out value="${game.name}"/></td>
            <td><c:out value="${game.year}"/></td>
            <td><c:out value="${game.cost}"/></td>
            <td><c:out value="${game.console}"/></td>  
            <td><c:out value="${game.type}"/></td>  
            <td><c:out value="${game.description}"/></td>
            <td><a href="${pageContext.request.contextPath}/Game/List?id=${game.id}">Edit</a></td>
            <td><a href="${pageContext.request.contextPath}/Game/delete?id=${game.id}">Delete</a></td>
        </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>