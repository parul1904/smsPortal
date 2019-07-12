<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SMS Portal</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Page level plugin CSS-->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">
<%@ include file="sideBar.jsp"%>

<div id="content-wrapper">

	<div class="container-fluid">
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i> Create Group
			</div>
			<div class="card-body">

				<form:form action="updateGroup" method="post"
					modelAttribute="groups">
					 <div class="form-group">
            <div class="form-label-group">
						<form:input path="groupName" type="text"
							 class="form-control" required="required" autofocus="autofocus"></form:input>
						<label for="groupName"><b>Group Name</b></label>
						</div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
						<form:select path="groupStatus" name="groupStatus"
							class="form-control selectpicker" required="required">
							<option value="" label="Select Status" />
							<option value="A" label="Active" />
							<option value="I" label="In-Active" />
						</form:select>
						</div>
          </div>
						<input type="submit" class="btn btn-primary btn-block" value="Create" />
				</form:form>

				<c:if test="${msg != null}">
					<script>
						alert("Group Created Successfully!");
						window.location = "http://localhost:8080/smsPortal/dashboard?page=1&limit=25";
					</script>
				</c:if>

				<%-- 	<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>Group Id</th>
										<th>Group Name</th>
										<th>Group Status</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${groups}" var="groups">
										<tr>
											<td><c:out value="${groups.groupId}" /></td>
											<td><c:out value="${groups.groupName}" /></td>
											<td><c:out value="${groups.groupStatus}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div> --%>
			</div>
		</div>
		<!-- /.container-fluid -->

		<!-- Sticky Footer -->
		<footer class="sticky-footer">
			<div class="container my-auto">
				<div class="copyright text-center my-auto">
					<span>Developed by Parul Gangwal</span>
				</div>
			</div>
		</footer>

	</div>
	<!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top"> <i
	class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">Select "Logout" below if you are ready
				to end your current session.</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
				<a class="btn btn-primary" href="login.html">Logout</a>
			</div>
		</div>
	</div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Page level plugin JavaScript-->
<script src="vendor/chart.js/Chart.min.js"></script>
<script src="vendor/datatables/jquery.dataTables.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin.min.js"></script>

<!-- Demo scripts for this page-->
<script src="js/demo/datatables-demo.js"></script>
<script src="js/demo/chart-area-demo.js"></script>
</body>

</html>
