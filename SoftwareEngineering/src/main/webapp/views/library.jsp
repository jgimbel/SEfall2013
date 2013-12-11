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
     <form name="addArticle" action="" method="POST" accept-charset="utf-8"> 
        <ul>
            <li><label for="title">Article Title</label>  
                <input type="text" name="title" placeholder="Place Title here" required></li>  
            <li><label for="url">Article URL</label>  
                <input type="url" name="url" placeholder="Place URL here" required></li>
            <li><input type="submit" value="submit"><a href=" ">Cancel</a></li>
        </ul>
    </form>
</section>
        
        <!-- Variable Explanation -->
        <!-- $articleTitle = The Given title of the Article
             $articleURL = Url to get to articel-->
        <c:forTokens items="Times,Subtract,Add,Power" delims="," var="articleTitle">
	        <section id="articleTemplete">
	                <div href="${articleURL}" class="articletitle">${articleTitle}</div>
	                <div class="articleURL"></div>
	        </section>
        </c:forTokens>
    </body>
</html>