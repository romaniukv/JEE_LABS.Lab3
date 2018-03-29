<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Online Library</title>
        <link href="<c:url value="/resources/css/topMenu.css" />" rel="stylesheet">
    </head>
    <body>
        <%@ include file="topMenu.jsp"%>
        <div class="main">
            <form name="form" action="addBook" method="POST">
                <table>
                    <tr>
                        <td>Category:</td>
                        <td>
                            <select name="categoryId">
                                <c:forEach var="category" items="${sessionScope.categories}">
                                    <option value="${category.id}">${category.categoryName}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Name: </td>
                        <td>
                            <input id="name" name="name" type="text" required />
                        </td>
                    </tr>
                    <tr>
                        <td>Author: </td>
                        <td>
                            <input id="author" name="author" type="text" required />
                        </td>
                    </tr>
                    <tr>
                        <td>Year: </td>
                        <td>
                            <input id="year" name="year" type="number" required />
                        </td>
                    </tr>
                    <tr>
                        <td>Number of pages: </td>
                        <td>
                            <input id="numOfPages" name="numOfPages" type="number" required />
                        </td>
                    </tr>
                    <tr>
                        <td>Price: </td>
                        <td>
                            <input  name="price" type="number" step="any" required />
                        </td>
                    </tr>
                    <tr>
                        <td>Description: </td>
                        <td>
                            <input name="description" type="text" required />
                        </td>
                    </tr>
                    <tr>
                        <td>Is available?:</td>
                        <td>
                            <select name="availability">
                                <option value="true">Yes</option>
                                <option value="false">No</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Image: </td>
                        <td>
                            <input name="image" type="text" required>
                        </td>
                    </tr>
                </table>
                <input name="submit" type="submit" value="add">
            </form>
        </div>
    </body>
</html>
