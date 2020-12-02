<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01/12/2020
  Time: 9:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Customer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">
</head>
<body>

<div class="container-fluid">
    <h1 class="left-container">User Management</h1>
    <h2 class="right-container">
        <a href="/customer?action=create">Add New User</a>
        <a href="/customer?action=login">LOGIN</a>
    </h2>
</div>
<div align="center">
    <table id="example" class="container-fluid display" style="width:100%">
        <tr>
            <th>ID</th>
            <th>User Name</th>
            <th>Firstname</th>
            <th>Surname</th>
            <th>Birthday</th>
            <th>PhoneNumber</th>
            <th>Email</th>
            <th>Address</th>
            <th>TypeAccountId</th>
            <td>Actions</td>
        </tr>
        <c:forEach var="customer" items="${listCustomer}">
            <tr>
                <td>${customer.customerID}</td>
                <td>${customer.username}</td>
                <td>${customer.firstname}</td>
                <td>${customer.surname}</td>
                <td>${customer.birthDay}</td>
                <td>${customer.phoneNumber}</td>
                <td>${customer.address}</td>
                <td>${customer.email}</td>
                <td>${customer.typeAccountId}</td>
                <td>
                    <a class="btn btn-primary" type="submit" href="/customer?action=edit&customerId=${customer.customerID}">Edit</a>
                    <a class="btn btn-danger" type="submit" href="/customer?action=delete&customerId=${customer.customerID}">Delete</a>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal${customer.customerID}">
                        Launch demo modal
                    </button>
                </td>
            </tr>
            <!-- Modal -->
            <div class="modal fade" id="exampleModal${customer.customerID}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                                ${customer.customerID}
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
</script>
</body>
</html>
