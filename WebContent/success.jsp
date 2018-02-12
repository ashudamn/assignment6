<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Northwind Accessing Successfully</title>
</head>
<body>
<table border="1">
 <s:iterator value="records">
 <tr>
 <s:iterator>
 <td><s:property/></td>
 </s:iterator>
 </tr>
 </s:iterator>
</table>
<a href="index.jsp">Back</a>
</body>
</html>