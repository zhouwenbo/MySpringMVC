<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-4-9
  Time: 下午3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看英雄</title>
</head>
<body>
<table>
    <tr>
        <td>Id:</td>
        <td>${hero.hero_id}</td>
    </tr>
    <tr>
        <td>姓名:</td>
        <td>${hero.name}</td>
    </tr>
    <tr>
        <td>年龄:</td>
        <td>${hero.age}</td>
    </tr>
    <tr>
        <td>出处：</td>
        <td>${hero.from}</td>
    </tr>
    <tr>
        <td>绝学:</td>
        <td>${hero.skill}</td>
    </tr>
</table>
</body>
</html>
