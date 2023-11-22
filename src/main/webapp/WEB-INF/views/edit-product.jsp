
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
    <h1>Edit</h1>
    <form action="/exercise14/edit" method="post" enctype="multipart/form-data">

        <div class="mb-3">
            <label for="id" class="form-label">Id </label>
            <input type="text" class="form-control" id="id" name="id" readonly value="${product.id}">
        </div>

        <div class="mb-3">
            <label for="name" class="form-label">Name </label>
            <input type="text" class="form-control" id="name" name="name" value="${product.name}">
        </div>

        <div class="mb-3">
            <label for="file" class="form-label">Image </label>
            <div class="d-flex flex-column">
                <div class=" d-flex gap-3">
                    <p >Image </p>
                    <img src="${product.imageUrl}" class="w-25">
                </div>
                <input type="hidden" name="imageUrl" value="${product.imageUrl}">
            </div>
            <input type="file" class="form-control mt-3" id="file" name="file">
        </div>

        <div class="mb-3">
            <label for="price" class="form-label">Price: </label>
            <input type="text" class="form-control" id="price" name="price" value="${product.price}">
        </div>

        <div class="mb-3">
            <label for="desc" class="form-label">Desc: </label>
            <textarea class="form-control" id="desc" name="desc">${product.desc}</textarea>
        </div>

        <div class="mb-3">
            <label for="stock" class="form-label">Quantity: </label>
            <input type="text" class="form-control" id="stock" name="stock" value="${product.stock}">
        </div>

        <div class="mb-3">
            <label for="status" class="form-label">Desc: </label>
            <select  id="status" name="status">
                <option value="true" ${product.status ? "selected" : ""} >True</option>
                <option value="false" ${!product.status ? "selected" : ""} >False</option>
            </select>
        </div>

        <input class="btn btn-primary" type="submit" value="EDIT">
    </form>
</div>



<jsp:include page="/WEB-INF/assests/foot.jsp"></jsp:include>

</body>
</html>
