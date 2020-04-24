<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">
 <link href="css/cart.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="p" %>
 
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:20%">Quantity</th>
							<th style="width:20%">Price</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
					<p:forEach items="${sessionScope.cartitems}" var="i">
						
						<tr>
							<td data-th="Product">
								<div class="row">
								
									<div class="col-sm-2 hidden-xs"><img src="images/${i.value.imagePath}" alt="..." class="img-responsive"/></div>
								
									<div class="col-sm-10">
										<h4 class="nomargin"> ${i.value.productName}</h4>
										<p>${i.value.productDescription}</p>
									</div>
								</div>
							</td>
							<td data-th="Quantity">
								<input type="number" disabled="disabled" class="col-sm-6 form-control text-center" value="${i.value.quantity}">
							</td>
							<td data-th="Price">$${i.value.price}</td>
							<td class="actions" data-th="">
								<a href="<%=request.getContextPath()%>/fetchData?flag=delete&name=${i.value.productName}"><button class="btn btn-danger btn-lg"><i class="fa fa-trash-o"></i></button></a>								
							</td>
						</tr>
			
					</p:forEach>
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total 1.99</strong></td>
						</tr>
						<tr>
							<td><a href="<%=request.getContextPath()%>/fetchData?flag=phoneSearch" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td></td>
							<td colspan="1" class="hidden-xs"><strong> $ <%= session.getAttribute("Total") %></strong></td>
							<td><a href="checkout.jsp" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>

		
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>