<%--
  Created by IntelliJ IDEA.
  User: 黄桂道
  Date: 2017-2-2
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>联系信息</title>
</head>
<body>
<legend>登录信息-><b style="color: red">联系信息</b>->兴趣爱好</legend>
<form:form>
    <table border="0">
        <tr>
            <td>手机号码</td>
            <td>
                <form:input path="tel" cssClass="fromStyle"/>
                <form:errors path="tel" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>地址</td>
            <td>
                <form:password path="address" size="21"/>
            </td>
        </tr>
        <tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="_target0" value="上一步"/>
                <input type="submit" name="_target2" value="下一步"/>
                <input type="submit" name="_cancel" value="取消"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
