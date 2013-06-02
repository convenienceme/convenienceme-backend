<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Convenience.me</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.all.css" />" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1><a href="<c:url value="/" />">Convenience.me API Listing</a></h1>
 
<div id="tabs">
	<ul>
		<li><a href="<c:url value="/form" />" title="Log On">Log On</a></li>
		<li><a href="<c:url value="/dashboard?userid=jay" />"> Dashboard</a></li>
		 
    </ul>
 </div>
 
</body>
</html>