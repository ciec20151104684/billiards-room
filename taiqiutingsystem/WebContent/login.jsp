<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  
    <form method="post" action="AdLoginServlet"  id="form">
			<h2>天翔台球厅登陆入口</h2>
			<div style="margin:5px 0px;">
				<input type="text" name="adUsername" id="adUsername" placeholder="请输入账号..."/>
			</div>
			<div style="margin:5px 0px;">
				<input type="password" name="adPassword" id="adPassword" placeholder="请输入密码..."/>
			</div>
			
			<input type="button" onclick="submit" value="登录">
		</form>
	</div>
</div>
    
     
</body>
</html>