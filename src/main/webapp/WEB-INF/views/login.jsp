<%--
  Created by IntelliJ IDEA.
  User: Subhechha Bista
  Date: 6/19/2017
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="templates/header_template.jsp">
    <jsp:param name="title" value="Login Page"/>
</jsp:include>

<c:url var="login_url"  value="/login" />
<div class="container-fluid">
<form action="${login_url}" method="post">
    <div>
        <c:if test="${param.error != null}">
            <p>Invalid username and password.</p>
        </c:if>
    </div>
    <div>
        <c:if test="${param.logout != null}">
            <p>
                You have been logged out.
            </p>
        </c:if>
    </div>
    <div class="form-group">
        <p>
            <label for="username">Username</label>
            <input type="text" id="username" name="username"/>
        </p>
    </div>
    <div class="form-group">
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
    </div>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <button type="submit" class="btn btn-info btn-lg">Log in</button>
    <div><a href="<c:url value="/register" />">Register</a> </div>
</form>
</div>

<jsp:include page="templates/footer_template.jsp"/>

