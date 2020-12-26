<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查重结果页面</title>
</head>
<body>
<h2>${name1}的${originFilename1}与${name2}的${originFilename2}重复度为：${result}</h2>
<button style="margin-left: 62px;margin-top: 25px;" class="btn btn-large btn-primary" onclick="javascript:history.back()">返回</button>
</body>
</html>