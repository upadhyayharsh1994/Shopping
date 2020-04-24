<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Signin Page</title>

 <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <!-- <link href="css/signin.css" rel="stylesheet"> -->
</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
<div class="container">
	 
	  <br>
	
      <form class="form-signin" method="get" action="<%=request.getContextPath()%>/addUser">
      
			 <%
			session.setMaxInactiveInterval(2);
			%>
 			<script type="text/javascript">
			var message ='<%=session.getAttribute("getAlert")%>';
    		if (message != "null") {
 			function alertName(){
 				alert("Wrong Email/Password");
 				} 
 			}
 			</script>  
      
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="hidden" name="flag" value="search">
        
        <div class="form-group">
        <label for="inputEmail"  class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required autofocus>
        </div>
        <br>
        <div class="form-group">
        <label for="inputPassword"  class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        </div>
    
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-primary btn-lg" type="submit">Login</button>
        
        <div class="form-group">
	<div class="row">
		<div class="col-lg-12">
			<div class="text-center">
				<a href="Registration.jsp" tabindex="5" class="forgot-password">New User? Click here to register</a>
			</div>
		</div>
	</div>
</div>
      <jsp:include page="footer.jsp"></jsp:include>
      <script type="text/javascript"> window.onload = alertName; </script>
      </form>

    </div> <!-- /container -->
</body>
</html>