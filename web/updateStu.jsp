<%@ page import="org.lanqiao.pojo.student" %><%--
  Created by IntelliJ IDEA.
  User: 听音乐的酒
  Date: 2018/11/6
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
</head>
<body>

    <%
        //首先需要从request中获取选中的学生信息
        student student =(student) request.getAttribute("student");
    %>
    <%--修改之后需要进行提交，用from表单--%>
    <form action="/studentServlet" method="post">
        <input type="hidden" name="method" value="updateStu">
        id  :<input type="hidden" name="sid" value="<%=student.getSid()%>" ><br><br>
        姓名：<input type="text" name="sname"  value="<%=student.getSname()%>" ><br><br>
        年龄：<input type="text" name="sage"  value="<%=student.getSage()%>" ><br><br>
        省份：<input type="text" name="sprovince"  value="<%=student.getSprovince()%>" ><br><br>
        学费：<input type="text" name="stuition"  value="<%=student.getStuition()%>" ><br><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
