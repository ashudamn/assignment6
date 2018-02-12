<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ap.struts.FormValidator" %>
 <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Northwind Using Struts2</title>
</head>
<body>
<font color="red"><s:property value="errorMessage"></s:property></font><br>
<s:form action="accessDB">
<s:textfield name="driver" label="Driver"></s:textfield>
<s:textfield name="url" label="Url"></s:textfield>
<s:textfield name="username" label="Username"></s:textfield>
<s:password name="password" label="Password"></s:password>
<s:textfield name="query" label="Query"></s:textfield>
<s:submit value="save"></s:submit>
</s:form>
</body>
</html>