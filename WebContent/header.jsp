
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
     <div class="container">
      <a class="navbar-brand" href="index.jsp">Shopify</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
          </li>
		  
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle active" href="<%=request.getContextPath()%>/fetchData?flag=search" id="dropdown01" data-toggle="dropdown">Categories</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
            <%-- <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
			    <c:forEach items="${sessionScope.categoryData}" var="x">
                   <option value="${x.categoryId }">${x.categoryName }</option>
			    </c:forEach> --%>
			   <a class="dropdown-item" href="<%=request.getContextPath()%>/fetchData?flag=phoneSearch">Cell phones</a>
            </div>
          </li>
          
          <li class="nav-item active">
            <a class="nav-link" href="contactUs.jsp">Contact Us <span class="sr-only">(current)</span></a>
          </li>
  
        </ul>
        
     <ul class="nav navbar-nav navbar-right">
   	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
   	<c:if test="${sessionScope.profileData == null}">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle active" href="#" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Your Account</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
        	<a class="dropdown-item" href="Registration.jsp">Signup</a>
        	<a class="dropdown-item" href="login.jsp">Login</a>
        </div>
	  </li>	
	  </c:if>
	  <c:if test="${sessionScope.profileData != null}">
	     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="p" %>
	     <p:forEach items="${sessionScope.profileData}" var="i">
   		 <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle active" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>${i.name}</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
        	<a class="dropdown-item" href="profile.jsp">Profile</a>
        	<a class="dropdown-item" href="<%=request.getContextPath()%>/addUser?flag=logout">Logout</a>
        </div>
   		</li>
   		</p:forEach>
   		</c:if>
   		<c:choose>
   			<c:when test="${sessionScope.sizeKey != null}">
  			<% int size = Integer.parseInt(session.getAttribute("sizeKey").toString());%>
  				<li><a class="glyphicon glyphicon-shopping-cart" href="<%=request.getContextPath()%>/addToCart?flag=cartDisplay"><span class="badge"></span><%=size %></a></li>
  			</c:when>
  			<c:otherwise>
   				<li><a class="glyphicon glyphicon-shopping-cart" href="<%=request.getContextPath()%>/addToCart?flag=cartDisplay"><span class="badge"></span>0</a></li>
  			</c:otherwise>
  		</c:choose>		
 </li>
      </ul>
      </div>
    </div>
    </nav>
</body>
</html>