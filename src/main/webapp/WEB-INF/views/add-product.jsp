
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
    <h1>Add</h1>
    <form action="/exercise14/add" method="post" enctype="multipart/form-data">

        <div class="mb-3">
            <label for="name" class="form-label">Name </label>
            <input type="text" class="form-control" id="name" name="name">
        </div>

        <div class="mb-3">
            <label for="file" class="form-label">Image </label>
            <input type="file" class="form-control" id="file" name="file">
        </div>

        <div class="mb-3">
            <label for="price" class="form-label">Price </label>
            <input type="text" class="form-control" id="price" name="price">
        </div>

        <div class="mb-3">
            <label for="desc" class="form-label">Desc </label>
            <textarea class="form-control" id="desc" name="desc"></textarea>
        </div>

        <div class="mb-3">
            <label for="stock" class="form-label">Quantity </label>
            <input type="text" class="form-control" id="stock" name="stock">
        </div>

        <input class="btn btn-primary" type="submit" value="ADD">
    </form>
</div>

<jsp:include page="/WEB-INF/assests/foot.jsp"></jsp:include>
</body>
</html>
