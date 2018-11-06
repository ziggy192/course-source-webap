<%@ page import="static javax.servlet.RequestDispatcher.ERROR_STATUS_CODE" %>
<%@ page import="static javax.servlet.RequestDispatcher.ERROR_EXCEPTION" %>
<%@ page import="static javax.servlet.RequestDispatcher.ERROR_EXCEPTION_TYPE" %>
<%@ page import="static javax.servlet.RequestDispatcher.*" %><%--
  Created by IntelliJ IDEA.
  User: ziggy192
  Date: 11/4/18
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Error Page</h1>
<h2>Status Code=<%= request.getAttribute(ERROR_STATUS_CODE)%></h2>
<h2>Exception=<%= request.getAttribute(ERROR_EXCEPTION)%></h2>
<h2>Exception Type=<%=request.getAttribute(ERROR_EXCEPTION_TYPE)%></h2>
<h2>Error message=<%=request.getAttribute(ERROR_MESSAGE)%></h2>
</body>
</html>
