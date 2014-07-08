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
    <title>欢迎光临，我的首页</title>
  </head>
  <body>
    <div style="margin: 0px auto;">
    <table>
        <tr>
            <td><a href="user/find.htm?user_id=1">显示学生</a></td>
            <td>mysql简单查询</td>
        </tr>
        <tr>
            <td><a href="hero/find/1.htm">显示英雄</a></td>
            <td>登录验证拦截器</td>
        </tr>
        <tr>
            <td><a href="phone/find/5.htm">查询phone</a></td>
            <td>mongodb简单查询</td>
        </tr>
        <tr>
            <td><a href="phone/add.htm">添加phone</a></td>
            <td>mongodb添加操作</td>
        </tr>
        <tr>
            <td><a href="phone/query.htm">查询列表phone</a></td>
            <td>带条件查询</td>
        </tr>
    </table>
    </div>
    <div style="width: 100%;height: 100px"></div>
    <div style="width: 100%;height: 300px;">
        <table>
            <tr>
                <td><a href="admin/company/viewlist.htm">company list</a></td>
                <td>公司列表</td>
            </tr>

            <tr>
                <td><a href="admin/car/viewlist.htm">car list</a></td>
                <td>车辆列表</td>
            </tr>
        </table>
    </div>
  </body>
</html>
