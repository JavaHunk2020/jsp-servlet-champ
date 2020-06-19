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
        <form  action="usignup" method="post">
         <input type="hidden" name="username"  value="${profileDTO.username}" >
        <div  class="semere"   style="width: 50%">
         <span  id="message"  style="color:red;font-size: 16px;font-weight: bold;">
           <marquee scrolldelay="100" direction="right"> Edit Signup Page</marquee>  
         </span>
           <hr/>
                    <label for="name">Name</label>
                    <input type="text" name="name" class="form-control"   value="${profileDTO.name}">
                       <label>Email</label>
                    <input type="email" name="email" class="form-control"  value="${profileDTO.email}">
                       <label>Qualification</label>
                    <select name="qualification" class="form-control">
                        <option ${profileDTO.qualification=='BCA' ? 'selected':''}>BCA</option>
                        <option ${profileDTO.qualification=='MCA' ? 'selected':''}>MCA</option>
                       <option ${profileDTO.qualification=='M.S.' ? 'selected':''}>M.S.</option>
                        <option ${profileDTO.qualification=='B.Tech' ? 'selected':''}>B.Tech</option>
                    </select>
                     <br/>
                    <label for="mobile">Mobile</label>
                    <input type="number" name="mobile" class="form-control"   value="${profileDTO.mobile}">
                      <label>Gender</label>
                    <select name="gender" class="form-control">
                        <option ${profileDTO.gender=='Male' ? 'selected':''}>Male</option>
                              <option ${profileDTO.gender=='Female' ? 'selected':''}>Female</option>
                    </select>
                    
                      <label for="photo">Photo</label>
                     <input type="text" name="photo" class="form-control" value="${profileDTO.photo}">
                      <img   src="${profileDTO.photo}" class="semere"  style="height: 50px;">
                     <br/>
                        <button type="submit" class="btn btn-info">Update</button>
                        
                        <a href="login.jsp">
                            <button type="button" class="btn btn-primary">Sign In</button>
                        </a>
     
                    <a href="forgotPassword.jsp"><button type="button" class="btn btn-primary">Forget Password</button></a>
            </div>
        </form>
    </div>

</body>
</html>