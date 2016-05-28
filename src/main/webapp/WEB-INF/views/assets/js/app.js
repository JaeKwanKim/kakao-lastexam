function writeOpen(){
	var popUrl = "popup.jsp";	//팝업창에 출력될 페이지 URL
	var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
		window.open(popUrl,"",popOption);
	}

function loginOpen(){
	var popUrl = "login.jsp";	//팝업창에 출력될 페이지 URL
	var popOption = "width=300, height=280, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
		window.open(popUrl,"",popOption);
	}