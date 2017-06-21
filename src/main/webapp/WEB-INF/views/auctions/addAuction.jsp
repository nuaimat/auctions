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
            <c:url value="/auctions" var="auctions_endpoint" />
            <form:form modelAttribute="auction" action="${auctions_endpoint}?${_csrf.parameterName}=${_csrf.token}"
                       method="post" enctype="multipart/form-data">
                <h2>Add an Auction:</h2>
                <%--<div class="form-group">
                    <label>Product/Item:</label>
                    <select>
                        <c:forEach items="${myItems}" var="item">
                            <option value="${item.id}">${item.product.name}</option>
                        </c:forEach>
                    </select><span class="text space_left" ><a href="<c:url value="/item/add" />">Add new item</a> </span>

                </div>--%>
                <div class="form-group">
                    <form:errors path="*"  cssClass="alert alert-danger alert-dismissable" element="div" />
                </div>
                <div class="form-group">
                    <label>Product Name:</label>
                    <form:input path="item.product.name" type="text" />
                </div>

                <div class="form-group">
                    <label>Description:</label>
                    <form:textarea path="item.product.description" type="text" rows="3" cols="80" />
                </div>

                <div class="form-group">
                    <label>Quantity:</label>
                    <form:input path="item.quantity" type="number" pattern="[0-9]" step="1"  />

                </div>

                <div class="form-group">
                    <label>Product Image:</label>
                    <input type="file" name="product_image" />
                </div>

                <div class="form-group">
                    <label>End Date:</label>
                    <form:input path="end" type="text" placeholder="yyyy-mm-dd hh:mm:ss"
                                pattern="([0-9]){4}-([0-9]){2}-([0-9]){2} ([0-9]){2}:([0-9]){2}:([0-9]){2}" />

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

                <form:button type="submit" class="btn btn-info btn-lg">
                    Save Auction
                </form:button>
                <%--<input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>--%>
            </form:form>
        </div>
        <div class="col-sm-3">
            <div class="righttoolbox">

            </div>

        </div>
    </div>

</div>
<jsp:include page="../templates/footer_template.jsp"/>