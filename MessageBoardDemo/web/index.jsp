<%--
  Created by IntelliJ IDEA.
  User: 黄桂道
  Date: 2017-1-14
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.getParameter("do");
%>
<html>
<head>
    <title>登录留言本</title>
    <style>
        #sub{
            height: 50px;
        }
        #sub input{
            height: 30px;
            width: 60px;
            margin: auto 5px;
            background-color: darkorange;
            color: white;
            font-size: 15px;
            border: 1px solid coral;
        }
        #sub input:hover{
            background-color: chartreuse;
        }
    </style>
    <script>
        function register() {
            var re = getQueryString("do");
            if(re!=null){
                alert("帐号或密码不正确，请先注册或重新登录！")
            }
        }

        function getQueryString(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]); return null;
        }
    </script>
</head>
<body onload="register()">
<br/>
<h1 align="center">欢迎登录留言板</h1>
<div></div>
<hr style="width: 60%;margin: auto;" color="coral"/>
<br/>
<form action="login" method="post">
    <table align="center" cellspacing="10px">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" size="15px"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="userPassword" size="15px"/>
            </td>
        </tr>
        <tr id="sub">
            <td colspan="2" align="center">
                <a href="register.jsp"><input type="button" value="注册"/></a>
                <input type="submit" value="登录"/>
                <input type="reset" value="取消"/>
            </td>
        </tr>

    </table>
</form>
</body>
</html>
