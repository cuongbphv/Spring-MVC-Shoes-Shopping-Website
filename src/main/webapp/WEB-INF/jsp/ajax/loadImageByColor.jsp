<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<img style="margin-bottom: 5px" class="img-responsive img-circle"
		src="data:image/png;base64,${cl.base64}" alt="${cl.name }">
	<div style="margin-top: 10px;" class="col-md-12">
		<input name="editColorImage" id="editColorImage" class="form-control"
			type="file" accept="image/*" />
	</div>
</body>
</html>