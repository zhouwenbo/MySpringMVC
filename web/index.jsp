<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-3-22
  Time: 下午3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>学生操作</title>
  </head>
  <body>
    <div style="margin: 0px auto;">
    <table>
        <tr>
            <td><a href="user/find.htm?user_id=1">显示学生</a></td>
            <td><a href=":;">mysql简单查询</a></td>
        </tr>
        <tr>
            <td><a href="hero/find/1.htm">显示英雄</a></td>
            <td><a href=":;">登录验证拦截器</a></td>
        </tr>
        <tr>
            <td><a href="phone/find/5.htm">查询phone</a></td>
            <td><a href=":;">mongodb简单查询</a></td>
        </tr>
        <tr>
            <td><a href="phone/add.htm">添加phone</a></td>
            <td><a href=":;">mongodb添加操作</a></td>
        </tr>
        <tr>
            <td><a href="phone/list.htm">查询列表phone</a></td>
            <td><a href=":;">带条件查询</a></td>
        </tr>
    </table>
    </div>
  </body>
</html>
