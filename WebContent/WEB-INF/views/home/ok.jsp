<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Spring MVC</title>
<base href="${pageContext.servletContext.contextPath}/">
<style>
img{
width: 200px;
height: 200px;
}
</style>
</head>
<body>
	<p>
	<h3>Thông Tin Ứng Viên:</h3>
	<img alt="" src="files/${photo_name}"/>
	<br />
	<h3>${param.fullname}</h3>
	</p>
	<p>
	<h3>Hồ Sơ Xin Việc:</h3>
	<ul>
		<li>FileName:${cv_name}</li>
		<li>FileType:${cv_type}</li>
		<li>FileSize:${cv_size}</li>
	</ul>
	</p>
</body>
</html>
