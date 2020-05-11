<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Send Mail2</title>
<base href="${pageContext.servletContext.contextPath}/">
<style>
</style>
</head>
<body>

	${message}
	<form action="ok/send.htm" method="post" enctype="multipart/form-data">
		<p>
			<input name="form" placeholder="Form" />
		</p>
		<p>
			<input name="to" placeholder="To" />
		</p>
		<p>
			<input name="subject" placeholder="Subject" />
		</p>
		<p>
			<input type="file" name="attach">
		</p>
		<p>
			<textarea name="body" placeholder="Body" rows="3" cols="30">
	</textarea>
		</p>

		<button>Send!!!</button>
	</form>

</body>
</html>
