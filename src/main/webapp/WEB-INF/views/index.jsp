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
    <ul class="nav nav-tabs">
    <li><a href="javascript:loginOpen();">로그인 </a></li>
    <li><a href="javascript:writeOpen();" > 글쓰기</a></li>
</ul>
    <div id="header">
    <textarea name="comment_main" rows="1" readonly class="input-lg">댓글시스템(비로그인)</textarea>
</div>
    <hr>
    <div class="rowmapper">
        <div>
            <table class="table">
                <tbody>
                    <tr class="comment_table">
                        <td class="image"><img src="assets/img/IMG_0742.JPG" width="50px" height="50px"></td>
                        <td class="name">
                            <label>허윤호 </label>
                        </td>
                        <td class="comment">ㅁ미ㅏㅓㅇㄹㅣㅓㅓㅁㅣㅏㄴㅓ </td>
                        <td id="recommend">
                            <button class="btn btn-default" type="button">추천 </button>
                        </td>
                        <td id="opposite">
                            <button class="btn btn-default" type="button">반대 </button>
                        </td>
                        <td class="delete">
                            <button class="btn btn-default" type="button">삭제 </button>
                        </td>
                        <td class="time-check">time </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="rowmapper">
    <div>
        <table class="table">
            <tbody>
                <tr class="comment_table">
                    <td class="image"><img src="assets/img/IMG_0742.JPG" width="50px" height="50px" /></td>
                    <td class="name">
                        <label>허윤호 </label>
                    </td>
                    <td class="comment">ㅁ미ㅏㅓㅇㄹㅣㅓㅓㅁㅣㅏㄴㅓ </td>
                    <td id="recommend">
                        <button class="btn btn-default" type="button">추천 </button>
                    </td>
                    <td id="opposite">
                        <button class="btn btn-default" type="button">반대 </button>
                    </td>
                    <td class="delete">
                        <button class="btn btn-default" type="button">삭제 </button>
                    </td>
                    <td class="time-check">time </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/app.js"></script>
</body>

</html>