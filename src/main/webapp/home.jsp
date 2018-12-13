<%@ page import="com.esliceu.dwes.xavi.model.User" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: xavi
  Date: 4/12/18
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags/myCustomTags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>



<html>
<head>
    <title>Home</title>

    <link rel="stylesheet" type="text/css" href="css/card.css">

    <script>


        function processUser(item,action){
            var form = item.parentNode.parentNode.parentNode.parentNode.parentNode;
            form.action = action;
            form.submit();
        }
    </script>

</head>
<body>

    <% if (request.getAttribute("error") != null) { %>
    <h1><%=request.getAttribute("error")%></h1>
    <% } %>

    <div class="row">

        <c:forEach items="${requestScope.users}" var="user">
            <form action="/edit" method="post" id="form" >

                <my:card name="${user.name}"
                         familyName ="${user.familyName}"
                         email="${user.email}"
                         photo="${user.photo}"/>
            </form>
        </c:forEach>




    </div>


</body>
</html>
