console.log("app.js");

function writeOpen(){
	var popUrl = "popup";	//팝업창에 출력될 페이지 URL
	var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
	window.open(popUrl,"",popOption);
}

function loginOpen(){
	var popUrl = "login";
	var popOption = "width=300, height=280, resizable=no, scrollbars=no, status=no;";
	window.open(popUrl,"",popOption);
}

$(".comment-delete-class").on("click", function() {
	location.href='/';
});

$(window).load(function(event) {
	var userComparable = $("#userComparable").val();
	console.log(userComparable);
	// console.log(event);
	if(userComparable != "") {
		$("#nav-login-display").css("display", " ");
		$("#nav-login-profile-change").css("display", " ");
		$("#nav-login-logout").css("display", " ");
		$("#nav-login").css("display", "none");
	} else {
		$("#nav-login-display").css("display", "none");
		$("#nav-login-profile-change").css("display", "none");
		$("#nav-login-logout").css("display", "none");
		$("#nav-login").css("display", " ");
	}
});
