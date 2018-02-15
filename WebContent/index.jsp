<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ap.struts.FormValidator" %>
 <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Northwind Using Struts2</title>
</head>
<script type="text/javascript">
function validateFields(){
	var driver=document.getElementByName('driver').value;
	var url=document.getElementByName('url').value;
	var username=document.getElementByName('username').value;
	var password=document.getElementByName('password').value;
	var query=document.getElementByName('query').value;
	if(driver==""||driver==null){
		alert("Driver name is required");
		return false;
	}
	if(url==""||url==null){
		alert("URL is required");
		return false;
	}
	if(username==""||username==null){
		alert("username is required");
		return false;
	}
	if(password==""||password==null){
		alert("password is required");
		return false;
	}
	if(password.length<8){
		alert("password length musy be greater than or equal to 8");
		return false;
	}
	if(query==""||query==null){
		alert("query cannot be null");
		return false;
	}
	return true;
}
</script>
<body>
<font color="red"><s:property value="errorMessage"></s:property></font><br>
<s:form action="accessDB">
<s:textfield name="driver" label="Driver" value="com.mysql.jdbc.Driver" ></s:textfield>
<s:textfield name="url" label="Url" value="jdbc:mysql://localhost:3306/northwind"></s:textfield>
<s:textfield name="username" label="Username" value="root"></s:textfield>
<s:password name="password" label="Password" ></s:password>
<s:textfield name="query" label="Query"></s:textfield>
<s:submit value="submit"></s:submit>
</s:form>
</body>
</html>