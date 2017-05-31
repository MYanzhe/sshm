<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello Please Login</h2>
<form action="${ctx}/login">
	<input name='username'>
	<input name='password'>
	<input type='submit'>
</form>
</body>
</html>
