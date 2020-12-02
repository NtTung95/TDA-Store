    <%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01/12/2020
  Time: 9:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="bg-dark">
<form method="post" action="/login">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-5">
                <div class="card shadow-lg border-0 rounded-lg mt-5">
                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
                    <div class="card-body">
                        <form>
                            <div class="form-group">
                                <label class="small mb-1">Username</label>
                                <input class="form-control py-4" type="text" name="username"
                                       placeholder="Enter Username"/>
                            </div>
                            <div class="form-group">
                                <label class="small mb-1">Password</label>
                                <input class="form-control py-4" type="password" name="password"
                                       placeholder="Enter password"/>
                                <p class="invalid-feedback" name="error-login" id="error-login">

                                </p>
                            </div>
                            <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                <button class="btn btn-primary" type="submit">Login</button>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer text-center">
                        <div class="small"><a href="register.jsp">Need an account? Sign up!</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
