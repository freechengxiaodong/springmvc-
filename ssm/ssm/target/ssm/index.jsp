<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/index.css" type="text/css">
</head>
<body>

<a href="account/findAll">测试查询</a>

<h1>测试保存</h1>
<form action="account/save" method="post">
    姓名：<input type="text" name="name" /><br/>
    金额：<input type="text" name="money" /><br/>
    <input type="submit" value="保存">
</form>

<a href="account/moneyUpUp">都加十块钱</a>
</body>
</html>