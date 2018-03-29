<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Online Library</title>
    </head>
    <body>
        <%@ include file="views/topMenu.jsp"%>
        <table border="0">
            <tr>
                <td>Username: </td>
                <td>${sessionScope.user.username}</td>
            </tr>
            <tr>
                <td>First name: </td>
                <td>${sessionScope.user.firstName}</td>
            </tr>
            <tr>
                <td>Last name: </td>
                <td>${sessionScope.user.lastName}</td>
            </tr>
            <tr>
                <td>e-mail: </td>
                <td>${sessionScope.user.email}</td>
            </tr>
            <tr>
                <td>Phone number: </td>
                <td>${sessionScope.user.phoneNumber}</td>
            </tr>
        </table>
    </body>
</html>
