<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html lang="en">
	<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width,initial-scale=1">
        
        <title>Note Taking App</title>
		<link href="/tech/styles/main.css" rel="stylesheet" />
		<script type="text/javascript" src="../scripts/jquery-1.8.1.js"></script>
		<script type="text/javascript" src="../scripts/tinymce/tinymce.min.js"></script>
        <script type="text/javascript">
            tinymce.init({
            selector: "textarea"         
            });
        </script>
		<script type="text/javascript">
			$("#notes").val(${review.getNotes()});
			$("#review").val(${review.getReview()});
			
			function saveText(){
				$.ajax({
			        url: document.URL+"/Save?notes='"+tinymce.get('notes').getContent()+"'&review='"+tinymce.get('review').getContent()+"'",
			        type: "POST",
			        timeout: 5000,
			        contentType: "application/json",
			        success: function (result) {},
			        error: function () {}
			    });
			}
		</script>
	
	</head>
	<body>
	  <div class ="titleWrapper">
        <h1>Student Note Taker</h1>
       </div>
		<nav>
			<a href="library">Library</a>
			<a href="Read">Essay</a>
			<a href="logout">Logout</a>
		</nav>
		<div>
			<input type="submit" value="Save" onclick="saveText()" />
		</div>
		<div class="block">
            <textarea id="notes" class="notesBox" name="noteBox" placeholder="Start writing here" required></textarea>
        </div>
        <div class="block">
            <textarea id="review" class="writeBox" name="writeBox" placeholder="Start taking notes here!" required></textarea>
        </div>
        
	</body>
</html>