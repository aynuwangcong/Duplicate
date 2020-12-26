<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
    function checkForm(){
        var classes_id=document.getElementById("classes_id").value;
        var classes_name=document.getElementById("classes_name").value;
        var c_usual_total_score=document.getElementById("c_usual_total_score").value;
        var c_usual_average_score=document.getElementById("c_usual_average_score").value;
        var c_exam_total_score=document.getElementById("c_exam_total_score").value;
        var c_exam_average_score=document.getElementById("c_exam_average_score").value;
        var c_total_total_score=document.getElementById("c_total_total_score").value;
        var c_total_average_score=document.getElementById("c_total_average_score").value;
        if(classes_id==""||classes_name==""||c_usual_total_score==""||c_usual_average_score==""||c_exam_total_score==""||c_exam_average_score==""||c_total_total_score==""||c_total_average_score==""){
            document.getElementById("error").innerHTML="信息填写不完整！";
            return false;
        }
        return true;
    }

</script>
<div class="data_list">
    <div class="data_list_title">
        <c:choose>
            <c:when test="${classes.classes_id!=null }">
                修改班级信息
            </c:when>
            <c:otherwise>
                添加班级信息
            </c:otherwise>
        </c:choose>
    </div>
    <form action="${pageContext.request.contextPath}/classes/add" method="post" onsubmit="return checkForm()">
        <div class="data_form"  align="center">
            <input type="hidden" id="student" name="method" value="${classes.classes_id}"/>
            <table align="center">
                <tr>
                    <td><font color="red">*</font>班级号：</td>
                    <td><input type="text" id="classes_id"  name="classes_id" value="${classes.classes_id}"  style="margin-top:5px;height:30px;" /></td>
                </tr>
                <tr>
                    <td><font color="red">*</font>班级名：</td>
                    <td><input type="text" id="classes_name"  name="classes_name" value="${classes.classes_name }"  style="margin-top:5px;height:30px;" /></td>
                </tr>
                <tr>
                    <td><font color="red">*</font>平时总成绩：</td>
                    <td><input type="text" id="c_usual_total_score"  name="c_usual_total_score" value="${classes.c_usual_total_score }" style="margin-top:5px;height:30px;" /></td>
                </tr>
                <tr>
                    <td><font color="red">*</font>平时平均成绩：</td>
                    <td><input type="text" id="c_usual_average_score"  name="c_usual_average_score" value="${classes.c_usual_average_score }" style="margin-top:5px;height:30px;" /></td>
                </tr>
                <tr>
                    <td><font color="red">*</font>考试总成绩：</td>
                    <td><input type="text" id="c_exam_total_score"  name="c_exam_total_score" value="${classes.c_exam_total_score }" style="margin-top:5px;height:30px;" /></td>
                </tr>
                <tr>
                    <td><font color="red">*</font>考试平均成绩：</td>
                    <td><input type="text" id="c_exam_average_score" name="c_exam_average_score" value="${classes.c_exam_average_score }" style="margin-top:5px;height:30px;" /></td>
                </tr>
                <tr>
                    <td><font color="red">*</font>最终总成绩：</td>
                    <td><input type="text" id="c_total_total_score"  name="c_total_total_score" value="${classes.c_total_total_score }" style="margin-top:5px;height:30px;" /></td>
                </tr>
                <tr>
                    <td><font color="red">*</font>总平均成绩：</td>
                    <td><input type="text" id="c_total_average_score" name="c_total_average_score" value="${classes.c_total_average_score }" style="margin-top:5px;height:30px;" /></td>
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