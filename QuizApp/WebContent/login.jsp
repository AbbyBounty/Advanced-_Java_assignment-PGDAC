<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%--   Display cookie msg if login fails --%>
    <%
	    Cookie [] allcookies = request.getCookies();
		if(allcookies != null)
		{
			for(Cookie c: allcookies)
			{
				if(c.getName().equals("loginerror"))
				{
					out.println(c.getValue());
				}
			}
		}
    %>

    <form action="login" method="post">
		Enter uid : <input type="text" name="uid" /> <br/>
		Enter pwd : <input type="password" name="pwd" /> <br/>
		<input type="submit" value="LOGIN" />
	</form>
</body>
</html>