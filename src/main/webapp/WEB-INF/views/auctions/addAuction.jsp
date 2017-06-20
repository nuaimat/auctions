<%--
  Created by IntelliJ IDEA.
  User: nuaimat
  Date: 6/19/17
  Time: 11:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="../templates/header_template.jsp">
    <jsp:param name="title" value="e-Auction homepage"/>
</jsp:include>
<c:url value="/" var="url_root" />
<%--<script src="${url_root}resources/js/jquery.datetimepicker.full.js"></script>
<link rel="stylesheet" href="${url_root}resources/css/jquery.datetimepicker.min.css">
<script>
    $( function() {
        $.datetimepicker.setLocale('en');
        $('#datetimepicker_mask').datetimepicker({
            mask:'9999-19-39 29:59:00',
            startDate:'2017/05/01 00:00:00',
            step: 5,
            format:'Y-m-d h:i:s',
            roundTime:'floor'
        });

        $('#datetimepicker_mask').val('2017-07-19 19:01:02');


    } );
</script>--%>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3">
            <div class="righttoolbox">
            </div>
        </div>
        <div class="col-sm-6" id="auc_list_col">
            <form:form modelAttribute="auction" action="auctions" method="post">
                <h2>Add an Auction: ${auction.end}</h2>
                <div class="form-group">
                    <label>Product/Item:</label>
                    <select>
                        <c:forEach items="${myItems}" var="item">
                            <option value="${item.id}">${item.product.name}</option>
                        </c:forEach>
                    </select><span class="text" ><a href="<c:url value="/item/add" />">Add new item</a> </span>

                </div>
                <div class="form-group">
                    <label>End Date:</label>
                    <form:input path="end" type="text" placeholder="yyyy-mm-dd hh:mm:ss" />

                </div>
                <div class="form-group">
                    <label>Active:
                    <form:checkbox path="active" /></label>
                </div>
                <div class="form-group">
                    <label>Minimum Bid:
                        <form:input path="minimumBid" type="number" placeholder="1.33" step="0.01" />
                    </label>
                </div>

                <%--<table>
                    <tr>
                        <td></td>
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
                </table>--%>

            </form:form>
        </div>
        <div class="col-sm-3">
            <div class="righttoolbox">

            </div>

        </div>
    </div>

</div>
<jsp:include page="../templates/footer_template.jsp"/>