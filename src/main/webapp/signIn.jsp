<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<html>
    <head>
        <title>Online Library</title>
    </head>
    <body>
        <%@ include file="views/topMenu.jsp"%>
        <form method="POST" action="${pageContext.request.contextPath}/signIn">
            <table border="0">
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username"/> </td>
                </tr>

                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"/> </td>
                </tr>

                <tr>
                    <td colspan ="2">
                        <input type="submit" value= "Submit" />
                    </td>
                </tr>
                <tr>${requestScope.errorMessage}</tr>

            </table>
        </form>
    </body>
</html>
