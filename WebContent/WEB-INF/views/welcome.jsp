<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	.wrapper{
		width: 400px;
		margin: 0 auto;
	}
	.imgcont {
	    display: inline-block;
	    height: 145px;
	    overflow: hidden;
	    padding-right: 0;
	    width: 132px;
	}
	.imgcont img {    
	    margin: 0;
	    overflow: hidden;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to my app </title>
</head>
<body>
<div class="wrapper">
<div class="imgcont"><img src="images/img/sprites.png" alt="login" /></div>
<h1>
	Welcome <%  User user = (User) request.getSession().getAttribute("User"); %>	
</h1>
<h2>
	<a href="logout">Logout</a>
</h2>
</div>
</body>
</html>