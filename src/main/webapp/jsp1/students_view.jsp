<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
    function dormManagerDelete(students_id) {
        if(confirm("您确定要删除这个学生信息吗？")) {
            window.location="${pageContext.request.contextPath}/students/delete?student_id="+students_id+"&&pageStartIndex="+${pageStartIndex};
        }
    }

    // $(document).ready(function(){
    //     $("ul li:eq(1)").addClass("active");
    // });
</script>
<div class="data_list">
    <div class="data_list_title">
        学生个人信息统计
    </div>
    <button style="padding-bottom: 0;margin-bottom: 0;float: left" class="btn btn-success" type="button" style="margin-right: 50px;" onclick="javascript:window.location='${pageContext.request.contextPath}/students/preAdd?student_id=null&&pageStartIndex=${pageStartIndex}'">添加</button>

    <form class="form-search" action="${pageContext.request.contextPath}/students/compound?pageStartIndex=${pageStartIndex}" method="post" style="float: right" onsubmit="return checkForm()">
        <table class="data_search" style="float: right">
            <select style="width: 100px;" id="searchType" name="searchType" style="width: 80px;" onchange="this">
                <option value="">成绩查询</option>
                <option value="优秀">优秀</option>
                <option value="良好">良好</option>
                <option value="及格">及格</option>
                <option value="不及格">不及格</option>
            </select>
            <span>学号：</span>
            &nbsp;<input name="student_id" type="text" value="${students1.student_id}" style="width:120px;height: 30px;" class="input-medium search-query" >
            <span>姓名：</span>
            &nbsp;<input name="student_name" type="text" value="${students1.student_name}" style="width:120px;height: 30px;" class="input-medium search-query" >
            <span>班级：</span>
            &nbsp;<input name="classes_name" type="text" value="${students1.classes_name}" style="width:120px;height: 30px;" class="input-medium search-query" >
            &nbsp;<button type="submit" class="btn btn-info" onkeydown="if(event.keyCode==13) myForm.submit()">搜索</button>
        </table>
    </form>
    <div>
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>班级</th>
                <th>课程</th>
                <th>平时成绩</th>
                <th>考试成绩</th>
                <th>总成绩</th>
                <th>操作</th>
            </tr>
            <c:forEach  varStatus="i" var="c" items="${contactorList1}">
                <tr>
                    <td>${c.student_id}</td>
                    <td>${c.student_name}</td>
                    <td>${c.classes_name}</td>
                    <td>${c.course_name}</td>
                    <td>${c.s_usual_score}</td>
                    <td>${c.s_exam_score}</td>
                    <td>${c.s_total_score}</td>
                    <td><button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='${pageContext.request.contextPath}/students/preAdd?student_id=${c.student_id}&&pageStartIndex=${pageStartIndex}'">修改</button>&nbsp;
                        <button class="btn btn-mini btn-danger" type="button" onclick="dormManagerDelete(${c.student_id})">删除</button></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="pagination pagination-centered">
        <ul class="pagination pagination-lg">
            <li><a href="${pageContext.request.contextPath}/students/querystudent?pagenum=1">首页</a></li>
                <c:choose>
                    <c:when test="${page.pagenum== 1 }">
                        <li><a href="#">上一页</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/students/querystudent?pagenum=${page.pagenum-1}">上一页</a></li>
                    </c:otherwise>
                </c:choose>

            <li><a href="${pageContext.request.contextPath}/students/querystudent?pagenum=1">1</a></li>
            <li><a href="${pageContext.request.contextPath}/students/querystudent?pagenum=2">2</a></li>
            <li><a href="${pageContext.request.contextPath}/students/querystudent?pagenum=3">3</a></li>
                <c:choose>
                    <c:when test="${page.pagenum>=page.totalPages}">
                        <li><a href="#">下一页</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/students/querystudent?pagenum=${page.pagenum+1}">下一页</a></li>
                    </c:otherwise>
                </c:choose>

            <li><a href="${pageContext.request.contextPath}/students/querystudent?pagenum=${page.totalPages}">尾页</a></li>
        </ul>
        <ul>

        </ul>
    </div>
</div>