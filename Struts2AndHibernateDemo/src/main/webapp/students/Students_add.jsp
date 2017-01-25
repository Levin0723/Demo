<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
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
        var sid = document.getElementById("sid").value;
        var sname = document.getElementById("sname").value;
        var control_date = document.getElementById("control_date").value;
        var address = document.getElementById("address").value;
        if (sid == '') {
            alert("学生编号不能为空！");
            return false;
        } else if (sname == '') {
            alert("学生姓名不能为空！");
            return false;
        } else if (control_date == '') {
            alert("学生生日不能为空！");
            return false;
        } else if (address == '') {
            alert("学生地址不能为空！");
            return false;
        } else {
            return true;
        }
    }
</script>
<body>

<div id="navi">
    <div id='naviDiv'>
        <span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;学生管理&nbsp;
        <span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>
        <a href="<%=path%>/students/Students_queryAllStudnets.action">&nbsp;学生列表&nbsp;</a>
        <span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;添加学生
    </div>
</div>
<div id="main" align="center">
    <!-- 从session中获取学生集合 -->
    <br/>
    <h2 align="center">修改学生资料</h2>
    <br>
    <hr style="width: 500px;margin: auto;border: 1px solid darkturquoise;"/>
    <br>

    <form name="addForm" action="<%=path%>/students/Students_addStudent.action" method="post" onsubmit="return chenk()">
        <table id="mytable">
            <tr>
                <td>学生编号：</td>
                <td><input type="text" name="sid" id="sid"/></td>
            </tr>
            <tr>
                <td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
                <td><input type="text" name="sname" id="sname"/></td>
            </tr>
            <tr>
                <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
                <td><input type="radio" name="gender" value="男" checked="checked"/>男<input type="radio" name="gender"
                                                                                           value="女"/>女
                </td>
            </tr>
            <tr>
                <td>出生日期：</td>
                <td><input name="birthday" type="text" id="control_date" size="20"
                           maxlength="10" onclick="new Calendar().show(this);" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <td>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
                <td><input type="text" name="address" id="address"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input id="button" type="submit" value="添加"></td>
            </tr>
        </table>
    </form>
    <hr style="width: 500px;margin: auto;border: 1px solid darkturquoise;"/>
</div>
</body>
</html>