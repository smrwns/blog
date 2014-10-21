<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title" defaultValue="smrwns"/></title>
    <tiles:insertAttribute name="head-js"/>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>

<body>
<div class="navi-position">
    <tiles:insertAttribute name="navibar" defaultValue="navibar"/>
</div>
<div class="#">
    <div class="best-contents"></div><!-- sliding : city/village/home(cooking) -->
    <div class="member"></div><!-- tab : memberInfo/shortCut/link/cashInfo -->
</div>
<div class="#"></div>
<div class="#"></div>
<div class="#"></div>

</body>

</html>