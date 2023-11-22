<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>14</title>
    <jsp:include page="/WEB-INF/assests/head.jsp"></jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/assests/navbar.jsp"></jsp:include>
<div class="container-fluid">
    <h1>List</h1>
    <%--Form tìm kiếm--%>
    <form role="search" action="" class="d-flex flex-row justify-content-between gap-2">
        <input class="form-control" type="search" placeholder="Search" aria-label="Search" name="inputSearch"
               value="${inputSearch}">
        <div class="d-flex flex-row gap-2" style="min-width: 400px">
            <select class="form-select" aria-label="Default select example" name="sortByTitle" value="${sortByTitle}">
                <option value="name">Name</option>
                <option value="address">Address</option>
            </select>
            <select class="form-select" aria-label="Default select example" name="sortBy" value="${sortBy}">
                <option value="asc">ASC</option>
                <option value="desc">DESC</option>
            </select>
        </div>
        <input class="btn btn-outline-success" type="submit" value="SEARCH" name="action">
    </form>
    <br>
    <table class="table">
        <thead class="table-primary">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col" class="text-center">Image</th>
            <th scope="col">Price</th>
            <th scope="col" class="text-center">Description</th>
            <th scope="col">Stock</th>
            <th scope="col">Status</th>
            <th scope="col" class="text-center">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="prod" varStatus="loop">
            <tr>
                <th>${prod.getId()}</th>
                <td>${prod.getName()}</td>
                <td><img src="${prod.getImageUrl()}" width="80" height="80" alt="true"></td>
                <td>${prod.getPrice()}</td>
                <td>${prod.getDesc()}</td>
                <td>${prod.getStock()}</td>
                <td>${prod.isStatus() ? "True" : "False"}</td>
                <td>
                    <div class="d-flex justify-content-between">
                        <a class="btn btn-info" href="/exercise14/detail-product?id=${prod.getId()}">Detail</a>
                        <a class="btn btn-warning" href="/exercise14/form-edit-product?id=${prod.getId()}">Edit</a>
                        <a onclick="return confirm('Wanna delete')"
                           class="btn btn-danger" href="/exercise14/delete-product?id=${prod.getId()}">Delete</a>
                    </div>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%--Nút nhấn thêm mới sản phẩm--%>
    <a href="/exercise14/form-add-product">Add</a>
</div>


<jsp:include page="/WEB-INF/assests/foot.jsp"></jsp:include>
</body>
</html>
