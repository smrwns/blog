<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>

    유저 가입 양식<br />
    *표는 필수 기입 항목입니다. <br />
    <form:form action="/user/add" method="post" commandName="user">
        ID(*) : <form:input path="id"/><form:errors path="id"/><br />
        PW(*) : <form:input path="passwd"/><form:errors path="passwd"/><br />
        NAME(*) : <form:input path="name"/><form:errors path="name"/><br />
        NICK(*) : <form:input path="nick"/><form:errors path="nick"/><br />
        GROUP : <form:input path="group"/><br />
        EMAIL(*) : <form:input path="email"/><form:errors path="email"/><br />
        <input type="submit" value="가입"/>
    </form:form>


<!--     <script>
    location.href="url";
    </script> -->
    
<%--     <form action="/user/add" method="post">
        <input type="text" name="name" value="">
        <input type="submit"/>
    </form> --%>
    
</body>
</html>