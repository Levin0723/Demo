<%--
  Created by IntelliJ IDEA.
  User: 黄桂道
  Date: 2017-1-14
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册用户</title>
    <style>
        #sub {
            height: 50px;
        }

        #sub input {
            height: 30px;
            width: 60px;
            margin: auto 5px;
            background-color: darkorange;
            color: white;
            font-size: 15px;
            border: 1px solid coral;
        }

        #sub input:hover {
            background-color: chartreuse;
        }
    </style>
    <script>
        function register() {
            var re = getQueryString("result");
            if (re == 'true') {
                var yn = confirm("注册成功，请返回登录！")
                if (yn) {
                    setTimeout(function () {
                        location.href = 'index.jsp';
                    }, 1000)
                }
            }
            if (re == 'false') {
                alert("注册不成功，请重新注册!")
            }
        }

        function getQueryString(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]);
            return null;
        }
        function change1(obj) {
            if (obj.value == "") {
                alert("帐号不能为空！")
            }
        }
        function change2(obj) {
            if (obj.value == "") {
                alert("密码不能为空！")
            }
        }
        function change3(obj) {
            var psw = document.getElementById("psw").value;
            if (obj.value != psw) {
                alert("再次输入的密码不一致！")
            }
        }
    </script>
</head>
<body onload="register()">
<br/>
<h1 align="center">欢迎注册留言板</h1>
<hr style="width: 60%;margin: auto;" color="coral"/>
<br/>
<form action="register" method="post">
    <table align="center" cellspacing="10px">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" size="15px" onblur="change1(this)"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="userPassword" size="15px" onchange="change2(this)" id="psw"/>
            </td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td><input type="password" name="Password" size="15px" onchange="change3(this)"/>
            </td>
        </tr>
        <tr id="sub">
            <td colspan="2" align="center">
                <input type="submit" value="注册"/>
                <input type="reset" value="取消"/>
            </td>
        </tr>

    </table>
</form>
</body>
</html>
