
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container py-5">
  <h1 class="text-center">Login</h1>

  <form class="row g-3" style="max-width: 30rem; margin: 0 auto" action="<%=request.getContextPath()%>/AuthController" method="post">
    <%-- username --%>
    <div class="col-12">
      <label for="username" class="form-label">Username: </label>
      <input type="text" class="form-control" name="username" id="username">
    </div>
    <%-- password --%>
    <div class="col-12">
      <label for="password" class="form-label">Password: </label>
      <input type="password" class="form-control" name="password" id="password">
    </div>
    <div class="col-12 text-center">
      <input type="submit" class="btn btn-primary" value="LOGIN" name="action">
    </div>
  </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
