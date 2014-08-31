<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tweetter Connection</title>
</head>
<body>
    <form action="<c:url value="/connect/twitter"></c:url>/>" method="POST">
        <P>버튼을 클릭하면 트위터 계정과 연결하실 수 있습니다. <br/>
        (트위터로 접속되며 트위터 계정 연결 권한을 부여할 것인지 묻습니다.)</P>
        <p><button type="submit">Twitter Connection</button></p>
    </form>
</body>
</html>