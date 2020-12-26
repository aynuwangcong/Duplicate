<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
    function checkForm(){
        var student_id=document.getElementById("student_id").value;
        var student_name=document.getElementById("student_name").value;
        var classes_name=document.getElementById("classes_name").value;
        var course_name=document.getElementById("course_name").value;
        var s_usual_score=document.getElementById("s_usual_score").value;
        var s_exam_score=document.getElementById("s_exam_score").value;
        var s_total_score=document.getElementById("s_total_score").value;
        if(student_id==""||student_name==""||classes_name==""||course_name==""||s_usual_score==""||s_exam_score==""||s_total_score==""){
            document.getElementById("error").innerHTML="信息填写不完整！";
            return false;
        }
        return true;
    }

    $(document).ready(function(){
        $("ul li:eq(1)").addClass("active");
    });
</script>
<div class="data_list">
    <div class="data_list_title">
        <c:choose>
            <c:when test="${students.student_id!=null }">
                修改学生信息
            </c:when>
            <c:otherwise>
                添加新的学生信息
            </c:otherwise>
        </c:choose>
    </div>
    <form action="${pageContext.request.contextPath}/students/add?pageStartIndex=${pageStartIndex}" method="post" onsubmit="return checkForm()">
        <div class="data_form"  align="center">
            <input type="hidden" id="student" name="method" value="${students.student_id}"/>
<%--            待修改--%>
            <table align="center">
                <tr>
                    <td><font color="red">*</font>学号：</td>
                    <td><input type="text" id="student_id"  name="student_id" value="${students.student_id}"  style="margin-top:5px;height:30px;" /></td>
                </tr>
                <tr>
                    <td><font color="red">*</font>姓名：</td>
                    <td><input type="text" id="student_name"  name="student_name" value="${students.student_name }"  style="margin-top:5px;height:30px;" /></td>
                </tr>
                <tr>
                    <td><font color="red">*</font>班级：</td>
                    <td><input type="text" id="classes_name"  name="classes_name" value="${students.classes_name }" style="margin-top:5px;height:30px;" /></td>
                </tr>

                <tr>
                    <td><font color="red">*</font>课程：</td>
                    <td><input type="text" id="course_name"  name="course_name" value="${students.course_name }" style="margin-top:5px;height:30px;" /></td>
                </tr>
                <tr>
                    <td><font color="red">*</font>平时成绩：</td>
                    <td><input type="text" id="s_usual_score"  name="s_usual_score" value="${students.s_usual_score }" style="margin-top:5px;height:30px;" /></td>
                </tr>
                <tr>
                    <td><font color="red">*</font>考试成绩：</td>
                    <td><input type="text" id="s_exam_score"  name="s_exam_score" value="${students.s_exam_score }" style="margin-top:5px;height:30px;" /></td>
                </tr>
                <tr>
                    <td><font color="red">*</font>总成绩：</td>
                    <td><input type="text" id="s_total_score" name="s_total_score" value="${students.s_total_score }" style="margin-top:5px;height:30px;" /></td>
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