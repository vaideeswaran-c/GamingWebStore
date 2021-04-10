<!DOCTYPE html>

<html>
<head>
<title>Game Add Page</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../../partials/menu.jsp" />
	<h2>Add games to the store</h2>
	<form name="addGame" action="${pageContext.request.contextPath}/Game" method="POST" onSubmit="">
		<div class="field">
			<label class="label" for="name">Name:</label> 
			<input class="input" type="text" name="game_name" placeholder="Name" id="name" required>
		</div>
		<div class="field">

			<label class="label" for="year">Year Published:</label> 
			<input class="input" type="text" name="game_year" placeholder="Year" id="year" required  onkeypress="return isNumberKey(event)">
		</div>
		<div class="field">
			<label class="label" for="cost">Cost:</label> 
			<input class="input" type="text" name="game_cost" placeholder="Cost" id="cost" required  onkeypress="return isNumberKey(event)">
		</div>
		<div class="field">
			<label class="label" for="console">Console:</label> 
			<select name="game_console" id="console" required>
				<option value="Playstation 3">Playstation 3</option>
				<option value="Playstation 4">Playstation 4</option>
				<option value="Xbox One">Xbox One</option>
				<option value="Xbox 360">Xbox 360</option>
				<option value="Nintendo Wii">Nintendo Wii</option>
				<option value="Nintendo Switch">Nintendo Switch</option>
				<option value="Other">Other</option>
			</select>
		</div>
		<div class="field">
			<label class="label">Type:</label> <input type="radio" name="game_type" id="dvd" value="dvd" checked>
			<label class="label" for="dvd">DVD</label> 
			<input type="radio" name="game_type" id="digital" value="digital"> <label class="label" for="digital">Digital</label>
		</div>
		<div class="field">
			<label class="label" for=""description"">Description:</label>
			<textarea class="textarea" rows="3" cols="30" name="game_description" id="description"></textarea>
		</div>
		<input type="hidden" name="action" value="add"/>
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