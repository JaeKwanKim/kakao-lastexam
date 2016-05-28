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
    <div class="row register-form">
    <div class="col-md-8 col-md-offset-2">
        <form class="form-horizontal custom-form">
            <h1>회원가입 </h1>
            <div class="form-group">
                <div class="col-sm-4 label-column">
                    <label class="control-label">ID </label>
                </div>
                <div class="col-sm-6 input-column">
                    <input type="text" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-4 label-column">
                    <label class="control-label">Password </label>
                </div>
                <div class="col-sm-6 input-column">
                    <input type="password" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-4 label-column">
                    <label class="control-label">이름 </label>
                </div>
                <div class="col-sm-6 input-column">
                    <input type="text" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-4 label-column">
                    <label class="control-label">설명 </label>
                </div>
                <div class="col-sm-6 input-column">
                    <input type="text" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-4 label-column">
                    <label class="control-label">프로필 이미지 </label>
                </div>
                <div class="col-sm-4 input-column" id="image-call"><img id="profile-image" />
                    <input type="file" id="image-search" />
                </div>
            </div>
            <div class="checkbox" align="center">
                <label>
                    <input type="checkbox" /> 본인 기억해놓기</label>
            </div>
            <button class="btn btn-default submit-button" type="submit">회원가입 </button>
            <button class="btn btn-default submit-button" type="button" onclick="location.href='index.jsp'">취소 </button>
        </form>
    </div>
</div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/app.js"></script>
</body>

</html>