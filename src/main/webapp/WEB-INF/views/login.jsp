<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LastProject</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/css/Pretty-Registration-Form.css">
</head>

<body>
    <form id="login-form" class="bootstrap-form-with-validation">
    <h2 class="text-center">로그인 </h2>
    <div class="form-group">
        <input type="text" placeholder="ID" autofocus required class="form-control" id="login-name-input" />
    </div>
    <div class="form-group">
        <input type="password" placeholder="Password" required class="form-control" id="password-input" />
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" /> Remember me</label>
    </div>
    <div id="login-div-button">
        <button class="btn btn-default btn-sm login-button" type="submit">로그인 </button>
        <button class="btn btn-default btn-sm loin-button" type="button" onclick="opener.document.location.href='register.jsp';self.close();">회원가입 </button>
    </div>
</form>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/app.js"></script>
</body>

</html>