<!DOCTYPE HTML>

<html lang="en">
        <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width,initial-scale=1">
        
        <title>Note Taking App</title>
        <link href="../styles/main.css" rel="stylesheet" />
        </head>
 
    <body>
        <div class ="titleWrapper">
        <h1>Instructor View</h1>
        <h3>Add New Student</h3>
        </div>
        <nav>
			<a href="teach">Classes</a>
			<a href="library">Library</a>
			<a href="logout">Logout</a>
		</nav>
        
<section class="submitForm cf"> 
     <form name="addStudent" action="addStudentSubmit" method="POST" accept-charset="utf-8"> 
        <ul>
            <li><label for="name">First Name</label>  
                <input type="text" name="firstname" placeholder="First Name" required></li>  
            <li><label for="name">Last Name</label>  
                <input type="text" name="lastname" placeholder="Last Name" required></li>  
            <li><label for="name">Class</label> 
                <input type="text" name="class" placeholder="Class" required></li>  
            <li><label for="email">Email</label> 
                <input type="email" name="usermail" placeholder="Email" required></li>  
            <li><label for="password">Password</label> 
                <input type="password" name="password" placeholder="Password" required></li>
            <li><input type="submit" value="submit"><a href="teach">Cancel</a></li>
        </ul>
    </form>
</section>
    </body>
</html>