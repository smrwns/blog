<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AngularJs Test Page 1</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.0-rc.4/angular.min.js"></script>
</head>
<body>
    firstName : <input ng-model="firstName" type="text" /><br />
    lastName : <input ng-model="lastName" type="text" /><br />
    Hello {{lastName}}, {{firstName}}!
</body>
</html>