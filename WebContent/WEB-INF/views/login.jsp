<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-theme.min.css" />

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<!-- www.paulund.co.uk/twitter-bootstrap-alert-boxes -->
<style type="text/css">
	.alert {
	padding: 8px 35px 8px 14px;
	margin-bottom: 18px;
	color: #c09853;
	text-shadow: 0 1px 0 rgba(255, 255, 255, 0.5);
	background-color: #fcf8e3;
	border: 1px solid #fbeed5;
	-webkit-border-radius: 4px;	
	-moz-border-radius: 4px;	
	border-radius: 4px;
	}
	.alert-danger,
	.alert-error {
	color: #b94a48;
	background-color: #f2dede;
	border-color: #eed3d7;
	text-align: center;
}
</style>
</head>
<body>
<div class="container">
	<div id="myModal" class="modal fade" tabindex="-1" role="dialog">
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>Modal header</h3>
	</div>
	<div class="modal-body">
		<p>My modal content here…</p>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal">Close</button>
	</div>
	</div>
</div>
</div><!--login modal-->
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <img src="../images/sprites.png" alt="login" width="200" height="200"/>
          <h1 class="text-center">Login <small>WWWTech2014</small></h1>
      </div>
      <c:if test="${not empty it.error}">
      <div class="alert alert-error">  
  			<strong>Incorrect username or password !</strong>  
	  </div>
	  </c:if>
      <div class="modal-body">
          <form id="loginForm" class="form col-md-12 center-block" action="login" method="POST">
            <div class="form-group">
              <input type="text" class="form-control input-lg" placeholder="Email" name="email">
            </div>
            <div class="form-group">
              <input type="password" class="form-control input-lg" placeholder="Password" name="password">
            </div>
            <div class="form-group">
              <input type="submit" class="btn btn-success btn-lg btn-block" value="Sign in">
              <span class="pull-right"><a href="register">Register</a></span>
            </div>
          </form>
      </div>
  </div>
  </div>
</div>
</div>
<script>
$(document).ready(function(){
	$("#loginForm").validate({
		rules : {
			email : {
				required : true,
				email : true
			},
			password : {
				required : true,
				minlength : 3,
				maxlength : 20
			}
		}
	});	
});
</script>
</body>
</html>