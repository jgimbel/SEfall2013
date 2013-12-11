<!DOCTYPE HTML>
<html lang="en">
	<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width,initial-scale=1">
        
        <title>Note Taking App</title>
		<link href="/tech/styles/main.css" rel="stylesheet" />
		
		 <script type="text/javascript" src="../scripts/tinymce/tinymce.min.js"></script>
        <script type="text/javascript">
            tinymce.init({
            selector: "textarea",
           
            });
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
			<div class="block">
            <textarea class="notesBox" name="noteBox" placeholder="Start writing here" required></textarea>
        </div>
        <div class="block">
            <textarea class="writeBox" name="writeBox" placeholder="Start taking notes here!" required></textarea>
        </div>
	</body>
</html>