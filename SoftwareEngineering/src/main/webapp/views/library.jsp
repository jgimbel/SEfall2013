<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>

<html lang="en">
	<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width,initial-scale=1">
        
        <title>Note Taking App</title>
		<link href="/tech/styles/main.css" rel="stylesheet" />
	</head>

    <body>
        <div class ="titleWrapper">
            <h1>Library</h1>
            <h3>Select an article</h3>
        </div>
        <nav>
			<a href="Read">Writing</a>
			<a href="library">Library</a>
			<a href="logout">Logout</a>
		</nav>
		
		<section class="submitForm cf">
		     <h3>Add Article</h3>
		     <form name="addArticle" action="Read/article" method="POST" accept-charset="utf-8"> 
		        <ul>
		            <li><label for="title">Article Title</label>  
		                <input type="text" name="title" placeholder="Place Title here" required></li>  
		            <li><label for="url">Article URL</label>  
		                <input type="url" name="url" placeholder="Place URL here" required></li>
		            <li>
		            	<select name="class">
            				<option value="1">Class 1</option>
            				<option value="2">Class 2</option>
            				<option value="3">Class 3</option>
        				</select> 
       				</li>
		            <li><input type="submit" value="submit"><a href=" ">Cancel</a></li>
		        </ul>
		    </form>
		</section>
        
        <c:forEach items="${library}" var="article">
	        <section id="articleTemplete">
	                <div  class="articletitle">${article.getTitle()}</div>
	                <div class="articleURL"><a href="${article.getURL()}">${article.getURL()}</a></div>
	        </section>
        </c:forEach>
    </body>
</html>