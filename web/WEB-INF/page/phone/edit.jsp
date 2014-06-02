<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-3-31
  Time: 下午10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form method="post" action="/mvc/phone/update.htm">
    <table>
        <tr>
            <td>Id</td>
            <td><input type="text" name="phone_id" value="${phone.phone_id}"/></td>
        </tr>
        <tr>
            <td>名称</td>
            <td><input type="text" name="name" value="${phone.name}"/></td>
        </tr>
        <tr>
            <td>尺寸</td>
            <td><input type="text" name="size" value="${phone.size}"/></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="price" value="${phone.price}"/></td>
        </tr>
        <tr>
            <td>重量</td>
            <td><input type="text" name="weight" value="${phone.weight}"/></td>
            <td><input type="text" name="_id" value="${phone._id}"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
    </form>
</body>
</html>
