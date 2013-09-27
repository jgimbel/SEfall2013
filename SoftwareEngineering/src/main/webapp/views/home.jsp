<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${context}/tech/styles/main.css">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<input id=notes type="text" />
<script>
var oldtext = $('#notes').val();
function save(){
	while(true){
	if($('#notes').val() != oldtext){
		oldtext = $('#notes').val();
	}
}
}	
</script>

<P>  The time on the server is ${serverTime}. </P>
<a href="login?ID=5,Name='Joel'">Login Here</a>
</body>
</html>
