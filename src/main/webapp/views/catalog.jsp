<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Online Library</title>
        <link href="<c:url value="/resources/css/categories.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/table-style.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/topMenu.css" />" rel="stylesheet">
    </head>
    <body>
        <%@ include file="topMenu.jsp"%>
        <div class="main">
            <div class="category">
                <c:forEach var="category" items="${sessionScope.categories}">
                     <a href="${pageContext.request.contextPath}/catalog?id=${category.id}"> ${category.categoryName} </a>
                </c:forEach>
            </div>
            <table class="order-table">
                <tr>
                    <th>Image</th>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Author</th>
                    <th>Year</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Available</th>
                </tr>

                <c:forEach var="book" items="${requestScope.books}">
                    <tr>
                        <td><img src="${book.image}" alt="${book.name}"></td>
                        <td>${book.id}</td>
                        <td>${book.name}</td>
                        <td>${book.author}</td>
                        <td>${book.year}</td>
                        <td>${book.price} $</td>
                        <td>${book.description}</td>
                        <td>${book.available ? "Yes" : "No"}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
