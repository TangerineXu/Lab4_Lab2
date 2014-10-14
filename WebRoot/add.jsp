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
     
    <title>My JSP 'add.jsp' starting page</title>
     
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
   <s:form action="Lab2!add.action">
    <s:textfield name="ISBN" label="ISBN"></s:textfield>
    <s:textfield name="Title" label="Title"></s:textfield>
    <s:textfield name="AuthorID" label="AuthorID"></s:textfield>
    <s:textfield name="Publisher" label="Publisher"></s:textfield>
    <s:textfield name="PublishDate" label="PublishDate"></s:textfield>
    <s:textfield name="Name" label="Name"></s:textfield>
    <s:textfield name="Price" label="Price"></s:textfield>
    <s:textfield name="Age" label="Age"></s:textfield>
    <s:textfield name="Country" label="Country"></s:textfield>
    <s:submit></s:submit>
    </s:form>
<s:a href="Lab2!select.action">select</s:a>
  </body>
</html>