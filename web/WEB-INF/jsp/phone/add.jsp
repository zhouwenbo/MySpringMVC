<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-4-20
  Time: 下午2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/mvc/phone/save.htm" method="post">
    <table>
        <tr>
            <td>phone_id:</td>
            <td><input type="text" name="phone_id" placeholder="请输入id"/></td>
        </tr>
        <tr>
            <td>名称:</td>
            <td><input type="text" name="name" placeholder="请输入名字"/></td>
        </tr>
        <tr>
            <td>尺寸:</td>
            <td><input type="text" name="size" placeholder="请输入尺寸"/></td>
        </tr>
        <tr>
            <td>价格:</td>
            <td><input type="text" name="price" placeholder="请输入价格"/></td>
        </tr>

        <tr>
            <td>重量:</td>
            <td><input type="text" name="weight" placeholder="请输入重量"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="提交" placeholder="请输入重量"/></td>
        </tr>
    </table>
</form>


</body>
</html>
