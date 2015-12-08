<html>
<head>

</head>
<body>
  <%
	String userName = null;
	Cookie[] cookies = request.getCookies();
	if(cookies !=null){
		for(Cookie cookie : cookies){
    		if(cookie.getName().equals("username")) userName = cookie.getValue();
		}
	}
if(userName == null) response.sendRedirect("index.html");
%>
	<form action="/create-admin" method="post">
	
	Username: <input type = "text" name= "username" />
	Password: <input type="text"  name="password" /> 
	<input type="submit" value = "submit" />
	</form>


</body>

</html>