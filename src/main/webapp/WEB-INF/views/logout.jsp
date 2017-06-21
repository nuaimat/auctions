<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Subhechha Bista
  Date: 6/21/2017
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<c:url var="logout_url" value="/logout"/>
<form action="${logout_url}" method="post" id="logout_form">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<script type="text/javascript">
    document.getElementById("logout_form").submit();
</script>
</body>
</html>
