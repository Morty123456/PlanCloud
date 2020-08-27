$(document).ready(function () {
    // alert("登陆点击")
    //使用jquery，在html页面要引入jquery.js
    $('#btn').click(function () {
        var login_name = $("#login_name").val();
        var login_password = $("#password").val();
        // alert(login_name+" "+login_password);
        // window.location.href='../templates/index.html';
        $.ajax({
            url: "/login",
            type: "post",
            dataType:"",
            data : {
                "username": login_name,
                "password": login_password
            },
            success: function (data) {
                // var re = JSON.parse(data);
                alert(data);
                console.log(data);
                if(data== "1")
                    window.location.href='../templates/index.html';
                else{
                    alert("用户名或密码不正确！");
                    window.location.href='../templates/login.html';
                }
            },
            error: function (e) {
                console.log(e);
                // alert("连接数据库失败");
                // console.log(e.toString());
                console.log("faild")
            }
        })
    });
})
