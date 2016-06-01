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

function retrieveLike(seqNum) {
	event.preventDefault();
	var userComparable = $("#userComparable").val();
	if (userComparable == "") alert("After Login. Writing...");
	else {
		$.ajax({
			url: "comments/like",
			type: "GET",
			data: {"seqNum": seqNum},
			beforeSend: function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			success: function () {
				location.href = '/';
				console.log("success!!!");
			},
			error: function () {
				console.log("error.........")
			}
		});
	}
};

function retrieveUnlike(seqNum) {
	event.preventDefault();
	var userComparable = $("#userComparable").val();
	if (userComparable == "") {
		alert("After Login. Writing...");
	} else {
		$.ajax({
			url: "comments/unlike",
			type: "GET",
			data: {"seqNum": seqNum},
			beforeSend: function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			success: function () {
				location.href = '/';
				console.log("success!!!");
			},
			error: function () {
				console.log("error.........");
				// Handle  error
				// ...
			}
		});
	}

};
