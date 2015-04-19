<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet"
		href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="../../script/customer.js"></script>
	<!-- <script src="../../script/jquery-1.11.2.min.js"></script> -->
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<!-- 		<script src="../../script/bootstrap.min.js"></script> -->
	<link rel="stylesheet" type="text/css" href="../css/main.css">
	<!-- <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"> -->
	<script>
	$(document).ready(function(){
	    $('[data-toggle="tooltip"]').tooltip(); 
	});
	</script>
<title>Customers Web App</title>
<link rel="shortcut icon" href="../../images/favicon.ico">
</head>
<body>
	<div id="search" class="container">
		<h2>Search Customer</h2>
		<ul class="nav nav-tabs">
			<li><a href="master.html">Home</a></li>
			<li><a href="create.html">Create</a></li>
			<li class="active"><a href="view.jsp">View</a></li>
		</ul>
		<div id="searchForm" class="container panel panel-default">
			<div class="row">
				<div class="form-inline panel-body">
					<div class="form-group col-sm-3">
						<label for="id">ID</label> <input type="text" name="id" id="id"
							class="form-control"></input>
					</div>
					<div class="form-group col-sm-3">
						<label for="firstName">First Name</label> <input type="text"
							name="firstName" id="firstName" class="form-control"></input>
					</div>
					<div class="form-group col-sm-3">
						<label for="lastName">Last Name</label> <input type="text"
							name="lastName" id="lastName" class="form-control"></input>
					</div>

					<button type="button" class="btn btn-success col-sm-1"
						onclick="fetchCustomer()">
						<span class="glyphicon glyphicon-search"></span> Search
					</button>
					<img id="spinner" style="display: none;"
						src="../../images/spinner.gif" class="spinner">
				</div>
			</div>
		</div>
	</div>

	<div class="container" id="resultTable" style="display: none">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Street</th>
					<th>City</th>
					<th>State</th>
					<th>Zip</th>
					<th>Country</th>
					<th></th>
				</tr>
			</thead>
			<tbody id="resultSet">
			</tbody>
		</table>
	</div>

	<div class="container">
		<div id="myModal" class="modal fade " role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title"><span id ="modal-status"></span></h4>
					</div>
					<div class="modal-body" id="modal-body-id">
						<p>Some text in the modal.</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>