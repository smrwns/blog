<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>

    유저 등록폼
    <form:form action="/user/add" method="post" commandName="user">
    <!-- Name of the model attribute under which the form object is exposed. Defaults to 'command'. -->
        <form:input path="name"/><form:errors path="name"/>
        <form:input path="type"/>
        <input type="submit"/>
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