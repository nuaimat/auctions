<%--
  Created by IntelliJ IDEA.
  User: nuaimat
  Date: 6/19/17
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="../templates/header_template.jsp">
    <jsp:param name="title" value="e-Auction homepage"/>
</jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3">
            <div class="righttoolbox">
                <c:url var="add_url" value="/auctions/add" />
                <button type="submit" class="btn btn-info btn-lg" onclick="window.location = '${add_url}';" >
                    Add new Auction
                </button>
            </div>



            <!-- Modal -->
            <div id="newRideModal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Request or Offer a Ride</h4>
                        </div>
                        <div class="modal-body">

                            <form method="post" action="<c:url value="/trips" />" id="new-ride-form">
                                <div class="form-group">
                                    <label for="ridetype">Are you?</label>
                                    <select class="form-control" id="ridetype" name="ridetype">
                                        <option value="0">Offering a ride - I am a driver</option>
                                        <option value="1">Asking for a ride - I am a passenger</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="ridesrc">Source:</label>
                                    <input type="text" class="form-control" id="ridesrc" name="ridesrc">
                                    <input type="hidden" name="ridesrc_coords" id="ridesrc_coords">
                                    <div id="src_map_canvas" style="width: 100%; height:100px"></div>
                                </div>
                                <div class="form-group">
                                    <label for="ridedest">Destination:</label>
                                    <input type="text" class="form-control" id="ridedest" name="ridedest">
                                    <input type="hidden" name="ridedest_coords" id="ridedest_coords">
                                    <div id="dest_map_canvas" style="width: 100%; height:100px"></div>
                                </div>
                                <div class="form-group">
                                    <label for="ridedesc">Description:</label>
                                    <textarea class="form-control" id="ridedesc" name="ridedesc" rows="3"></textarea>
                                </div>
                            </form>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal" id="submit_new_ride">
                                Submit
                            </button>
                        </div>
                    </div>

                </div>
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