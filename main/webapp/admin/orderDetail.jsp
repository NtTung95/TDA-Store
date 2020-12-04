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




<div class="container-fluid">


    <table id="tableProduct" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>CustomerID</th>
            <th>OrderID</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Date Ordered</th>

        </tr>
        </thead>
        <tbody>
<c:forEach items='${requestScope["orderDetails"]}'
           var="order">
        <tr>
            <td>${order.getCustomerID()}</td>
            <td>${order.getOrderId()}</td>
            <td>${order.getProductName()}</td>
            <td>${order.getPrice()}</td>
            <td>${order.getQuantity()}</td>
            <td>${order.getDateOrdered()}</td>
<%--            <td>${product.getPrice()}</td>--%>
<%--            <td><img id="blah5" class="imgPreviewTable" src="${product.getImgMain()}"--%>
<%--            /></td>--%>
<%--            <td><button class="btn btn-info" data-toggle="modal" data-target="#editModal${product.getProductId()}">Edit</button></td>--%>
<%--            <td><form action="/admin/product" method="post" id="formDelete">--%>
<%--                <input type="text" name="action" value="delete" hidden>--%>
<%--                <input type="text" name="idProduct" value="${product.getProductId()}" hidden>--%>
<%--                <input type="submit" class="btn btn-danger" onclick="submitDelete()" value="delete">--%>
<%--&lt;%&ndash;                <button class="btn btn-danger" id="${product.getProductId()}" onclick="submitDelete()">Delete</button>&ndash;%&gt;--%>
<%--            </form>--%>
<%--            </td>--%>


        </tr>
</c:forEach>

        </tbody>
        <tfoot>
        <tr>
            <th>CustomerID</th>
            <th>OrderID</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Date Ordered</th>
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
