<html>

<head>
<script type="text/javascript" src="resources/js/jquery-3.2.1.min.js"></script>

	
</head>
<body>
	<h1>File Upload with Jersey</h1>

	<form action="http://localhost:9099/Bookan/rest/entry/add" method="post" enctype="multipart/form-data">

<p><label>Title</label>
<input name="title" type="text"></p>


	   <p>
		Select a file : <input type="file" name="file" size="45" />
	   </p>
	   
		
	   <input type="submit" value="Submit" />
	</form>

</body>
</html>