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
        <h1>Instructor View</h1>
        </div>
        <nav>
			<a href="teach">Classes</a>
			<a href="library">Library</a>
			<a href="logout">Logout</a>
		</nav>
		
     <a class="button" href="addStudent"><button>Add New Student</button></a>
        <form name="SelectClass" action="teach" method="GET" accept-charset="utf-8">
        <label>Select a class</label>
			<select name="class">
				<option value="0">All</option>
				<c:forEach items="${classes}" var="item">
					<option value="${item.getID()}">${item.getName()}</option>
				</c:forEach>
			</select> 
			<input type="submit" value="Select" />
        </form>
         <!-- Variable Explanation -->
        <!-- $fname = Studnet's First Name
             $lname = Student's Last Name
             $class = The class the student is in. Should also match the dropdown list above
             $email = Student's Email address 
             $savedWork = A way to access the student's notes and writing may need addtional reasources for this-->
	    <c:forEach items="${students}" var="person">
	        <section id="studentTemplate">
	            <div class="name">${person.getFirstName()} ${person.getLastName()}</div>
	            <div class="email">${person.getEmail()}</div>
	        </section>
		</c:forEach>
    </body>
</html>