<%--
  Created by IntelliJ IDEA.
  User: 黄桂道
  Date: 2017-1-12
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>config</title>
</head>
<body>
<table border="1" style="width: 400px;margin: auto;" cellpadding="0" cellspacing="0">
    <tr>
        <td colspan="2" style="text-align: center">查看配置信息</td>
    </tr>
    <tr>
        <td>服务器IP</td>
        <td><%=config.getInitParameter("hostip")%>
        </td>
    </tr>
    <tr>
        <td>端口</td>
        <td><%=config.getInitParameter("port")%>
        </td>
    </tr>
    <tr>
        <td>数据库IP</td>
        <td><%=config.getInitParameter("mysqlip")%>
        </td>
    </tr>
    <tr>
        <td>数据库名</td>
        <td><%=config.getInitParameter("dbname")%>
        </td>
    </tr>
    <tr>
        <td>数据库用户名</td>
        <td><%=config.getInitParameter("dbuname")%>
        </td>
    </tr>
    <tr>
        <td>数据库密码</td>
        <td><%=config.getInitParameter("dbupass")%>
        </td>
    </tr>
    <tr>
        <td>服务器信息</td>
        <td><%=config.getServletContext().getServerInfo()%>
        </td>
    </tr>
</table>
</body>
</html>
