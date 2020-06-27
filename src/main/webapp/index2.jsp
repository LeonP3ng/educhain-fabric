<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
    <form action="/bootdemo/login" method="post">
        username:<input type="text" name="username"/>
        psw:<input type="password" name="password">


        登录类型:<input type="text" name="rating">

        <input type="submit" value="登录">
    </form>


</body>

</html>