<%--
  Created by IntelliJ IDEA.
  User: 黄桂道
  Date: 2017-1-11
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加人员信息</title>
    <script>
        function check(form) {
            with (form) {
                if (name.value == "") {
                    alert("姓名不能为空！");
                    return false;
                }
                if (age.value == ""||!/^[1-9][0-9]*$/.test(age.value)) {
                    alert("年龄不能为空或非纯数字");
                    return false;
                }
                if (address.value == "") {
                    alert("地址不能为空！");
                    return false;
                }
            }
        }
    </script>
</head>
<body>
<br/>
<br/>
<h1 style="text-align: center">添加人员信息</h1>
<br/>
<hr width="80%" style="margin: auto"/>
<br/>
<form action="addServlet" method="post" onsubmit="return check(this)">
    <table cellspacing="0" cellpadding="0" width="511px" border="0" style="margin: auto">
        <tbody>
        <tr>
            <td width="165px" rowspan="6">
                <div align="left">
                    <img src="image/03.jpg" border="0" width="127px" height="165px"/>
                </div>
            </td>
            <td height="22px" align="center" colspan="2">
                <h2>添加人员信息</h2>
            </td>
        </tr>
        <tr>
            <td height="22px" width="74px">姓名：</td>
            <td height="22px" width="266px"><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td height="22px" width="74px">年龄：</td>
            <td height="22px" width="266px"><input type="text" name="age"/></td>
        </tr>
        <tr>
            <td height="22px" width="74px">性别：</td>
            <td height="22px" width="266px">
                <input type="radio" name="sex" value="男" checked="checked"/>男
                <input type="radio" name="sex" value="女"/>女
            </td>
        </tr>
        <tr>
            <td height="22px" width="74px">地址：</td>
            <td height="22px" width="266px">
                <textarea rows="5" cols="30" name="address"></textarea>
            </td>
        </tr>
        <tr>
            <td height="22px" align="center" colspan="2" >
                <input style="margin-top: 10px" type="submit" value="添加"/></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
