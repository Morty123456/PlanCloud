$(document).ready(function () {
    //使用jquery，在html页面要引入jquery.js
    $('#logout').click(function () {
        alert("注销点击")
        var name = sessionStorage.getItem("username");
        console.log(name);
        $.ajax({
            url: "/logout",
            type: "post",
            dataType: "json",
            data : {
            },
            success: function (data) {
                console.log(data);
                if(data!=null)
                    window.location.href='../templates/login.html';
            },
            error: function (e) {
                // console.log(e);
                // alert("连接数据库失败");
                // console.log(e.toString());
                console.log("faild")
            }
        })
    });
})
