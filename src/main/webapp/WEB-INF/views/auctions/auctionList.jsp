<%--
  Created by IntelliJ IDEA.
  User: nuaimat
  Date: 6/19/17
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>e-Auctions</title>
</head>
<body>

<h1>List of Auctions:</h1>

    <c:forEach var="a" items="${auctions}">
        <div>
            <div><a href="auctions/${a.id}">Img: ${a.item.product.img}</a></div>
            <div><a href="auctions/${a.id}">${a.item.product.name}</a></div>
            <div>Ends at: ${a.end}</div>
            <div>Quantity: ${a.item.quantity}</div>
            <div>Description: ${a.item.product.description}</div>
            <div>Sold by: ${a.item.seller.username} ${a.item.seller.stars}</div>
        </div>
    </c:forEach>


<form:form modelAttribute="auction" action="auctions" method="post">
    <h2>Add an Auction:</h2>
    <table>
        <tr>
            <td>End Date:</td>
            <td>
                <form:input path="end" />
                <form:errors path="end" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>Is Active?</td>
            <td>
                <form:input path="minimumBid"  />
                <form:errors path="minimumBid" cssClass="error" />
            </td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit"/></td>
        </tr>
    </table>

</form:form>
</body>
</html>