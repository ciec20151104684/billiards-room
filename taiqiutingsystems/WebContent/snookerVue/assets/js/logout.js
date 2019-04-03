$("#logout-btn").click(function(){
    $.ajax({
        type: 'GET',
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        url: BASEURL+"login/doLogout",
        success: function(res){ 
            console.log(res)
            if(res.status==2){
                alert("注销成功")
                window.location.replace("./login.html");
            }else{
                alert(res.message)
            }
        },
    });
})