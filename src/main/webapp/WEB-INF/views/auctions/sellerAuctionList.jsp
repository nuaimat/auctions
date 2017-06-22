<%--
  Created by IntelliJ IDEA.
  User: nuaimat
  Date: 6/21/17
  Time: 12:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="../templates/header_template.jsp">
    <jsp:param name="title" value="e-Auction homepage"/>
</jsp:include>
<c:url value="/" var="url_root" />
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3">
            <div class="righttoolbox">
            </div>
        </div>
        <div class="col-sm-6" id="auc_list_col">
            <h2>My Seller Auctions:</h2>
            <dl>
                <c:forEach var="auc" items="${myAuctions}">
                    <dt>${auc.item.product.name} Posted on ${auc.item.created} till ${auc.end}</dt>
                    <dd>Qty: ${auc.item.quantity} Highest Bid: $${auc.currentMinBid}
                     <div>
                         <c:choose>
                             <c:when test="${not empty auc.bids}">
                                 Winner: ${auc.bids[0].customer.username} paying: ${auc.bids[0].amount}
                             </c:when>
                             <c:otherwise>
                                 Min Bid not met
                             </c:otherwise>

                         </c:choose>
                     </div>
                        <div>
                            <b>Status: </b> ${auc.statusAsString}
                        </div>
                    <c:if test="${not auc.active}">
                        <form action="<c:url value="/auctions/${auc.id}/activate" />" method="post">
                            <input type="submit" value="Activate">
                            <input type="hidden"
                                   name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                        </form>
                        <form action="<c:url value="/auctions/${auc.id}/edit" />" method="get">
                            <input type="submit" value="Edit">
                            <input type="hidden"
                                   name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                        </form>
                        <form action="<c:url value="/auctions/${auc.id}/delete" />" method="post">
                            <input type="submit" value="Delete">
                            <input type="hidden"
                                   name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                        </form>
                    </c:if><br /><hr width="100%" />
                    </dd>
                </c:forEach>
            </dl>
        </div>
        <div class="col-sm-3">
            <div class="righttoolbox">

            </div>

        </div>
    </div>

</div>

<jsp:include page="../templates/footer_template.jsp"/>