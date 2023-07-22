<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="icon" href="login-icon.png" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="signup.css">
    <link rel="icon" href="login-icon.png" type="image/x-icon">
	<title>Signup</title>
	<script>
     function validateForm() {
    	  var em = document.getElementById("email").value;
    	  var nm = document.getElementById("name").value;
    	  var mob = document.getElementById("mobile").value;
    	  var pas = document.getElementById("password").value;
		  console.log(em);
    	  if (em == "") {
    	    alert("Email must be filled out");
    	    return false;
    	  }
    	  else if(nm.length<3){
    		  alert("Enter a valid name");
    		  return false;
    	  }
    	  else if(mob.length!=10){
    		  alert("Enter a valid mobile no.");
    		  return false;
    	  }
    	  else if(pas.length<8 || pas.length>16){
    		  alert("password must be in 8 to 16 characters");
    		  return false;
    	  }
    	}
     </script> 
</head>
<body>
	<section>
	        <div class="form-box">
	            <div class="form-value">
	                <form action="signup" method="post" onsubmit="return validateForm()">
	                    <h2>Sign Up</h2>
	                    <div class="inputbox">
	                        <input type="text" name="name" id="name"required>
	                        <label for="">First Name</label>
	                        <hr>
	                    </div>
	                    
	                    <div class="inputbox">
	                        <ion-icon name="mail-outline"></ion-icon>
	                        <input type="email" name="email" id="email" required>
	                        <label for="">Email</label>
	                        <hr>
	                    </div>
	                    <div class="inputbox">
	                        <ion-icon name="call-outline"></ion-icon>
	                        <input type="phoneno" name="mobile" id="mobile" required>
	                        <label for="">Phone no.</label>
	                        <hr>
	                    </div>
	                    <div class="inputbox">   
	                        <ion-icon name="lock-closed-outline"></ion-icon>
	                        <input type="password" id="password" name="pass" required>
	                        <label for="">Password</label>
	                        <hr>
	                    </div>
	                    <div class="inputbox">
	                        <ion-icon name="lock-closed-outline"></ion-icon>
	                        <input type="password" id="confirm_password" required>
	                        <label for="">Confirm Password</label>
	                        <hr>
	                    </div>
	                    <button type="submit">Create Account</button>
	                    <div class="register">
	                        <p>Already have an account? <a href="login.html">Login</a></p>
	                    </div>
	                </form>
	            </div>
	        </div>
	    </section>
	    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>