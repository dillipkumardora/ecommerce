<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">


<meta name="_csrf" content="${_csrf.headerName}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>Dillip Online Shopping-${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>
<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/mybootstrap.theme.css" rel="stylesheet">

<!-- Bootstrap dataTable theme -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${css}/shop-homepage.css" rel="stylesheet">


</head>

<body>
	<div class="wrapper">
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>


			
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="viewproducts.jsp"%>
			</c:if>
			
			<c:if test="${userClickShowProduct== true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			<!-- manage products -->
			<c:if test="${userClickManageProducts== true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>
			

		</div>
		<%@include file="./shared/footer.jsp"%>


		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>
		
		<!-- jQuery validation -->
		<script src="${js}/jquery.validate.js"></script>
		

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- jQuery data tables plugIn -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!--  data tables bootstrap Script-->
		<script src="${js}/dataTables.bootstrap.js"></script>
		
			<!--  BootBox Script-->
		<script src="${js}/bootbox.min.js"></script>
		
		<script src="${js}/myapp.js"></script>

	</div>
</body>

</html>
