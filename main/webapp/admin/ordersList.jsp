<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css"> -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

    <title>Product</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta charset="UTF-8">
    <style>
        .tableProduct{
            margin: auto;
        }
        #header{
            height: 3rem;
        }
        .div-addproduct{
            text-align: right;
            margin-bottom: 1rem;
            /*border: 1px solid red;*/
        }
        .row1{
            float: left;
        }
        .row2{
            float: left;
            text-align: center;
        }

        .imgPreview{
            max-width: 150px;
        }
        .imgPreviewTable{
            max-width: 100px
        }
        .imgPreviewTable:hover{
            transform: scale(3.5); /* (150% zoom - Note: if the zoom is too large, it will go outside of the viewport) */
        }
        .submmitButton{
            float: right;
        }
    </style>

</head>
<body>

<%--navbar--%>
<div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/homepage"><h3>LACOSTE</h3></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/homepage">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/products">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/customer">User Management</a>
                </li>

                <%
                    String nameResult = (String) session.getAttribute("nameLogin");
                    String url = "/login";
                    String menu1 = "Login";
                    String urlMenu1 = "/login";
                    String menu2 = "Register";
                    String urlMenu2 = "/register";
                    if (nameResult == null) {
                        nameResult = "Login";
                    } else {
                        url = "#";
                        menu1 = "profile";
                        urlMenu1 = "/inforcustomer";
                        menu2 = "logout";
                        urlMenu2 = "/logout";
                    }
                %>
                <li class="nav-item active">
                    <div class="dropdown">
                        <a class="nav-link dropbtn" href="<%=url%>" id="navbarDropdown" role="button" data-toggle="dropdown">
                            <%=nameResult%>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown" style="height: auto; width: auto">
                            <a class="dropdown-item" href="<%=urlMenu1%>"><%=menu1%>
                            </a>
                            <a class="dropdown-item" href="<%=urlMenu2%>"><%=menu2%>
                            </a>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</div>


<div class="container-fluid">


    <table id="tableProduct" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>orderId</th>
            <th>customerID</th>
            <th>dateOrdered</th>
            <th>status</th>
<%--            <th>Price</th>--%>
<%--            <th>IMG Product</th>--%>
            <th>Detail</th>
        </tr>
        </thead>
        <tbody>
<c:forEach items='${requestScope["orderList"]}'
           var="order">
        <tr>
            <td>${order.getOrderId()}</td>
            <td>${order.getCustomerId()}</td>
            <td>${order.getDateOrdered()}</td>
            <td>${order.getStatus()}</td>
<%--            <td>${product.getPrice()}</td>--%>
<%--            <td><img id="blah5" class="imgPreviewTable" src="${product.getImgMain()}"--%>
<%--            /></td>--%>
            <td><button class="btn btn-info" data-toggle="modal" id="myButton${order.getOrderId()}">Detail</button></td>
            <script>
                $('#myButton${order.getOrderId()}').click(function () {
                    window.open("/orderdetail?orderid=${order.getOrderId()}","_blank",
                        "toolbar,scrollbars,resizable,top=500,left=500,width=800,height=800");
                });
            </script>
        </tr>
</c:forEach>

        </tbody>
        <tfoot>
        <tr>
            <th>orderId</th>
            <th>customerID</th>
            <th>dateOrdered</th>
            <th>status</th>
            <%--            <th>Price</th>--%>
            <%--            <th>IMG Product</th>--%>
            <th>Detail</th>
        </tr>
        </tfoot>
    </table>
</div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableProduct').DataTable();
    } );
</script>

<script>
    function submitDelete(){
        $("#formDelete").submit();
    }
    // function getID(idProduct){
    //     $.ajax({
    //         url: '/admin/product?idProductDelete='+idProduct+'&action=delete',
    //         data: {
    //             format: 'json'
    //         },
    //         error: function() {
    //             $('#info').html('<p>An error has occurred</p>');
    //         },
    //         dataType: 'jsonp',
    //         success: function(data) {
    //             alert("ok");
    //         },
    //         type: 'GET'
    //     });
    //     location.reload();
    // }
</script>
</body>
</html>
