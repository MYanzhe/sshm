<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script>
		if("${name}" == 'loginError'){
			alert("用户名密码错误");
		}
</script>
</head>
<body>
	<h2>Hello Please Login</h2>
	<form action="${ctx}/login" method="post">
		<input name='username'> <input name='password'> <input
			type='submit'>
	</form>
</body>
</html>
