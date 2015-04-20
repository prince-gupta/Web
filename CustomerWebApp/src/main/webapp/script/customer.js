function fetchCustomer() {
	$("#spinner").show();
	$
			.ajax({
				url : 'http://localhost:8080/CustomerWebApp/rest/customers/search',
				data : {
					firstName : $("#firstName").val(),
					lastName : $("#lastName").val(),
					id : $("#id").val()
				},
				success : function(data) {
					if (data && data.length == 0) {
						$("#resultTable").hide();
						$("#messageDiv")
								.html(
										"<div class='has-error'>"
												+ "<div class='well well-sm'><span class='glyphicon glyphicon-warning-sign'></span> No Record Found "
												+ "</div></div>")
						$("#messageDiv").show()
					} else {
						populateCustomer(data, "resultSet");
						$("#resultTable").show();
					}
					$("#spinner").hide();

				},
				error : function(data) {
					$("#modal-body-id").html(data.statusText);
					$('#modal-status').html("Error");
					$('#myModal').modal('show');
					$("#spinner").hide();
				}

			});
}

function deleteCustomer(id) {
	var selectedId = {
		'id' : id
	};
	$("#" + id + "d").addClass("disabled");
	$.ajax({
		url : 'http://localhost:8080/CustomerWebApp/rest/customers/deleteById',
		data : JSON.stringify(selectedId),
		type : 'POST',
		contentType : "application/json",
		success : function(data) {
			$("#row" + id).hide();
			$("#modal-body-id").html("<p class='fPopup'> Data deleted !!</p>");
			$("#modal-status").parent().parent().addClass("bgRoyalBlue");
			$('#modal-status').html("Success");
			$('#myModal').modal('show');

		},
		error : function(data) {
			$("#modal-body-id").html(data.statusText);
			$('#myModal').modal('show');
		}

	});
}

function populateCustomer(data, divId) {
	var customer = "";
	for (var i = 0; i < data.length; i++) {
		customer = customer + "<tr id = 'row" + data[i].id + "'>";
		customer = customer + "<td>" + data[i].id + "</td>";
		customer = customer + "<td>" + data[i].firstName + "</td>";
		customer = customer + "<td>" + data[i].lastName + "</td>";
		customer = customer + "<td>" + data[i].street + "</td>";
		customer = customer + "<td>" + data[i].city + "</td>";
		customer = customer + "<td>" + data[i].state + "</td>";
		customer = customer + "<td>" + data[i].zip + "</td>";
		customer = customer + "<td>" + data[i].country + "</td>";
		customer = customer
				+ "<td><a href='#' id ='"
				+ data[i].id
				+ "d' onclick='deleteCustomer("
				+ data[i].id
				+ ")' data-toggle='tooltip' title='Be Sure Before Delete. Will not cross confirm !'><span class='glyphicon glyphicon-trash'></span></a></td>"
		customer = customer + "</tr>";
	}
	$("#" + divId).html(customer);
}

function save() {
	$("#spinner").show();
	$("#create-button").addClass("disabled");
	var isValid = performValidations();
	if (isValid == true) {
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
				$("#create-button").removeClass("disabled");

			},
			error : function(data) {
				$("#spinner").hide();
				$("#modal-body-id").html(data.statusText);
				$("#modal-status").parent().parent().addClass("bgErrorRed");
				$("#modal-status").html("ERROR");
				$('#myModal').modal('show');
				$("#create-button").removeClass("disabled");
			}

		});
	} else {
		$("#spinner").hide();
		$("#create-button").removeClass("disabled");
	}
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

function performValidations() {
	if ($("#firstName").val() == "") {
		$("#firstName").parent().addClass("has-error");
		$("#firstName").attr("placeholder","Please enter Firstname");
		$("#crossFirstName").show();
		$("#astrikF").hide();
		return false;
	} else {
		$("#firstName").parent().removeClass("has-error");
		$("#crossFirstName").hide();
		$("#astrikF").show();
	}
	if ($("#lastName").val() == "") {
		$("#lastName").parent().addClass("has-error");
		$("#lastName").attr("placeholder","Please enter Lastname");
		$("#crossLastName").show();
		$("#astrikL").hide();
		return false;
	} else {
		$("#lastName").parent().removeClass("has-error");
		$("#crossLastName").hide();
		$("#astrikL").show();
	}
	return true;
}