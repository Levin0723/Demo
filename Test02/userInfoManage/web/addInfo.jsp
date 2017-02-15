<%--
  Created by IntelliJ IDEA.
  User: 黄桂道
  Date: 2017-1-21
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
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
<h3 align="center">添加用户</h3>
<form action="addInfoServlet" method="post" style="width: 600px;margin: auto;" onsubmit="return check()">
    <table style="width: 80%;margin: auto;">
        <tr>
            <th>姓名：</th>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <th>密码：</th>
            <td><input type="password" name="pass" id="ps"/></td>
        </tr>
        <tr>
            <th>重复密码：</th>
            <td><input type="password" name="repass" id="pss"/></td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" value="添加"/>
                <input type="reset" value="重置"/>
                <a href="index.jsp"><button>返回</button></a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
