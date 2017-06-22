<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<c:if test="${not empty message}">
				<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}			
				</div>
				
				</div>
			</c:if>
			<div class="com-md-offset-2 col-md-8">
				<div class="panel panel-primary">
					<div class="panel-heading">

						<h4>Product Management</h4>
					</div>

					<div class="panel-body">
						<!-- From elements -->
						<sf:form class="form-horizontal" modelAttribute="product"
							action="${contextRoot}/manage/products" method="POST"
							enctype="multipart/form-data"
							>

							<div class="form-group">

								<label class="control-label col-md-4" for="brand"> Enter
									The Product Name: </label>

								<div class="col-md-8">

									<sf:input type="text" path="name" id="product"
										placeholder="Product Name" class="form-control" />

									<sf:errors path="name" cssClass="help-block" element="em" />

								</div>
								</div>
								<div class="form-group">

									<label class="control-label col-md-4" for="brand">
										Enter The Brand Name: </label>

									<div class="col-md-8">

										<sf:input type="text" path="brand" id="brand"
											placeholder="Brand Name" class="form-control" />

									     <sf:errors path="brand" cssClass="help-block" element="em" />


									</div>

								</div>


								<div class="form-group">

									<label class="control-label col-md-4" for="description">
										Description: </label>

									<div class="col-md-8">

										<sf:textarea path="description" id="description" rows="4"
											placeholder="Give Some Description" class="form-control" />

									<sf:errors path="description" cssClass="help-block" element="em" />
									</div>
								</div>

								<div class="form-group">

									<label class="control-label col-md-4" for="unitPrice">
										Enter The Unit Price: </label>
									<div class="col-md-8">
										<sf:input type="number" path="unitPrice" id="unitPrice"
											placeholder="unitPrice is in &#8377" class="form-control" />
											<sf:errors path="unitPrice" cssClass="help-block" element="em" />																		
									</div>
								</div>
								
								<!-- MultiPart file -->
									<div class="form-group">

									<label class="control-label col-md-4" for="file">
										Select An Image: </label>
									<div class="col-md-8">
										<sf:input type="file" path="file" id="file" class="form-control" />	
										<sf:errors path="file" cssClass="help-block" element="em" />																		
																											 									
								</div>
								</div>

								<div class="form-group">

									<label class="control-label col-md-4" for="quantity">
										Enter Quantity available: </label>

									<div class="col-md-8">

										<sf:input type="number" path="quantity" id="quantity"
											placeholder="Quantity Available" class="form-control" />
										
									</div>
								</div>

								<div class="form-group">

									<label class="control-label col-md-4" for="categoryId">
										Select Category: </label>
									<div class="col-md-8">
										<sf:select class="form-control" id="categoryId"
											path="categoryId" items="${categories}" itemLabel="name"
											itemValue="id" />


									</div>
								</div>




								<div class="form-group">

									<div class="col-md-offset-4 col-md-8">

										<input type="submit" name="submit" id="submit"
											class="btn btn-primary" />
										<!-- hidden field for product -->
										<sf:hidden path="id" />
										<sf:hidden path="code" />
										<sf:hidden path="supplierId" />
										<sf:hidden path="purchages" />
										<sf:hidden path="views" />
										<sf:hidden path="active" />
									</div>
								</div>
						</sf:form>
					</div>
				</div>

			</div>
		</div>
	
	
	<div class="row">
	<div class="col-xs-12">
	<h3>Available Products</h3>
	<hr/>
	</div>
	
	<div class="col-xs-12">
	<div style="overflow:auto">
	
	<!-- product table forAdmin -->
	<table id="adminProductsTable" class="table table-striped table-bordered">
	
<thead>
	<tr>
		<th>Id</th>
		<th>&#160</th>
		<th>Brand</th>
		<th>Name</th>
		<th>Quantity</th>
		<th>Unit Price</th>
		<th>Active</th>
		<th>Edit</th>
	
	</tr>	
</thead>


	
<tfoot>
	<tr>
	   <th>Id</th>
	  <th>&#160</th>
	  <th>Brand</th>
	  <th>Name</th>
	  <th>Quantity</th>
	  <th>Unit Price</th>
	  <th>Active</th>
	  <th>Edit</th>
	
	</tr>
	
</tfoot>
	
	
	</table>

	</div>
	
	</div>
	
	</div>
	
	</div>
	
</body>
</html>