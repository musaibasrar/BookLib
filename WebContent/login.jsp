<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
    
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resources/js/openWindow.js"></script>

	
	<!-- <script type="text/javascript">
	
	function gettheform(formvalue){
		var form = formvalue;
		// for stopping the default action of element
		//e.preventDefault();
		// mapthat will hold form data
		var formData = {}
		
		//iterate over form elements
		$.each(this, function(i, v){
		var input = $(v);
		
		// populate form data as key-value pairs
		// with the name of input as key and its value as value
		formData[input.attr("name")] = input.val();
		});
		
		$.ajax({
			
		 type: POST, // method attribute of form */
		url: "http://localhost:9099/Bookan/rest/add", // action attribute of form 
		 dataType : 'json',
		// convert form data to json format
		data : JSON.stringify(formData),
		});
		alert('before ajax');
	}
	
	$(function() {

		$("#submitForm").click(function(e) {
			// reference to form object
			alert('Inside form');
			//var form = this.up('submitForm11').getForm();
			var form = document.forms["submitForm1"];
			/* if (form.isValid()) {
			    var values = form.getValues();

			    // log all values.
			    console.log(values);

			    // log uname value.
			    console.log(values['uname']);
			} */
			
			//var form = this;
			
			
			// for stopping the default action of element
			e.preventDefault();
			// mapthat will hold form data
			var formData = {}
			
			//iterate over form elements
			$.each(this, function(i, v){
			var input = $(v);
			
			// populate form data as key-value pairs
			// with the name of input as key and its value as value
			formData[input.attr("name")] = input.val();
			});
			
			$.ajax({
				
			 type: POST, // method attribute of form */
			url: "http://localhost:9099/Bookan/rest/add", // action attribute of form 
			 dataType : 'json',
			// convert form data to json format
			data : JSON.stringify(formData),
			});
			alert('before ajax');
			});
			
		
		
		
	});
	
	</script> -->
	
	<script type="text/javascript">
		
	$(function() {

		$("#submitForm").submit(function(e) {
			// reference to form object
			
			
			var form = this;
			
			
			// for stopping the default action of element
			e.preventDefault();
			// mapthat will hold form data
			var formData = {}
			
			//iterate over form elements
			$.each(this, function(i, v){
			var input = $(v);
			
			// populate form data as key-value pairs
			// with the name of input as key and its value as value
			formData[input.attr("name")] = input.val();
			});
			
			$.ajax({
				
			 type: 'POST', // method attribute of form */
			 contentType: 'application/json; charset=utf-8',
			 url: 'http://localhost:9099/Bookan/rest/entry/authenticate', // action attribute of form 
			 dataType : 'JSON',
			// convert form data to json format
			data : JSON.stringify(formData),
			});
			
			});
			
		
		
		
	});
	
	</script>
	
	
	<script type="text/javascript">
function add(){
		alert('inside add');
		
		 var name = $('#name').val();
		 var password = $('#password').val();
		
		 var formData = new FormData();

	        formData.append('name', name);
	        formData.append('password', password);
		 
		 
	$.ajax({
	    url: 'http://localhost:9099/Bookan/rest/entry/authenticate',
	    method: 'POST',
	    crossDomain: true,
	    beforeSend: function ( xhr ) {
	        xhr.setRequestHeader( 'Authorization', 'Basic ' + 'YWRtaW5yb290OmFkbWlucm9vdA==' );
	    },
	    dataType : 'JSON',
		// convert form data to json format
		data : JSON.stringify(formData),
		processData: false,
	    success: function( data, txtStatus, xhr ) {
	        console.log( data );
	        console.log( xhr.status );
	    }
	});	
	alert('end add method');
}
	</script>
</head>
<body>
<!-- <form>
<label>Title</label>&nbsp;&nbsp;&nbsp;<input type="text" >
<br>
<label>Title</label>&nbsp;&nbsp;&nbsp;<input type="text" >
<br>
<label>Title</label>&nbsp;&nbsp;&nbsp;<input type="text" >
<br>
<label>Title</label>&nbsp;&nbsp;&nbsp;<input type="text" >
<input type="button" name="submit" id="submitForm">
</form>
 -->
 <!-- <form action="saveUser" method="post" id="submitForm"> -->
 <form  action="http://localhost:9099/Bookan/rest/entry/authenticate" id="submitForm">
<p><label>user name</label>
<input name="name" id="name" type="text"></p>
<label>password</label>
<input name="password" id="password" type="password"/>
<input type="button" value="add" onclick="add();">
<input type="submit" value="Submit Form" >
</form>
</body>
</html>