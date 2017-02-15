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
    <title>兴趣爱好</title>
</head>
<body>
<legend>登录信息->联系信息-><b style="color: red">兴趣爱好</b></legend>
<form:form>
    <form:checkbox path="favor" value="看书">看书</form:checkbox>
    <form:checkbox path="favor" value="看电视">看电视</form:checkbox>
    <form:checkbox path="favor" value="上网">上网</form:checkbox>
    <form:checkbox path="favor" value="聊天">聊天</form:checkbox>
    <form:checkbox path="favor" value="看电影">看电影</form:checkbox>
    <form:checkbox path="favor" value="画画">画画</form:checkbox>
    <form:checkbox path="favor" value="逛街">逛街</form:checkbox>
    <input type="submit" name="_target0" value="上一步"/>
    <input type="submit" name="_target2" value="下一步"/>
    <input type="submit" name="_cancel" value="取消"/>

</form:form>
</body>
</html>
