<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

    <%
          Object message = request.getAttribute("message");
          if(message!=null && !"".equals(message)){
      
     %>
          <script type="text/javascript">
               alert("<%=request.getAttribute("message")%>");
          </script>
     <%} %>
    <form method="post" action=  id="form">
			<h2>天翔台球厅登陆入口</h2>
			<div style="margin:5px 0px;">
				<input type="text" name="adUsername" id="adUsername" placeholder="请输入账号..."/>
			</div>
			<div style="margin:5px 0px;">
				<input type="password" name="adPassword" id="adPassword" placeholder="请输入密码..."/>
			</div>
			
			<input type="button" onclick="check()" value="登录">
		</form>
	</div>
</div>
     <script type="text/javascript">
         function check() {
             var name = document.getElementById("adUsername").value;
             var pwd = document.getElementById("adPassword").value;
             
             //非空
             if(name.value == ''||name.value ==null) {
                 alert('账号为空');
                 name.focus();
                 return false;
             }
             if(pwd.value == ''||pwd.value ==null) {
                 alert('密码为空');
                 name.focus();
                 return false;
             }
             document.getElementById("form").submit();
         }
     </script>
</body>
</html>