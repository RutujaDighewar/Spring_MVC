<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<!DOCTYPE html>
<html lang="en">
<head>
<title>Employee list</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<form:form modelAttribute="employeeForm" class="form-horizontal"
			action="save" method="post">
			<fieldset>
				<c:if test="${not empty success}">
					<font color="green">${success}</font>
				</c:if>
				<c:if test="${not empty error}">
					<font color="red">${error}</font>
				</c:if>
				<!-- Form Name -->
				<legend>Employee Registration</legend>

				<form:hidden path="id" />
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="name">Enter name</label>
					<div class="col-md-4">
						<form:input id="name" path="name" type="text"
							placeholder="Enter name" class="form-control input-md"
							required=""></form:input>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="address">Enter
						address</label>
					<div class="col-md-4">
						<form:input id="address" path="address" type="text"
							placeholder="Enter address" class="form-control input-md"
							required=""></form:input>
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for=""></label>
					<div class="col-md-4">
						<c:choose>
							<c:when test="${employeeForm.id!=0}">
								<button type="submit" id="" name="" class="btn btn-primary">Update</button>
							</c:when>
							<c:otherwise>
								<button type="submit" id="" name="" class="btn btn-primary">Save</button>
							</c:otherwise>
						</c:choose>


					</div>
				</div>

			</fieldset>
		</form:form>
		<h2>Employee  list</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Address</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${employees}" var="employee">
					<tr>
						<td>${employee.id}</td>
						<td>${employee.name}</td>
						<td>${employee.address}</td>
						<td><a href="modify?id=${employee.id}">Edit</a>|<a
							href="delete?id=${employee.id}">Delete</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
