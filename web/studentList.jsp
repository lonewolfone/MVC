<%@ page import="java.util.List" %>
<%@ page import="org.lanqiao.pojo.student" %><%--
  Created by IntelliJ IDEA.
  User: 听音乐的酒
  Date: 2018/11/5
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息列表</title>
</head>
<body>
    <h2>学生信息列表</h2>
    <table border="1px" cellspacing="0px">
        <%--表头--%>
        <thead>
            <th>id</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>省份</th>
            <th>学费</th>
            <th>操作</th>
            <th>操作</th>
        </thead>
        <%--表体：将学生信息放在表体中--%>
        <tbody>
            <%

                List<student> studentList = (List<student>) request.getAttribute("studentList");
                //使用for()循环来将数据放到每行中
                for (student student:studentList){
             %>

            <%--表行--%>
            <tr>
                <td><%=student.getSid()%></td>
                <td><%=student.getSname()%></td>
                <td><%=student.getSage()%></td>
                <td><%=student.getSprovince()%></td>
                <td><%=student.getStuition()%></td>
                <td><a href="/studentServlet?method=deleteStu&sid=<%=student.getSid()%>">删除</a></td>
                <td><a href="/studentServlet?method=findOneStu&sid=<%=student.getSid()%>">修改</a></td>
            </tr>

            <%
                }
            %>

        </tbody>
    </table>

</body>
</html>
