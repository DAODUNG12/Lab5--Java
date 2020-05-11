<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Upload File</title>
<base href="${pageContext.servletContext.contextPath}/">
<style>
.form-group {
	margin: 10px;
}
</style>
</head>
<body>
	<h2>CV xin việc:</h2>
	${message}
	<form action="job/load.htm" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<div>Họ Tên Ứng Viên:</div>
		<input type="text" name="fullname" />

	</div>
	<div class="form-group">
		<div>Hình Ảnh:</div>
		<input type="file" name="photo" />

	</div>
	<div class="form-group">
		<div>Hồ Sơ Xin Việc:</div>
		<input type="file" name="cv" />

	</div>
	<div class="form-group">
		<button>Nộp</button>

	</div>
	</form>
</body>
</html>
