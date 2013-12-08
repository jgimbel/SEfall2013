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
			<a href="teach.jsp">Classes</a>
			<a href="library.jsp">Library</a>
			<a href="home.jsp">Logout</a>
		</nav>
		
     <a class="button" href="addStudent.jsp"><button>Add New Student</button></a>
        
        <label>Select a class</label>
        <select name="classList">
            <option value="1">Class 1</option>
            <option value="2">Class 2</option>
            <option value="3">Class 3</option>
        </select>
        
         <!-- Variable Explanation -->
        <!-- $fname = Studnet's First Name
             $lname = Student's Last Name
             $class = The class the student is in. Should also match the dropdown list above
             $email = Student's Email address 
             $savedWork = A way to access the student's notes and writing may need addtional reasources for this-->
        <section id="studentTemplate">
            <div class="name">$fname $lname</div>
            <div class="class">$class</div>
            <div class="email">$email</div>
            <div class="work">$savedWork</div>
        </section>

    </body>
</html>