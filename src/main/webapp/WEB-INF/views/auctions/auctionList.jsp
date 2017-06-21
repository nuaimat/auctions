<%--
  Created by IntelliJ IDEA.
  User: nuaimat
  Date: 6/19/17
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../templates/header_template.jsp">
    <jsp:param name="title" value="e-Auction homepage"/>
</jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3">
            <div class="righttoolbox">
                <sec:authorize access="hasRole('ROLE_SELLER') and isAuthenticated()">
                    <c:url var="add_url" value="/auctions/add" />
                    <button type="submit" class="btn btn-info btn-lg" onclick="window.location = '${add_url}';" >
                        Add new Auction
                    </button>
                    <c:url var="seller_auc_list_url" value="/auctions/sellerList" />
                    <button type="submit" class="btn btn-info btn-lg" onclick="window.location = '${seller_auc_list_url}';" >
                        List My Auctions
                    </button>
                </sec:authorize>
            </div>


        </div>
        <div class="col-sm-6" id="auc_list_col">
            <c:forEach var="a" items="${auctions}">
                <c:set var="auction_obj" value="${a}" scope="request" />
                <c:set var="bid_obj" value="${bid}" scope="request" />
                <jsp:include page="auctionPanel.jsp">
                    <jsp:param name="bid_model" value="bid_obj"/>
                </jsp:include>
            </c:forEach>
        </div>
        <div class="col-sm-3">
            <div class="righttoolbox" style="width: 90%;text-align: center">
                <div class="well" style="text-align: center; width: 100%">
                    <img src="<c:url value="/resources/images/logo.png" />" >
                </div>
                <div id="statistics" class="well" style="text-align: center;">Statistics</div>
            </div>

        </div>
    </div>

</div>


<jsp:include page="../templates/footer_template.jsp"/>