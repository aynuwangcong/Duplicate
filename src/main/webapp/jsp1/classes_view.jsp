<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
    function dormManagerDelete(dormManagerId) {
        if(confirm("您确定要删除这个班级信息吗？")) {
            window.location="${pageContext.request.contextPath}/classes/delete?student_id="+dormManagerId;
        }
    }

</script>
<div class="data_list">
    <div class="data_list_title">
        班级信息管理系统
    </div>
    <button style="padding-bottom: 0;margin-bottom: 0;float: left" class="btn btn-success" type="button" style="margin-right: 50px;" onclick="javascript:window.location='${pageContext.request.contextPath}/classes/preAdd?classes_id=null'">添加</button>

    <form class="form-search" action="${pageContext.request.contextPath}/classes/compound" method="post" style="float: right" onsubmit="return checkForm()">
        <table class="data_search" style="float: right">


            <span>班级号：</span>
            &nbsp;<input name="classes_id" type="text" value="${classes1.classes_id}"  style="width:120px;height: 30px;" class="input-medium search-query" >
            <span>班级名：</span>
            &nbsp;<input name="classes_name" type="text" value="${classes1.classes_name}"  style="width:120px;height: 30px;" class="input-medium search-query" >
            &nbsp;<button type="submit" class="btn btn-info" onkeydown="if(event.keyCode==13) myForm.submit()">搜索</button>
        </table>
    </form>
    <div>
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>班级号</th>
                <th>班级名</th>
                <th>平时总成绩</th>
                <th>平时平均成绩</th>
                <th>考试总成绩</th>
                <th>考试平均成绩</th>
                <th>最终总成绩</th>
                <th>总平均成绩</th>
                <th>操作</th>
            </tr>
            <c:forEach  varStatus="i" var="c" items="${contactorList2}">
                <tr>
                    <td>${c.classes_id}</td>
                    <td>${c.classes_name}</td>
                    <td>${c.c_usual_total_score}</td>
                    <td>${c.c_usual_average_score}</td>
                    <td>${c.c_exam_total_score}</td>
                    <td>${c.c_exam_average_score}</td>
                    <td>${c.c_total_total_score}</td>
                    <td>${c.c_total_average_score}</td>
                    <td><button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='${pageContext.request.contextPath}/classes/preAdd?classes_id=${c.classes_id}'">修改</button>&nbsp;
                        <button class="btn btn-mini btn-danger" type="button" onclick="dormManagerDelete(${c.classes_id})">删除</button></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="pagination pagination-centered">
        <ul class="pagination pagination-lg">

            <li><a href="${pageContext.request.contextPath}/classes/querystudent?pagenum=1">首页</a></li>
            <c:choose>
                <c:when test="${page.pagenum== 1 }">
                    <li><a href="#">上一页</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/classes/querystudent?pagenum=${page.pagenum-1}">上一页</a></li>
                </c:otherwise>
            </c:choose>
            <li><a href="${pageContext.request.contextPath}/classes/querystudent?pagenum=1">1</a></li>
            <li><a href="${pageContext.request.contextPath}/classes/querystudent?pagenum=2">2</a></li>
            <li><a href="${pageContext.request.contextPath}/classes/querystudent?pagenum=3">3</a></li>
            <c:choose>
                <c:when test="${page.pagenum>=page.totalPages}">
                    <li><a href="#">下一页</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/classes/querystudent?pagenum=${page.pagenum+1}">下一页</a></li>
                </c:otherwise>
            </c:choose>
            <li><a href="${pageContext.request.contextPath}/classes/querystudent?pagenum=${page.totalPages}">尾页</a></li>

        </ul>
    </div>
</div>