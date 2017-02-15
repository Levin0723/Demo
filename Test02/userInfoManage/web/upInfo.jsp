<%@ page import="entity.Info" %>
<%@ page import="dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: 黄桂道
  Date: 2017-1-21
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新用户</title>
    <script>
        function check() {
            var ps = document.getElementById("ps").value;
            var pss = document.getElementById("pss").value;
            if (ps==pss){
                return true;
            }else {
                alert("两次输入的密码不一致！");
                return false;
            }
        }
    </script>
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Info info = UserDao.getInfoById(id);
%>
<h3 align="center">更新编号：<%=info.getId()%>的用户信息</h3>
<form action="upInfoServlet" method="post" onsubmit="return check()">
    <table align="center">
        <tr>
            <th>姓名：</th>
            <td><input type="text" name="name" value="<%=info.getName()%>"/></td>
        </tr>
        <tr>
            <th>密码：</th>
            <td><input type="password" name="pass" value="<%=info.getPass()%>" id="ps"/></td>
        </tr>
        <tr>
            <th>重复密码：</th>
            <td><input type="password" name="repass" value="<%=info.getPass()%>" id="pss"/></td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="hidden" name="id" value="<%=info.getId()%>" />
                <input type="submit" value="更新"/>
                <input type="reset" value="重置"/>
                <a href="index.jsp"><button>返回</button></a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
