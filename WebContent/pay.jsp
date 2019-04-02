<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>付款页</title>
</head>
<body>
	
	<%@ include file="fixedPage.jsp" %>
	<script>
			window.onload=function(){
				// 修改导航栏上的登入状态
				if (document.getElementById('ngbarEnterSuccess').innerHTML != "") {
					document.getElementById('ngbarEnterid').style.display = 'none';
					document.getElementById('specialid').style.display = 'none';
					document.getElementById('ngbarRegisterid').style.display = 'none';
					document.getElementById('ngbarEnterSuccess').style.display = 'block';
				}
				payCoursePageRequest();
			}
	</script>
	<div id="payCourseContainer">
		
	</div>

</body>
</html>