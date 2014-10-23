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
<div class="header">
    <div class="menu-top">menu-top</div>
    <div class="menu-bar"><tiles:insertAttribute name="navibar" defaultValue="navibar"/></div>
</div>
<div class="body">
    <div class="wrap">
        <tiles:insertAttribute name="content-best" defaultValue="content-best"/>
        <div class="box-user-main"><div class="item-user-main">user</div></div><!-- tab : memberInfo/shortCut/link/cashInfo -->
    </div>
    <div class="wrap">
        <div class="box-basic"><div class="content-basic">best-kitchen</div></div>
        <div class="box-basic"><div class="content-basic">best-home</div></div>
        <div class="box-basic"><div class="content-basic">best-village</div></div>
        <div class="box-basic"><div class="content-basic">best-city</div></div>
        <div class="box-basic"><div class="content-basic">guerilla-event</div></div>
        <div class="box-basic"><div class="content-basic">etc</div></div>
    </div>
<div class=footer>
</div>
</div>
<div class="footer">
</div>
</body>

</html>