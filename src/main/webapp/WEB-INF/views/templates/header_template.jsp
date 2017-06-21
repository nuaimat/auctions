<%--
  Created by IntelliJ IDEA.
  User: nuaimat
  Date: 4/19/17
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal" />
<c:set var="rand"><%= java.lang.Math.round(java.lang.Math.random() * 200) %></c:set>
<!DOCTYPE html>
<html>
<head>
    <title>
    <c:choose>
        <c:when test="${not empty param.title}">
            ${param.title}
        </c:when>
        <c:otherwise>
            e-Auctions
        </c:otherwise>
    </c:choose>
    </title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />?${rand}">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="<c:url value="/resources/js/main.js" />?${rand}" ></script>

</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"><img src="<c:url value="/resources/images/logo.png" />" style="width: 23px"></a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav" id="navBarLeftLinks">
                <li class="home-nav-link active"><a href="<c:url value="/" />">Home</a></li>
                <sec:authorize access="hasRole('ROLE_SELLER') and isAuthenticated()">
                    <li class="order-history-nav-link"><a href="<c:url value="/auctions/sellerList" />">My Sales</a></li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_CUSTOMER') and isAuthenticated()">
                    <li class="products-nav-link"><a href="<c:url value="/auctions/my" />">My Biddings</a></li>
                </sec:authorize>
            </ul>
            <sec:authorize access="isAuthenticated()" var="loggedInUser" />
            <c:choose>
                <c:when test="${loggedInUser}">
                    <c:set value="Hello ${user.username}" var="welcome_msg" />
                    <c:set value="#" var="profile_link" />
                </c:when>
                <c:otherwise>
                    <c:set value="Login" var="welcome_msg" />
                    <c:set value="/login" var="profile_link" />
                </c:otherwise>
            </c:choose>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value="${profile_link}" />"><span class="glyphicon glyphicon-user"></span>
                        ${welcome_msg}
                    </a></li>
                <li><a href="<c:url value="/logout" />"><span class="glyphicon glyphicon-log-out"></span>
                    Logout</a></li>
            </ul>
        </div>
    </div>
</nav>