<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Page</title>
 <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">


<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="p" %>
   <p:forEach items="${sessionScope.profileData}" var="i">
    <h1>Welcome ${i.name}</h1>   
    <h3>Name: ${i.name}</h3>
    <h3>Address1: ${i.address1}</h3>
    <h3>Address2: ${i.address2}</h3>
    <h3>City: ${i.city}</h3>
    <h3>State: ${i.state}</h3>
    <h3>Zip: ${i.zip}</h3>
    
    </p:forEach>

<jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>