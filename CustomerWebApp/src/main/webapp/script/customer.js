function fetchCustomer() {
	$("#spinner").show();
	$.ajax({
		url : 'http://localhost:8080/CustomerWebApp/rest/customers/search',
		data : {
			firstName : $("#firstName").val(),
			lastName : $("#lastName").val(),
			id : $("#id").val()
		},
		success : function(data) {
			populateCustomer(data,"resultSet");
			$("#spinner").hide();
			$("#resultTable").show();
			
		},
		error : function(data) {
			$("#modal-body-id").html(data.statusText);
			$('#modal-status').html("Error");
			$('#myModal').modal('show');
			$("#spinner").hide();
		}

	});
}

function deleteCustomer(id){
	var selectedId = {
			'id' : id
	};
	$.ajax({
		url : 'http://localhost:8080/CustomerWebApp/rest/customers/deleteById',
		data :JSON.stringify(selectedId),
		type : 'POST',
		contentType : "application/json",
		success : function(data){
			$("#row"+id).hide();
			$("#modal-body-id").html("<p> Data deleted !!</p>");
			$('#modal-status').html("Success");
			$('#myModal').modal('show');
			
		},
		error : function(data){
			$("#modal-body-id").html(data.statusText);
			$('#myModal').modal('show');
		}
			
	});
}

function populateCustomer(data,divId) {
	var customer = "";
	for (var i = 0; i < data.length; i++) {
		customer = customer + "<tr id = 'row"+data[i].id+"'>";
		customer = customer + "<td>" + data[i].id + "</td>";
		customer = customer + "<td>" + data[i].firstName + "</td>";
		customer = customer + "<td>" + data[i].lastName + "</td>";
		customer = customer + "<td>" + data[i].street + "</td>";
		customer = customer + "<td>" + data[i].city + "</td>";
		customer = customer + "<td>" + data[i].state + "</td>";
		customer = customer + "<td>" + data[i].zip + "</td>";
		customer = customer + "<td>" + data[i].country + "</td>";
		if(divId=="resultSet"){
			customer = customer + "<td><button type='button' class='btn btn-danger' onclick='deleteCustomer("+data[i].id+")' data-toggle='tooltip' title='Be Sure Before Delete. Will not cross confirm !'><span class='glyphicon glyphicon-remove'></span> Delete</button></td>"
		}
		customer = customer + "</tr>";
	}
	$("#"+divId).html(customer);
}

function save() {
	$("#spinner").show();
	var data = makeJSON();

	$.ajax({
		url : 'http://localhost:8080/CustomerWebApp/rest/customers/create',
		data : data,
		type : "POST",
		Accept : "application/json",
		contentType : "application/json",
		success : function(data) {
			populateCustomer(data, "createSet")
			$("#createTable").show();
			$("#spinner").hide();
			
		},
		error : function(data) {
			$("#spinner").hide();
			$("#modal-body-id").html(data.statusText);
			$('#myModal').modal('show');
		}

	});
}

function makeJSON() {
	var formData = {
		'firstName' : $("#firstName").val(),
		'lastName' : $("#lastName").val(),
		'street' : $("#street").val(),
		'city' : $("#city").val(),
		'state' : $("#state").val(),
		'zip' : $("#zip").val(),
		'country' : $("#country").val()
	};

	return JSON.stringify(formData);
}