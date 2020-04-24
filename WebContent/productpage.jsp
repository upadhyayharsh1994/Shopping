<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">
<!--     <link href="css/3-col-portfolio.css" rel="stylesheet"> -->
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<!-- Page Content -->
    <div class="container" id = "navbar-gap">

      <!-- Page Heading -->
      <h1 class="my-4">Electronics
        <small>Cell Phones</small>
      </h1>

      <div class="jumbotron" id="navbar-gap">
  <div class="container">
    <h1 class="text-center"> Find your favourite Product</h1>
    <p class="text-center">Search many of Ecommerce's products</p>
    <div class= "row">
      <div class="col-md-6 col-md-offset-3">
        <div class="input-group col-md-12">
          <input type="text" id="search" class="form-control input-lg" name="search_term" placeholder="Search for a Product ...">
          <span class="input-group-btn">
          <button type="submit" class="btn btn-primary btn-lg"><i class="glyphicon glyphicon-search"></i></button>
          </span>
        </div>
      </div>
    </div>
  </div>
</div>


<div class="container">

  <div class="row" id="searchResults">

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="p" %>
   <p:forEach items="${sessionScope.phoneData}" var="i">
    <div class="col-md-4">
      <a href="<%=request.getContextPath()%>/fetchData?flag=singleProduct&productId=${i.productId}">
        <div class="thumbnail">
          <img src="images/${i.imagePath}">
          <div class="caption">
            <h3>${i.productName}</h3>
            <p>${i.productDescription}</p>
            <p>$${i.price}</p>
          </div>
        </div>
      </a>
    </div>
  </p:forEach>
  </div>
</div>
      <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>