<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
     
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  </head>
	<body>
	<center>
	<h2>图书列表</h2>
	<table border = "1">
	<tr bgcolor = "#33CCFF">
	<td align = "center">ISBN</td>
	<td align = "center">Title</td>
	<td align = "center">AuthorID</td>
	<td align = "center">Publisher</td>
	<td align = "center">PublishDate</td>
	<td align = "center">Price</td>
	<td align = "center">Name</td>
	<td align = "center">Age</td>
	<td align = "center">Country</td>
	</tr>
	<s:iterator value = "#list">
	<tr>
	<td align = "center"><s:property value = "ISBN"/></td>
	<td align = "center"><s:property value = "Title"/></td>
	<td align = "center"><s:property value = "AuthorID"/></td>
	<td align = "center"><s:property value = "Publisher"/></td>
	<td align = "center"><s:property value = "PublishDate"/></td>
	<td align = "center"><s:property value = "Price"/></td>
	<td align = "center"><s:property value = "Name"/></td>
	<td align = "center"><s:property value = "Age"/></td>
	<td align = "center"><s:property value = "Country"/></td>
    <td align = "center"><s:a href="Lab2!delete.action?ISBN=%{ISBN}">delete</s:a></td>
    <td align = "center"><s:a href="Lab2!update.action?ISBN=%{ISBN}">update</s:a></td>
	</tr>
	</s:iterator>
	<s:a href="Lab2!add.action">add</s:a>
	</table>
	</center>
	</body>
</html>