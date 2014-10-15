<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Session Attributes</title>
    <link rel="stylesheet" type="text/css" href="/css/test.css">
</head>
<body>
    <div class="container">
        <h1>Description</h1>
        <p>
        This application demonstrates how to use a Redis instance to back you session.<br />
        Notice that there is no JSESSIONID cookie.<br />
        We are also able to customize the way of identifying what the requested session id is.
        </p>
        
        <h1>Try it</h1>
        <form class="form-inline" role="form" action="<c:url value="/session/add"/>" method="post">
            <label for="attributeValue">Attribute Name : </label>
            <input id="attributeName" type="text" name="attributeName"/>
            <label for="attributeValue">Attribute Value : </label>
            <input id="attributeValue" tyep="text" name="attributeValue"/>
            <input type="submit" value="Set Attribute"/>
        </form>
    
    <hr />
    
    <table class="table-striped">
        <thead>
            <tr><th>Attribute Name</th><th>Attribute Value</th></tr>
        </thead>
        <tbody>
        <c:forEach items="${sessionScope}" var="attr">
            <tr>
                <td><c:out value="${attr.key}"/></td>
                <td><c:out value="${attr.value}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</body>
</html>