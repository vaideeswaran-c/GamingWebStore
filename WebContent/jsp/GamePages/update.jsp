<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Map"%>
<%@ page import="com.ilp.beans.Game"%>
<!DOCTYPE html>

<% Game game1 = (Game)session.getAttribute("game");
	request.setAttribute("game1", game1);
%>
<html>
<head>
<title>Game update page</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="../../partials/menu.jsp" />
	<h2>update games in the store</h2>
	<form name="update_game"  action="${pageContext.request.contextPath}/Game" method="POST" onSubmit="">
		<div class="field">
			<label for="name">Name:</label> <input type="text" name="game_name" value="${game1.name}" required
				placeholder="Name" id="name">
		</div>
		<div class="field">
			<label for="year">Year Published:</label> <input type="text" value="${game1.year}"  required  onkeypress="return isNumberKey(event)"
				name="game_year" placeholder="Year" id="year">
		</div>
		<div class="field">
			<label for="cost">Cost:</label> <input type="text" name="game_cost" value="${game1.cost}"  required  onkeypress="return isNumberKey(event)"
				placeholder="Cost" id="cost">
		</div>
		<div class="field">
			<label for="console">Console:</label> <select name="game_console"
				id="console">
				<option value="Playstation 3" ${game1.console == 'Playstation 3' ? 'selected' : ''}>Playstation 3</option>
				<option value="Playstation 4" ${game1.console == 'Playstation 4' ? 'selected' : ''}>Playstation 4</option>
				<option value="Xbox One" ${game1.console == 'Xbox One' ? 'selected' : ''}>Xbox One</option>
				<option value="Xbox 360" ${game1.console == 'Xbox 360' ? 'selected' : ''}>Xbox 360</option>
				<option value="Nintendo Wii" ${game1.console == 'Nintendo Wii' ? 'selected' : ''}>Nintendo Wii</option>
				<option value="Nintendo Switch" ${game1.console == 'Nintendo Switch' ? 'selected' : ''}>Nintendo Switch</option>
				<option value="Other" ${game1.console == 'Other' ? 'selected' : ''}>Other</option>
			</select>
		</div>
		<div class="field">
			<label>Type:</label> 
			<input type="radio" name="game_type" id="dvd" value="dvd" ${game.type == 'dvd' ?'checked' : ''}>
			<label for="dvd">DVD</label> 
			<input type="radio" name="game_type" id="digital" value="digital" ${game.type == 'digital' ?'checked' : ''}>
			<label for="digital">Digital</label>
		</div>
		<div class="field">
			<label for="description">Description:</label>
			<textarea rows="3" cols="30" name="game_description" id="description" value="${game1.description}"></textarea>
		</div>
		<input type="hidden" name="game_id" value="${game.id}"><br/>
		<input type="hidden" name="action" value="update"/>
		<input type="submit" value="Submit">
	</form>
	<script>
		function isNumberKey(evt){
	    	var charCode = (evt.which) ? evt.which : evt.keyCode
	    	if (charCode > 31 && (charCode != 46 &&(charCode < 48 || charCode > 57))){
	    		return false;
	    	}
	    	return true;
		}
	</script>
</body>
</html>