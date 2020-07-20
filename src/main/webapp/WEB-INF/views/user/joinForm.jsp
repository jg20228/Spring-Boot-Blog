<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="#" method="POST" class="was-validated">

		<div class="form-group">
			<label for="username">Username:</label>
			<button type="button" class="btn btn-warning float-right" onclick="usernameCheck()">중복확인</button>
			<input type="text" class="form-control" id="username" placeholder="Enter username" name="username" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<div class="form-group">
			<label for="pwd">Password:</label> <input type="password" class="form-control" id="password"
				placeholder="Enter password" name="password" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<div class="form-group">
			<label for="email">Email:</label> <input type="email" class="form-control" id="email" placeholder="Enter Email"
				name="email" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<button id="btn-save" type="button" class="btn btn-primary">회원가입완료</button>
	</form>
</div>
<!-- static은 /로 바로 찾아간다. -->
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>