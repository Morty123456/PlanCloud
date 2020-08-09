function getAllowableTorque() {
    // alert("进入查询数据的显示容许力矩的js页面")
    // var getData = [10,80,-30,180,50,175];
    $.ajax({
        url:"/getRobotNum",
        type:"post",
        dataType:"json",
        data:{
            "numType":"allowableTorque"
        },
        success:function (data) {
            if (data==null)
                alert("未获取到数据")
            else{
                // alert(data[0]);
                // alert(data[1]);
                // alert(data[2])
                var len = data[0].length;
                var x = new Array(len);
                for(var i=0;i<len;i++)
                    x[i] = i+"";
                // option.xAxis.data=x;
                // option.series[0].data=data;
                // $("tData").html(getData)
                // alert(data);
                option_R.xAxis.data=x;
                option_R.series[0].data=data[0];
                option_B.xAxis.data=x;
                option_B.series[0].data=data[1];
                option_T.xAxis.data=x;
                option_T.series[0].data=data[2];

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