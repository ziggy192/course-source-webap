<%--
  Created by IntelliJ IDEA.
  User: ziggy192
  Date: 11/2/18
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<html>
<head>
    <title>Course Source</title>
</head>
<body>
    <h1>Course Source</h1>
    <c:out value="${requestScope['msg']}"/>

    <c:url var="createdURL" scope="page" value="home.jsp">
        <c:param name="name" value="Nghia"/>
        <c:param name="category" value="Dom"/>
    </c:url>
    <a href="${createdURL}" >
    </a>
    <jsp:text>in text: ${requestScope.msg}</jsp:text>
    out text: ${requestScope.msg}

</body>
</html>
