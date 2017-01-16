<%@ page import="bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Message" %><%--
  Created by IntelliJ IDEA.
  User: 黄桂道
  Date: 2017-1-14
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>小陈留言本</title>
    <style>
        table tr td span{
            font-weight: bold;
            color: coral;
            font-size: 20px;
        }
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
        #mess{
            display: inline-block;
            width: 400px;
            height: 200px;
            border: 1px solid coral;
            font-size: 15px;
        }
    </style>
    <script>
        function load() {
            var re = getQueryString("result");
            if(re!=null){
                alert("留言失败，请重新留言！")
            }
        }

        function getQueryString(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]); return null;
        }
    </script>
</head>
<body>
<br/>
<h1 align="center">欢迎来到留言板</h1>
<div></div>
<hr style="width: 60%;margin: auto;" color="coral"/>
<br/>
<form action="messageServlet" method="post">
    <table align="center">
        <tr width="1px" height="10px"></tr>
        <!-- 留言显示 -->
        <%
            List<Message> list = (List<Message>) session.getAttribute("messageList");
            for (Message message : list) {
                %>
        <tr>
            <td style="color: coral"><%=message.getUser().getUserName()%>&nbsp;<%=message.getMessageTime()%></td>
        </tr>
        <tr>
            <td><%=message.getMessageContent()%></td>
        </tr>
        <%
            }
        %>
        <tr width="1px" height="10px"></tr>
        <!-- 留言添加 -->
        <tr>
            <td>欢迎您：&nbsp;<span>${sessionScope.user.userName}</span>&nbsp;请留言！</td>
        </tr>
        <tr>
            <td>
                <textarea name="messageContent" id="mess"></textarea>
            </td>
        </tr>
        <tr id="sub">
            <td colspan="2" align="center">
                <input type="submit" value="留言"/>
                <input type="reset" value="取消"/>
                <a href="logout"><input type="button" value="退出"/></a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
