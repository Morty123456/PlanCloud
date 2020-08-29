$(document).ready(function () {
    var file;
    file = $('<input type="file" />');
    $("#searchFile").click(function() {
        // alert("上传文件");
        // alert(file);
        // $("#file").trigger('click');
        file.click();
    })
    file.change(function(e){
        var select_file = file[0].files[0].name;
        //前端文件改名
        $("#fileName").val(select_file);
        // alert(select_file);
    })
    $("#upload").click(function () {
        var fileType = $("#fileType").val();
        var formData = new FormData();
        formData.append('file', file[0].files[0]);
        formData.append('fileType', fileType);
        //打印file的信息瞅一眼
        console.log(file);
        console.log(file[0].files[0]);

        alert(file[0].files[0].name);
        $.ajax({
            url:"/file",
            type:"POST",
            cache:false,
            data:formData,
            processData:false,
            contentType:false,
            success: function (data) {
                if (data=="success")
                    alert(file[0].files[0].name+"上传成功");
                else
                    alert(file[0].files[0].name+"上传失败");
            },
            error: function (e) {
                alert(file[0].files[0].name+"没有上传成功");
            }
        })
    })

})