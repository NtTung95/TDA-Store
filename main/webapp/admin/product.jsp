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
<div id="header">

</div>
<div class="container-fluid">

    <div class="tableProduct">
        <div class="div-addproduct">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                Open modal
            </button>

        </div>
        <!-- The Modal -->
        <div class="modal fade" id="myModal">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Modal Heading</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <form action="" method="post">
                            <div class="form-group col-sm-4 row1">
                                <label for="">ProductId:</label>
                                <input type="text" name="productId" id="idProduct" class="form-control">
                            </div>
                            <div class="form-group col-sm-4 row1">
                                <label for="">Product Name:</label>
                                <input type="text" name="productName" id="ProductName" class="form-control">
                            </div>
                            <div class="form-group col-sm-4 row1">
                                <label for="">Category:</label>
                                <select name="categoryProduct" id="Category" class="form-control">
                                    <option value=""></option>
                                </select>
                            </div>
                            <div class="form-group col-sm-4 row1">
                                <label for="">Quantity:</label>
                                <input type="text" name="quantityProduct" id="Quantity" class="form-control">
                            </div>
                            <div class="form-group col-sm-4 row1">
                                <label for="">Price:</label>
                                <input type="text" name="priceProduct" id="Price" class="form-control">
                            </div>
                            <div class="form-group col-sm-4 row1">
                                <label for="">Description:</label>
                                <input type="text" name="descriptionProduct" id="Description" class="form-control">
                            </div>
                            <div class="form-group col-sm-4 row2">
                                <label for="">Img Main:</label>
                                <input type="text" name="imgMainProduct" id="imgInp1" class="form-control">
                            </div>
                            <div class="form-group col-sm-4 row2">
                                <label for="">Img Child 1:</label>
                                <input type="text" name="img1Product" id="imgInp2" class="form-control">
                            </div>
                            <div class="form-group col-sm-4 row2">
                                <label for="">Img Child 2:</label>
                                <input type="text" name="img2Product" id="imgInp3" class="form-control">
                            </div>
                            <div class="col-sm-4 row2">

                                <img id="blah1" class="imgPreview" src="https://batdongsankhanhhoa.com.vn/FileStorage/Product/no-image.jpg"/>
                            </div>

                            <div class="col-sm-4 row2">
                                <img id="blah2" class="imgPreview" src="https://batdongsankhanhhoa.com.vn/FileStorage/Product/no-image.jpg"
                                />
                            </div>

                            <div class="col-sm-4 row2">
                                <img id="blah3" class="imgPreview" src="https://batdongsankhanhhoa.com.vn/FileStorage/Product/no-image.jpg"
                                />
                            </div>
                            <div class="form-group col-sm-6 row2">
                                <label for="">Img Child 3:</label>
                                <input type="text" name="img3Product" id="imgInp4" class="form-control">
                            </div>
                            <div class="form-group col-sm-6 row2">
                                <label for="">Img Child 4:</label>
                                <input type="text" name="img4Product" id="imgInp5" class="form-control">
                            </div>
                            <div class="col-sm-6 row2">

                                <img id="blah4" class="imgPreview" src="https://batdongsankhanhhoa.com.vn/FileStorage/Product/no-image.jpg"
                                />
                            </div>

                            <div class="col-sm-6 row2">
                                <img id="blah5" class="imgPreview" src="https://batdongsankhanhhoa.com.vn/FileStorage/Product/no-image.jpg"
                                />
                            </div>

                            <div class="form-group col-sm-2 row1">
                                <label for="">Size S:</label>
                                <input type="text" name="SizeSProduct" id="" class="form-control">
                            </div>
                            <div class="form-group col-sm-2 row1">
                                <label for="">Size M:</label>
                                <input type="text" name="SizeMProduct" id="" class="form-control">
                            </div>
                            <div class="form-group col-sm-2 row1">
                                <label for="">Size L:</label>
                                <input type="text" name="SizeLProduct" id="" class="form-control">
                            </div>
                            <div class="form-group col-sm-2 row1">
                                <label for="">Size XL:</label>
                                <input type="text" name="SizeXLProduct" id="" class="form-control">
                            </div>
                            <div class="form-group col-sm-2 row1">
                                <label for="">Size XXL:</label>
                                <input type="text" name="SizeXXLProduct" id="" class="form-control">
                            </div>

                        </form>
                    </div>

                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>

            </div>
        </div>
    </div>
    <table id="tableProduct" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name Product</th>
            <th>Category</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>IMG Product</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
<c:forEach items='${requestScope["listProduct"]}'
           var="product">
        <tr>
            <td>${product.getProductId()}</td>
            <td>${product.getProductName()}</td>
            <td>${product.getCategoryId()}</td>
            <td>${product.getQuantity()}</td>
            <td>${product.getPrice()}</td>
            <td><img id="blah5" class="imgPreviewTable" src="${product.getImgMain()}"
            /></td>
            <td><button class="btn btn-info" data-toggle="modal" data-target="#editModal${product.getProductId()}">Edit</button></td>
            <td><button class="btn btn-danger">Delete</button></td>
            <!-- The Modal -->
            <div class="modal fade" id="editModal${product.getProductId()}">
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Modal Heading</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <form action="/admin/product" id="formSubmit${product.getProductId()}" method="post">
                                <div class="form-group col-sm-4 row1">
                                    <label for="">ProductId:</label>
                                    <input type="text" name="productId" id="productId" class="form-control" value="${product.getProductId()}" readonly>
                                </div>
                                <div class="form-group col-sm-4 row1">
                                    <label for="">Product Name:</label>
                                    <input type="text" name="productName" class="form-control" value="${product.getProductName()}">
                                </div>
                                <div class="form-group col-sm-4 row1">
                                    <label for="">Category:</label>
                                    <select name="categoryProduct" class="form-control">
                                        <option value="${product.getCategoryId()}">${product.getCategoryId()}</option>
    <c:forEach items='${requestScope["listCategory"]}'
               var="category">
                                        <option value="${category.getCategoryId()}">${category.getNameCategory()}</option>

    </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group col-sm-4 row1">
                                    <label for="">Quantity:</label>
                                    <input type="text" name="quantityProduct" class="form-control" value="${product.getQuantity()}">
                                </div>
                                <div class="form-group col-sm-4 row1">
                                    <label for="">Price:</label>
                                    <input type="text" name="priceProduct" class="form-control" value="${product.getPrice()}">
                                </div>
                                <div class="form-group col-sm-4 row1">
                                    <label for="">Description:</label>
                                    <input type="text" name="descriptionProdut" class="form-control" value="${product.getDescription()}">
                                </div>
                                <div class="form-group col-sm-4 row2">
                                    <label for="">Img Main:</label>
                                    <input type="text" name="imgMainProduct" id="imgInp1${product.getProductId()}" class="form-control" value="${product.getImgMain()}">
                                </div>
                                <div class="form-group col-sm-4 row2">
                                    <label for="">Img Child 1:</label>
                                    <input type="text" name="img1Product" id="imgInp2${product.getProductId()}" class="form-control" value="${product.getImg1()}">
                                </div>
                                <div class="form-group col-sm-4 row2">
                                    <label for="">Img Child 2:</label>
                                    <input type="text" name="img2Product" id="imgInp3${product.getProductId()}" class="form-control" value="${product.getImg2()}">
                                </div>
                                <div class="col-sm-4 row2">

                                    <img id="blah1${product.getProductId()}" class="imgPreview" src="${product.getImgMain()}"/>
                                </div>

                                <div class="col-sm-4 row2">
                                    <img id="blah2${product.getProductId()}" class="imgPreview" src="${product.getImg1()}"
                                    />
                                </div>

                                <div class="col-sm-4 row2">
                                    <img id="blah3${product.getProductId()}" class="imgPreview" src="${product.getImg2()}"
                                    />
                                </div>
                                <div class="form-group col-sm-6 row2">
                                    <label for="">Img Child 3:</label>
                                    <input type="text"  name="img3Product" id="imgInp4${product.getProductId()}" class="form-control" value="${product.getImg3()}">
                                </div>
                                <div class="form-group col-sm-6 row2">
                                    <label for="">Img Child 4:</label>
                                    <input type="text" name="img4Product" id="imgInp5${product.getProductId()}" class="form-control" value="${product.getImg4()}">
                                </div>
                                <div class="col-sm-6 row2">

                                    <img id="blah4${product.getProductId()}" class="imgPreview" src="${product.getImg3()}"
                                    />
                                </div>

                                <div class="col-sm-6 row2">
                                    <img id="blah5${product.getProductId()}" class="imgPreview" src="${product.getImg4()}"
                                    />
                                </div>

                                <div class="form-group col-sm-2 row1">
                                    <label for="">Size S:</label>
                                    <input type="text" name="SizeSProduct"class="form-control" value="${product.getSize_S()}">
                                </div>
                                <div class="form-group col-sm-2 row1">
                                    <label for="">Size M:</label>
                                    <input type="text" name="SizeMProduct" class="form-control" value="${product.getSize_M()}">
                                </div>
                                <div class="form-group col-sm-2 row1">
                                    <label for="">Size L:</label>
                                    <input type="text" name="SizeLProduct" class="form-control" value="${product.getSize_L()}">
                                </div>
                                <div class="form-group col-sm-2 row1">
                                    <label for="">Size XL:</label>
                                    <input type="text" name="SizeXLProduct"  class="form-control" value="${product.getSize_XL()}">
                                </div>
                                <div class="form-group col-sm-2 row1">
                                    <label for="">Size XXL:</label>
                                    <input type="text"  name="SizeXXLProduct" class="form-control" value="${product.getSize_XXL()}">
                                </div>
                                <input type="text" name="action" value="update" style="display: none">
<%--                                <div class="submmitButton col-sm-3">--%>
<%--                                    <input type="button" onclick="submitForm${product.getProductId()}()" class="btn btn-primary" value="Update">--%>
<%--                                </div>--%>
                            </form>
                        </div>
                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button"  onclick="submitForm${product.getProductId()}()" class="btn btn-primary">Update</button>
                        </div>
                        <script>
                            function submitForm${product.getProductId()}(){
                                Swal.fire({
                                    title: 'Are you sure?',
                                    text: "You won't be able to update this!",
                                    icon: 'warning',
                                    showCancelButton: true,
                                    confirmButtonColor: '#3085d6',
                                    cancelButtonColor: '#d33',
                                    confirmButtonText: 'Yes, update it!'
                                }).then((result) => {
                                    if (result.isConfirmed) {
                                        Swal.fire(
                                            'Update!',
                                            'Your Product has been update.',
                                            'success'
                                        )
                                        $("#formSubmit${product.getProductId()}").submit();
                                    }
                                })
                            }
                        </script>
                    </div>
                </div>
            </div>
        </tr>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $('#imgInp1${product.getProductId()}').bind('input', function () {
                $('#blah1${product.getProductId()}').attr('src', $(this).val()); //concatinate path if required
            });
            $('#imgInp2${product.getProductId()}').bind('input', function () {
                $('#blah2${product.getProductId()}').attr('src', $(this).val()); //concatinate path if required
            });
            $('#imgInp3${product.getProductId()}').bind('input', function () {
                $('#blah3${product.getProductId()}').attr('src', $(this).val()); //concatinate path if required
            });
            $('#imgInp4${product.getProductId()}').bind('input', function () {
                $('#blah4${product.getProductId()}').attr('src', $(this).val()); //concatinate path if required
            });
            $('#imgInp5${product.getProductId()}').bind('input', function () {
                $('#blah5${product.getProductId()}').attr('src', $(this).val()); //concatinate path if required
            });
        });
    </script>
</c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <th>Id</th>
            <th>Name Product</th>
            <th>Category</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>IMG Product</th>
            <th>Edit</th>
            <th>Delete</th>
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

</body>
</html>
