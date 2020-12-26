<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
    function checkForm(){
        var student_id=document.getElementById("student_id").value;
        var student_name=document.getElementById("student_name").value;
        var student_age=document.getElementById("student_age").value;
        var student_sex=document.getElementById("student_sex").value;
        var university=document.getElementById("university").value;
        var classes_name=document.getElementById("classes_name").value;
        var telphone=document.getElementById("telphone").value;
        if(student_id==""||student_name==""||student_age==""||student_sex==""||university==""||classes_name==""||telphone==""){
            document.getElementById("error").innerHTML="信息填写不完整！";
            return false;
        }
        return true;
    }

</script>
<div class="data_list">
    <div class="data_list_title">
        <c:choose>
            <c:when test="${student.student_id!=null }">
                修改学生
            </c:when>
            <c:otherwise>
                添加学生
            </c:otherwise>
        </c:choose>
    </div>
    <form action="${pageContext.request.contextPath}/student/add?pageStartIndex=${pageStartIndex}" method="post" onsubmit="return checkForm()">
        <div class="data_form"  align="center">
            <input type="hidden" id="student" name="method" value="${student.id}"/>
            <table align="center">
                <tr>
                    <td><font color="red">*</font>学号：</td>
                    <td><input type="text" id="student_id"  name="student_id" value="${student.student_id}"  style="margin-top:5px;height:30px;" /></td>
                </tr>
                <tr>
                    <td><font color="red">*</font>姓名：</td>
                    <td><input type="text" id="student_name"  name="student_name" value="${student.student_name }"  style="margin-top:5px;height:30px;" /></td>
                </tr>
                <tr>
                    <td><font color="red">*</font>年龄：</td>
                    <td><input type="text" id="student_age"  name="student_age" value="${student.student_age }" style="margin-top:5px;height:30px;" /></td>
                </tr>

                <tr>
                    <td><font color="red">*</font>性别：</td>
                    <td>
                        <select id="student_sex" name="student_sex" value="${student.student_sex }" style="width: 90px;">
                            <option>${student.student_sex }</option>
                            <option>男</option>
                            <option>女</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><font color="red">*</font>学校：</td>
                    <td><input type="text" id="university"  name="university" value="${student.university }" style="margin-top:5px;height:30px;" /></td>
                </tr>
                <tr>
                    <td><font color="red">*</font>班级：</td>
                    <td><input type="text" id="classes_name"  name="classes_name" value="${student.classes_name }" style="margin-top:5px;height:30px;" /></td>
                </tr>
                <tr>
                    <td><font color="red">*</font>电话：</td>
                    <td><input type="text" id="telphone" name="telphone" value="${student.telphone }" style="margin-top:5px;height:30px;" /></td>
                </tr>
            </table>
            <div align="center">
                <input type="submit" class="btn btn-primary" value="保存"/>
                &nbsp;<button class="btn btn-primary" type="button" onclick="javascript:history.back()">返回</button>
            </div>
            <div align="center">
                <font id="error" color="red">${error }</font>
            </div>
        </div>
    </form>
</div>