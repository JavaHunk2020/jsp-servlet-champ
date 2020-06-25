<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
	</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style type="text/css">

.semere {
	display: block;
	margin-left: auto;
	margin-right: auto;
}
</style>


</head>
<body>
	<header style="background-color: #03a9f4; height: 30px;">
	   <b>Address : = ${applicationScope.address}</b> 
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	 </header>
	<div  class="container">
	     <hr style="border-top: 5px solid rgba(103,58,183,1);"/>
		<img id="studentImage"  src="img/acccedenied.jpg" class="semere"  style="height: 300px;">
		<form  action="auth" method="post">
		<div  class="semere"   style="width: 50%">
		 <span  id="message"  style="color:red;font-size: 16px;font-weight: bold;">
		  Sorry! you are now allowed to access the page  
		 </span>
		   <hr/>
		 			<br/>
		<a href="login.jsp"><button type="button" class="btn btn-info">Click here to Sign In</button></a>
		</div>
		</form>
	</div>

</body>
</html>