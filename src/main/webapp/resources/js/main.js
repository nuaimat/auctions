/**
 * Created by nuaimat on 4/24/17.
 */


$(function () {


    rightoolboxtop = $('.righttoolbox').offset().top;
    $(document).scroll(function(){
        $('.righttoolbox').css('position','');
        rightoolboxtop = $('.righttoolbox').offset().top;
        $('.righttoolbox').css('position','absolute');
        setTimeout(function () {
            if($(document).scrollTop() < 5){
                rightoolboxtop = 0;
            }
            $('.righttoolbox').css('top',Math.max(rightoolboxtop,$(document).scrollTop()));
        }, 100);
        if($("#scrollme").length) {
            displayMoreAuctions();
        }
    });

    var busyLoadingAuctions = false;
    var currentAuctionPage = 0;
    function displayMoreAuctions(){
        if(busyLoadingAuctions)
            return;

        if($(window).scrollTop() + $(window).height() >= $(document).height()){
            busyLoadingAuctions = true;
            currentAuctionPage = currentAuctionPage + 1;
            console.log("request ajax page " + currentAuctionPage);
            $.ajax({
                url: "api/auctions", //this is the submit URL
                type: "GET",
                data: {page: currentAuctionPage},
                success: function (data) {
                    data = $.trim(data);
                    if(data.length < 1){ // empty response
                        currentAuctionPage -= 1;
                        busyLoadingAuctions = false;
                        return;
                    }
                    console.log($("#auc_list_col"));
                    console.log($(data));

                    $("#auc_list_col").append($(data));
                    busyLoadingAuctions = false;
                },
                error: function (err) {
                    console.log("Error during ajax " + err);
                    currentAuctionPage -= 1; // to retry again
                    busyLoadingAuctions = false;
                }
            });
        }

    }

});

var rightoolboxtop = 0;