<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
   <header  style="height: 30px;background-color: #21c9ff;">
   <b style="margin-left: 50px;">Coming soon </b>
   </header>
    <div  class="container">
         <!-- sessionScope  is called implicit EL object -->
         <img src="img/student.png"  style="height: 139px">
                
                <button type="button" class="btn btn-primary">Manage Users</button>
   				  <button type="reset" class="btn btn-danger">Email</button>
   				            <a href="profiles">
   				  	        <button type="button" class="btn btn-success">Profiles</button>
   				  	        </a>
   				  	        <button type="button" class="btn btn-warning">Block Times</button>
   				  	  <a href="logout"> 
   				  	        <button type="button" class="btn btn-warning">Logout</button>
   				  	 </a>
         <hr/>
         <table class="table table-bordered">
   				  	 		<tr>
   				  	 				<td>Name</td>
   				  	 				<td>${sessionScope.userData.name}</td>
   				  	 		</tr>
   				  	 			<tr>
   				  	 				<td>Email</td>
   				  	 				<td>${userData.email}</td>
   				  	 		</tr>
   				  	 			<tr>
   				  	 				<td>Username</td>
   				  	 				<td>${userData.username}</td>
   				  	 		</tr>
   				  	 			<tr>
   				  	 				<td>Gender</td>
   				  	 				<td>${userData.gender}</td>
   				  	 		</tr>
   				  	 			<tr>
   				  	 				<td>Mobile</td>
   				  	 				<td>${userData.mobile}</td>
   				  	 		</tr>
   				  	 			<tr>
   				  	 				<td>Photo</td>
   				  	 				<td>
   				  	 				 <img src="${userData.photo}" style="height: 200px;"/>
   				  	 				</td>
   				  	 		</tr>
   				  	 </table>
    </div>
   
  
</body>
</html>