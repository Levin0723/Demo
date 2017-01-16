<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
Created by IntelliJ IDEA.
  User: 黄桂道
  Date: 2017-1-12
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="test.jsp">
    用户名：<input type="text" name="username" title="username"/><br/>
    密码：<input type="password" name="password" title="password"/><br/>
    <input type="submit" value="登录"/>
</form>

<%
    Context initContext = new InitialContext();
    Context envContext = (Context) initContext.lookup("java:/comp/env");
    DataSource ds = (DataSource) envContext.lookup("MySQL - imooc@localhost");
    Connection conn = ds.getConnection();
    Statement smt = conn.createStatement();
    String sql = "SELECT * FROM imooc.goods_list;";
    ResultSet rs = smt.executeQuery(sql);
    String result = null;
    while (rs.next()){
        result = rs.getString("goods_name");
        %>
<h3><%=result%></h3><br/>
<%
    }
%>
</body>
</html>
