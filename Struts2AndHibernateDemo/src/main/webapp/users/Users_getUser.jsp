<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<script type="text/javascript" src="../js/Calendar3.js"></script>
<style type="text/css">
    * {
        background: none repeat scroll 0 0 transparent;
        margin: 0;
        padding: 0;
        font-family: 微软雅黑, serif;
    }

    #navi {
        width: 100%;
        position: relative;
        word-wrap: break-word;
        border-bottom: 1px solid #065FB9;
        margin: 0;
        padding: 0;
        height: 40px;
        line-height: 40px;
        vertical-align: middle;
        background-image: -moz-linear-gradient(top, #EBEBEB, #BFBFBF);
        background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB), color-stop(1,
        #BFBFBF));
    }

    #naviDiv {
        font-size: 14px;
        color: #333;
        padding-left: 10px;
    }

    #mytable {
        font-size: 25px;
    }

    #mytable input {
        font-size: 20px;
        margin-left: 20px;
    }

    #mytable #button {
        width: 100px;
        height: 40px;
        margin: 20px 0px;
        border: 1px solid blue;
        background: aqua;
        border-radius: 10px;
    }

    #mytable #button:hover {
        background: blue;
        color: white;
    }
</style>
<script>
    function chenk() {
        var username = document.getElementById("username").value;
        var ps = document.getElementById("ps").value;
        var rps = document.getElementById("rps").value;
        if (username == '') {
            alert("用户名不能为空！");
            return false;
        } else if (ps == '') {
            alert("密码不能为空！");
            return false;
        } else if (rps == '') {
            alert("重复密码不能为空！");
            return false;
        } else if (ps != rps) {
            alert("再次输入的密码不一致！");
            return false;
        } else {
            return true;
        }
    }
</script>
<body>
<div id="navi">
    <div id='naviDiv'>
        <span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;用户管理&nbsp;
        <span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>
        <a href="<%=path%>/users/Users_queryAllUsers.action">&nbsp;用户列表&nbsp;</a>
        <span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;修改用户
    </div>
</div>
<div align="center">
    <!-- 从session中获取学生集合 -->
    <br/>
    <h2 align="center">修改编号&lt;<s:property value="#session.get_user.uid"/>&gt;用户资料</h2>
    <br>
    <hr style="width: 500px;margin: auto;border: 1px solid darkturquoise;"/>
    <br>

    <form action="<%=path%>/users/Users_update.action" method="post" onsubmit="return chenk()">
        <table id="mytable" cellpadding="0" cellspacing="0">
            <tr>
                <td>用&nbsp;户&nbsp;名：</td>
                <td><input type="text" name="username" id="username" value='<s:property value="#session.get_user.username"/>'/></td>
            </tr>
            <tr>
                <td>原&nbsp;密&nbsp;码：</td>
                <td><input type="text" name="password" readonly="readonly" value='<s:property value="#session.get_user.password"/>'/></td>
            </tr>
            <tr>
                <td>新&nbsp;密&nbsp;码：</td>
                <td><input type="password" name="password" id="ps"/></td>
            </tr>
            <tr>
                <td>重复密码：</td>
                <td><input type="password" name="re_password" id="rps"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input id="button" type="submit" value="修改"></td>
            </tr>
        </table>
    </form>
    <hr style="width: 500px;margin: auto;border: 1px solid darkturquoise;"/>
</div>
</body>
</html>