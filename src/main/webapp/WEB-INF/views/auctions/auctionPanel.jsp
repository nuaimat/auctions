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
        <div class="panel-heading auctiontitle">
            <div class="row" style="line-height: 30px">
                <div class="col-sm-6 text-primary lead" style="margin: 0;">
                    ${auction_obj.item.product.name}
                </div>
                <div class="col-sm-6" style="text-align: right;vertical-align: middle">
                    <span class="glyphicon glyphicon-time"></span>
                    Time left <span id="auc_${auction_obj.id}_tl">...</span>
                </div>
            </div>
        </div>
        <div class="panel-body">
            <div class="row">
                <div style="text-align: center">
                    <c:url value="/resources/uploads/" var="uploads_folder"/>
                    <a href="auctions/${auction_obj.id}"><img src="${uploads_folder}${auction_obj.item.product.img}" style="width: 80%;"/></a>
                </div>
                <div class="row" style="margin: 0 0 0">
                    <div class="col-sm-4" style="padding-left: 0">
                        <span class="text-primary">Name:</span> ${auction_obj.item.product.name}
                    </div>
                    <div class="col-sm-4" style="padding-left: 0">
                        <span class="text-primary">Qty:</span> ${auction_obj.item.quantity}
                    </div>
                    <div class="col-sm-4" style="padding-left: 0">
                        <span class="text-primary">Sold by:</span> ${auction_obj.item.seller.username} (
                        <c:forEach begin="1" end="${auction_obj.item.seller.stars + 1}">
                            <span class="glyphicon glyphicon-star"></span>
                        </c:forEach> )
                    </div>
                </div>
                <div class="row">
                    <span class="text-primary">Description:</span> ${auction_obj.item.product.description}
                </div>

            </div>
        </div>
        <div class="panel-footer">

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
    <script type="text/javascript">
        $('#auc_${auction_obj.id}_tl').countdown(new Date(parseInt(${auction_obj.endTS}) * 1000), function(event) {
            $(this).html(event.strftime('%D days %H:%M:%S'));
        });
    </script>
</div>
