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

<c:url var="login_url" value="/login"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="well">
                <div style="text-align: center"><h3 style="left: 48%">Login</h3></div>
                <form action="${login_url}" method="post">
                    <c:if test="${param.error != null}">
                        <div class="alert-danger well">
                        Invalid username and password.
                        </div>
                    </c:if>


                    <c:if test="${param.logout != null}">
                        <div class="alert-info well">You have been logged out.</div>
                    </c:if>

                    <div class="form-group">
                        <div class="row">
                            <div class="col-sm-3" style="text-align: right"><label for="username">Username:</label></div>
                            <div class="col-sm-9"><input type="text" id="username" name="username" required style="width: 99%" /></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-sm-3" style="text-align: right"><label for="password">Password:</label></div>
                            <div class="col-sm-9"><input type="password" id="password" name="password" style="width: 99%" /></div>
                        </div>
                    </div>
                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                    <div class="row" style="text-align: center">
                        <button type="submit" class="btn btn-info btn-lg">Log in</button>
                    </div>

                </form>
            </div>

            <div class="well">Or <a href="<c:url value="/register" />">Register</a> if you don't have an account</div>

        </div>
        <div class="col-sm-3"></div>
    </div>

</div>

<jsp:include page="templates/footer_template.jsp"/>

