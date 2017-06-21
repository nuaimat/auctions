<%--
  Created by IntelliJ IDEA.
  User: Subhechha Bista
  Date: 6/20/2017
  Time: 12:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="templates/header_template.jsp">
    <jsp:param name="title" value="Login Page"/>
</jsp:include>
<c:url var="register_url" value="/register"/>

<div class="container-fluid">
    <form:form id="regForm" modelAttribute="user" action="register" method="post">
        <h2>Register:</h2>

        <div class="form-group">
            <form:errors path="*"  cssClass="alert alert-danger alert-dismissable" element="div" />
        </div>
        <div class="form-group">
            <label>Username:</label>
            <form:input path="username" name="username" id="username"/>
        </div>

        <div class="form-group">
            <label>Password:</label>
            <form:password path="password" name="password" id="password"/>
        </div>

        <div class="form-group">
            <label>Register As:</label>
            <form:select path="role">
                <div>
                    <form:option value="SELLER">Seller</form:option>
                    <form:option value="CUSTOMER">Buyer</form:option>
                </div>
            </form:select>
        </div>

        <div class="form-group">
            <label>Street Address 1:</label>
            <form:input path="profile.address[0].streetAddress1" name="streetaddress1" id="street1"/>
        </div>

        <div class="form-group">
            <label>Street Address 2:</label>
            <form:input path="profile.address[0].streetAddress2" name="streetaddress2" id="street2"/>
        </div>
        <div class="form-group">
            <label>Zip:</label>
            <form:input path="profile.address[0].zip" name="zip" id="zip"/>
        </div>

        <div class="form-group">
        <label>City:</label>
        <form:input path="profile.address[0].city" name="city" id="city"/>
        </div>

        <div class="form-group">
        <label>Country:</label>
        <form:input path="profile.address[0].country" name="city" id="city"/>
        </div>

        <form:button id="register" name="register" class="btn btn-info btn-lg">
            Register
        </form:button>
    </form:form>
</div>
<jsp:include page="templates/footer_template.jsp"/>
