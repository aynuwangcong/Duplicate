<%--
  Created by IntelliJ IDEA.
  User: 聪聪
  Date: 2020/12/18
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
    <style>
        .file{
            padding-left: 100px;
            padding-top: 50px;
        }
    </style>
    <script>
        // 判断是否填写上传人并已选择上传文件
        function check(){
            var name = document.getElementById("name").value;
            var file = document.getElementById("file").value;
            if(name==""){
                alert("填写上传人");
                return false;
            }
            if(file.length==0||file==""){
                alert("请选择上传文件");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<form class="file" action="${pageContext.request.contextPath}/student/fileUpload" method="post" enctype="multipart/form-data" onsubmit="return check()">
    <h2>提交作业</h2>
    上传人：<input class="form-group" id="name" type="text" name="name" /><br />
    请选择文件：<input id="file" type="file" name="uploadfile" multiple="multiple" /><br />
    <button type="submit" class="btn btn-large btn-primary">上传</button>
</form>
</body>
</html>
