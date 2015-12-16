
<html>
<head>
<title>Parashift - Word Cloud</title>
<!-- JQclouds Libraries -->
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqcloud/1.0.4/jqcloud.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jqcloud/1.0.4/jqcloud-1.0.4.js"></script>

<style type="text/css">
body {
	background-image: url('http://i.imgur.com/5UfYEol.jpg');
	background-repeat: no-repeat;
	background-size: 100%;
}

#wordCloudDiv {
	width: 100%;
	height: 100%;
	position: absolute;
}
</style>

<script type="text/javascript">
var wordOccurenceJsonString = ${message};
$(function() {
    // When DOM is ready, select the container element and call the jQCloud method, passing the array of words as the first argument.
    $("#wordCloudDiv").jQCloud(wordOccurenceJsonString);
  });
</script>
</head>
<body>

	<!-- Parashift logo -->
	<img src="http://i.imgur.com/fo6yHZT.jpg"></img>

	<br>
	<br>
	<div id="wordCloudDiv"></div>
</body>

</html>