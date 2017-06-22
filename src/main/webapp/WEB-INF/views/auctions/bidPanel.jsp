<%--
  Created by IntelliJ IDEA.
  User: Subhechha Bista
  Date: 6/21/2017
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row">
    <div class="panel panel-primary">
        <div class="panel-body">
            <div class="row">
                <c:url var="bidaction" value="/auctions/bid" />
                <form:form id="bidform" modelAttribute="${param.bid_model}" method="post"
                           action="${bidaction}">
                    <h4>Bid on product:</h4>
                    <div class="form-group">
                        <input type="hidden" name="auction_id" value="${auction_obj.id}" />
                        <label>Amount:
                            <form:input path="amount" type="number" placeholder="1.33"
                                        step="0.01" min="${auction_obj.currentMinBid}" />
                        </label>
                        <form:button id="register" name="register" class="btn">
                            Bid
                        </form:button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

