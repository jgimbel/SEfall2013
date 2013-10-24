<%@ page session="false" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${context}/tech/styles/main.css">
	<title>Home</title>
</head>
<body>
<a href="login?ID=5,Name='Joel'">Login Here</a>
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

</body>
</html>
