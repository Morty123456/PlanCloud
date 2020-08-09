function getMaximumSpeed() {
    // alert("进入查询数据的显示动作范围的js页面")
    // var getData = [10,80,-30,180,50,175];
    $.ajax({
        url:"/getRobotNum",
        type:"post",
        dataType:"json",
        data:{
            "numType":"maximumSpeed"
        },
        success:function (data) {
            if (data==null)
                alert("未获取到数据")
            else{
                // alert(data);
                var len = data[0].length;
                var x = new Array(len);
                for(var i=0;i<len;i++)
                    x[i] = i+"";
                option_S.xAxis.data=x;
                option_S.series[0].data=data[0];
                option_L.xAxis.data=x;
                option_L.series[0].data=data[1];
                option_U.xAxis.data=x;
                option_U.series[0].data=data[2];
                option_R.xAxis.data=x;
                option_R.series[0].data=data[3];
                option_B.xAxis.data=x;
                option_B.series[0].data=data[4];
                option_T.xAxis.data=x;
                option_T.series[0].data=data[5];
                // $("tData").html(getData)
                myChart_S.setOption(option_S);
                myChart_L.setOption(option_L);
                myChart_U.setOption(option_U);
                myChart_R.setOption(option_R);
                myChart_B.setOption(option_B);
                myChart_T.setOption(option_T);
            }
        },
        error:function (e) {
            alert("连接数据库失败")
        }
    })
}