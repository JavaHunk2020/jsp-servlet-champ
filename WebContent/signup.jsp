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
        <img id="studentImage"  src="img/signup.png" class="semere"  style="height: 100px;">
        <form  action="signup" method="post">
        <div  class="semere"   style="width: 50%">
         <span  id="message"  style="color:red;font-size: 16px;font-weight: bold;">
           <marquee scrolldelay="100" direction="right"> Signup Page</marquee>  
         </span>
           <hr/>
                    <label for="name">Name</label>
                    <input type="text" name="name" class="form-control" >
                       <label>Email</label>
                    <input type="email" name="email" class="form-control">
                       <label>Qualification</label>
                    <select name="qualification" class="form-control">
                        <option>BCA</option>
                        <option>MCA</option>
                        <option>MS</option>
                        <option>B. Tech</option>
                    </select>
                     <br/>
                    <label for="mobile">Mobile</label>
                    <input type="number" name="mobile" class="form-control" >
                      <label>Gender</label>
                    <select name="gender" class="form-control">
                        <option>Male</option>
                        <option>Female</option>
                    </select>
                    
                      <label for="photo">Photo</label>
                    <input type="text" name="photo" class="form-control" >
                     <br/>
                        <button type="submit" class="btn btn-info">Sign Up</button>
                        
                        <a href="login.jsp">
                            <button type="button" class="btn btn-primary">Sign In</button>
                        </a>
     
                    <a href="forgotPassword.jsp"><button type="button" class="btn btn-primary">Forget Password</button></a>
            </div>
        </form>
    </div>

</body>
</html>