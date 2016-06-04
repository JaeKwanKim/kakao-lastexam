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

function changePageNum(pageNum) {
	console.log(pageNum);
	$.ajax({
		url: "pageNum",
		type: "GET",
		data: {"pageNum": pageNum},
		// beforeSend: function(xhr) {
		// 	xhr.setRequestHeader("Accept", "application/json");
		// 	xhr.setRequestHeader("Content-Type", "application/json");
		// },
		success: function () {
			location.href = '/?page='+pageNum;
			console.log("success!!!");
		},
		error: function () {
			console.log("error.........")
		}
	});
}
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

var imgTarget = $('.preview-image .upload-hidden');

imgTarget.on('change', function(){
	var parent = $(this).parent();
	parent.children('.upload-display').remove();

	if(window.FileReader){
		//image 파일만
		if (!$(this)[0].files[0].type.match(/image\//)) return;

		var reader = new FileReader();
		reader.onload = function(e){
			var src = e.target.result;
			parent.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img src="'+src+'" class="upload-thumb"></div></div>');
		}
		reader.readAsDataURL($(this)[0].files[0]);
	}

	else {
		$(this)[0].select();
		$(this)[0].blur();
		var imgSrc = document.selection.createRange().text;
		parent.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img class="upload-thumb"></div></div>');

		var img = $(this).siblings('.upload-display').find('img');
		img[0].style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\""+imgSrc+"\")";
	}
});
