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
    <title>Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="bg-dark">

<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-7">
            <div class="card shadow-lg border-0 rounded-lg mt-5">
                <div class="card-header">
                    <h3 class="text-center font-weight-light my-4">Create Account</h3>
                </div>
                <div class="card-body">
                    <form method="post">
                        <div class="form-row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1">Account</label>
                                    <input class="form-control py-4" type="text" name="userName" placeholder="Enter username" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1">Password</label>
                                    <input class="form-control py-4" type="password" name="password" placeholder="Enter password" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="small mb-1">Email</label>
                            <input class="form-control py-4" type="email" aria-describedby="emailHelp" name="email" placeholder="Enter email" />
                        </div>

                        <div class="form-row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1">First Name</label>
                                    <input class="form-control py-4" type="text" name="firstName" placeholder="Enter firstname" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1">Sur Name</label>
                                    <input class="form-control py-4" type="text" name="surName" placeholder="Enter surname" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="small mb-1">Address</label>
                            <input class="form-control py-4" type="text" name="address" placeholder="Enter address" />
                        </div>
                        <div class="form-row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1">Phone Number</label>
                                    <input class="form-control py-4" type="text" name="phoneNumber" placeholder="Enter phone number" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="small mb-1">Birthday</label>
                                    <input class="form-control py-4" type="date" name="birthDay" placeholder="Enter birthday yyyy-mm-dd" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group mt-4 mb-0"><button class="btn btn-primary btn-block" type="submit">Create Account</button></div>
                    </form>
                </div>
                <div class="card-footer text-center">
                    <div class="small"><a href="login.jsp">Have an account? Go to login</a></div>
                </div>
            </div>
        </div>
    </div>
</div>



<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
