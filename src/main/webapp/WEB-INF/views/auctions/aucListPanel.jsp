<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nuaimat
  Date: 6/21/17
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<c:forEach var="a" items="${auctions}">
    <c:set var="auction_obj" value="${a}" scope="request" />
    <c:set var="bid_obj" value="${bid}" scope="request" />
    <jsp:include page="auctionPanel.jsp">
        <jsp:param name="bid_model" value="bid_obj"/>
    </jsp:include>
</c:forEach>
