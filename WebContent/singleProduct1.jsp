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
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="p" %>
 <p:forEach items="${sessionScope.singlePhoneData}" var="i">
<div class="container">
  <div class="row">

    <div class="col-md-4">
      <img src="images/${i.imagePath}">
    </div>

    <div class="col-md-4">

    </div>


    <div class="col-md-4">
      <h3>${i.productName}</h3>
      <h1>$${i.price}</h1>

      <form method="get" action="<%=request.getContextPath()%>/addToCart">
      <h4>Quantity</h4>
        <div class="btn-group" role="group" aria-label="...">
          <input type="hidden" name="quantity" id="quantity" value="1"></input>
          <button type="button" id="minus" class="btn btn-default">-</button>
          <button type="button" name="quantity" id="total" class="btn btn-default">1</button>
          <button type="button" id="plus" class="btn btn-default">+</button>
        </div>
	<br><br>
        <div class="form-group">
        	<input type="hidden" name="flag" value="addToCart"></input>
          
          <input type="hidden" name="product_id" id="quantity" value="${i.productId}"></input>
          <input type="hidden" name="priceHidden" id="priceHidden" value="${i.price }"></input>
		  <input type="hidden" name="product_name" id="productName" value="${i.productName }"></input>
		  <input type="hidden" name="productImage" id="productImage" value="${i.imagePath}"></input>
		  <input type="hidden" name="productDescription" id="productDescription" value="${i.productDescription}"></input>
		  
		  
          <h4>Total Price</h4>
          <input type="text" name="priceValue" id="priceValue" readonly class="form-control" value="${i.price}"></input>
        </div>


	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
   	<c:if test="${sessionScope.profileData == null}">
   	<a href='Registration.jsp' class="btn btn-warning btn-lg">Signup to begin buying!</a>
   	</c:if>
   	<c:if test="${sessionScope.profileData != null}">
   	<button type="submit" class="btn btn-primary btn-lg">Add to Cart</button>
   	</c:if>
        <%-- <% if (user)  { %>
          <button type="submit" class="btn btn-primary btn-lg">Add to Cart</button>
        <% } else { %>
          <a href='/signup' class="btn btn-warning btn-lg">Signup to begin buying!</a>
        <% } %> --%>
      </form>

    </div>
  </div>
  
  <div class="row">
  	   <div class="col-xs-9">
                    <ul class="menu-items">
                      <h5> <bold> <li class="active">Product Details</li> </bold> </h5>
                        
                    </ul>
                    <div style="width:100%;border-top:1px solid silver">
                        <p style="padding:15px;">
                            <small>
                            </small>
                        </p>
                        <small>
                           <h5> <ul><bold>
                                <li>${i.productDescription}</li>
                            </bold></ul>  </h5>
                        </small>
                    </div>
                </div>
  </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</p:forEach>
 <script src="js/custom.js"></script>
</body>
</html>