<%--
  Created by IntelliJ IDEA.
  User: nuaimat
  Date: 6/19/17
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="row">
    <div class="panel panel-primary">
        <div class="panel-heading auctiontitle"><span class="text-primary">${auction_obj.item.product.name}</span>
            <div style="float: right;">
                <span class="glyphicon glyphicon-time"></span> time left ${auction_obj.end}
            </div>
        </div>
        <div class="panel-body">
            <div class="row">
                <div style="text-align: center">
                    <c:url value="/resources/uploads/" var="uploads_folder"/>
                    <img src="${uploads_folder}${auction_obj.item.product.img}" style="width: 80%;"/></div>
                <div><a href="auctions/${auction_obj.id}">${auction_obj.item.product.name}</a></div>
                <div>Ends at: ${auction_obj.end}</div>
                <div>Quantity: ${auction_obj.item.quantity}</div>
                <div>Sold by: ${auction_obj.item.seller.username} ${auction_obj.item.seller.stars}</div>
            </div>
        </div>
        <div class="panel-footer">
            <div class="row">Description: ${auction_obj.item.product.description}</div>
            <c:if test="${not empty auction_obj.bids}">
                <div class="row">
                    <span class="text-primary">Highest bidder:</span> ${auction_obj.bids[0].customer.username}
                    <div style="float: right;">
                        <span class="text-primary">Max amount: </span> ${auction_obj.bids[0].amount}
                    </div>
                </div>
            </c:if>
            <sec:authorize access="hasRole('ROLE_CUSTOMER') and isAuthenticated()" var="is_cust" />
            <sec:authorize access="!isAuthenticated()" var="is_anon" />
            <c:choose>
                <c:when test="${is_cust}"><jsp:include page="bidPanel.jsp"/></c:when>
                <c:when test="${is_anon}">
                    <div>Login needed for bidding</div>
                </c:when>
            </c:choose>


        </div>
    </div>
</div>