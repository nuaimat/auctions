<%--
  Created by IntelliJ IDEA.
  User: Subhechha Bista
  Date: 6/21/2017
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row" style="margin-top: 25px;line-height: 30px">

    <c:url var="bidaction" value="/auctions/bid"/>
    <form:form id="bidform" modelAttribute="${param.bid_model}" method="post"
               action="${bidaction}">
        <div class="col-sm-3" style="padding-left: 0;vertical-align: middle">Bid on this auction:</div>
        <div class="col-sm-6" style="vertical-align: middle">
            <input type="hidden" name="auction_id" value="${auction_obj.id}"/>
                <form:input path="amount" type="number" placeholder="1.33"
                            step="0.01" min="${auction_obj.currentMinBid}"
                            cssStyle="width: 99%"
                />
        </div>

        <div class="col-sm-3" style="vertical-align: middle">
            <form:button id="register" name="register" class="btn btn-default" style="width: 90%">
                Bid
            </form:button>
        </div>
    </form:form>

</div>

