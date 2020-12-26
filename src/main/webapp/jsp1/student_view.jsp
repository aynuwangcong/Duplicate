<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
    function dormManagerDelete(student_id) {
        if(confirm("您确定要删除这个学生吗？")) {
            window.location="${pageContext.request.contextPath}/student/delete?student_id="+student_id+"&&pageStartIndex="+${pageStartIndex};
        }
    }

</script>
<div class="data_list">
    <div class="data_list_title">
        学生信息管理系统
    </div>
    <button style="padding-bottom: 0;margin-bottom: 0;float: left" class="btn btn-success" type="button" style="margin-right: 50px;" onclick="javascript:window.location='${pageContext.request.contextPath}/student/preAdd?student_id=null&&pageStartIndex=${pageStartIndex}'">添加</button>

    <form class="form-search" action="${pageContext.request.contextPath}/student/compound?pageStartIndex=${pageStartIndex}" method="post" style="float: right" >
    				<table class="data_search" style="float: right">
                        <select id="searchType" name="searchType" style="width: 80px;" onchange="this">
                            <option value="student_name">姓名</option>
                            <option value="university">学校</option>
                            <option value="classes_name">班级</option>
                        </select>
                        <input name="Text" type="text" value="${Text}" style="width:120px;height: 30px;" class="input-medium search-query" >

                         <span> 学号:</span>
    					&nbsp;<input name="student_id" type="text" value="${student1.student_id}" style="width:120px;height: 30px;" class="input-medium search-query" >
                         <span> 性别:</span>
                       &nbsp;<input name="student_sex" type="text" value="${student1.student_sex}" style="width:120px;height: 30px;" class="input-medium search-query" >
    				     <span> 年龄:</span>
    					&nbsp;<input name="student_age" type="text" value="${student1.student_age}"  style="width:120px;height: 30px;" class="input-medium search-query" >
    					&nbsp;<button type="submit" class="btn btn-info" onkeydown="if(event.keyCode==13) myForm.submit()">搜索</button>
    				</table>
    		</form>
    <div>
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>学校</th>
                <th>班级</th>
                <th>电话</th>
                <th>操作</th>
            </tr>
            <c:forEach  varStatus="i" var="c" items="${contactorList}">
                <tr>
                    <td>${c.student_id}</td>
                    <td>${c.student_name}</td>
                    <td>${c.student_age}</td>
                    <td>${c.student_sex}</td>
                    <td>${c.university}</td>
                    <td>${c.classes_name}</td>
                    <td>${c.telphone}</td>
                    <td><button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='${pageContext.request.contextPath}/student/preAdd?student_id=${c.student_id}&&pageStartIndex=${pageStartIndex}'">修改</button>&nbsp;
                        <button class="btn btn-mini btn-danger" type="button" onclick="dormManagerDelete(${c.student_id})">删除</button></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="pagination pagination-centered">
        <ul class="pagination pagination-lg">
            <li><a href="${pageContext.request.contextPath}/student/querystudent?pagenum=1">首页</a></li>
            <c:choose>
                <c:when test="${page.pagenum== 1 }">
                    <li><a href="#">上一页</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/student/querystudent?pagenum=${page.pagenum-1}">上一页</a></li>
                </c:otherwise>
            </c:choose>

            <li><a href="${pageContext.request.contextPath}/student/querystudent?pagenum=1">1</a></li>
            <li><a href="${pageContext.request.contextPath}/student/querystudent?pagenum=2">2</a></li>
            <li><a href="${pageContext.request.contextPath}/student/querystudent?pagenum=3">3</a></li>

            <c:choose>
                <c:when test="${page.pagenum>=page.totalPages}">
                    <li><a href="#">下一页</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/student/querystudent?pagenum=${page.pagenum+1}">下一页</a></li>
                </c:otherwise>
            </c:choose>

            <li><a href="${pageContext.request.contextPath}/student/querystudent?pagenum=${page.totalPages}">尾页</a></li>
        </ul>

    </div>
</div>