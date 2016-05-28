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
    <div class="comment-div">
        <label id="comment-register"><strong>댓글 등록</strong> </label>
    </div>
    <div class="commnet-div">
        <textarea id="comment-register-box"></textarea>
    </div>
    <div id="comment-register-button" class="commnet-div">
    <button class="btn btn-default comment-button" type="button">저 장 </button>
    <button class="btn btn-default comment-button" type="button" onclick="self.close();">취 소 </button>
</div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/app.js"></script>
</body>

</html>