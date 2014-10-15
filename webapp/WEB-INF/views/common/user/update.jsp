<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    정보 수정 <br />
    <form:form action="/user/${userInfo.getId()}/update" method="put" commandName="userInfo">
        ID : <form:input path="id" /><form:errors path="id"/><br />
        PW : <form:input path="passwd"/><form:errors path="passwd"/><br />
        NAME : <form:input path="name"/><form:errors path="name"/><br />
        NICK : <form:input path="nick"/><form:errors path="nick"/><br />
        GROUP : <form:input path="group"/><br />
        EMAIL : <form:input path="email"/><form:errors path="email"/><br />
        <input type="submit" value="수정"/>
    </form:form>
</body>
</html>