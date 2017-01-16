<%@ page import="java.util.List" %>
<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: 黄桂道
  Date: 2017-1-12
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人员信息列表</title>
</head>
<body>
<br/>
<br/>
<h1 style="text-align: center">添加人员信息</h1>
<br/>
<hr width="80%" style="margin: auto"/>
<br/>
<table style="margin: auto" cellpadding="0" cellspacing="0" width="511px" border="1px solid #00FF00">
    <tbody>
    <tr>
        <td height="22px" align="center" colspan="4">查看人员信息</td>
    </tr>
    <tr align="center" style="font-weight: bold">
        <td width="20%">姓名</td>
        <td width="20%">性别</td>
        <td width="20%">年龄</td>
        <td>地址</td>
    </tr>
        <%
            List<User> list = (List<User>) application.getAttribute("users");
            if(list!=null){
                for (User user : list) {
                    %>
        <tr align="center">
            <td><%=user.getName()%></td>
            <td><%=user.getSex()%></td>
            <td><%=user.getAge()%></td>
            <td><%=user.getAddress()%></td>
        </tr>
        <%
                }
            }
        %>
    <tr align="center">
        <td  height="22px" colspan="4"><a href="index.jsp">继续添加</a></td>
    </tr>
    </tbody>
</table>
</body>
</html>
