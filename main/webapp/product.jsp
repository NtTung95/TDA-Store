<%@ page import="DAO.customer.CustomerDAO" %>
<!DOCTYPE html>
<html lang="en">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="styles.css">
<html>

<head>
    <title>Home</title>
    <meta charset="UTF-8">
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">

    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav" style="">
                <li class="nav-item active">
                    <a class="nav-link" href="/homepage">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <div class="dropdown">
                        <a href="/products" class="nav-link dropbtn">Product</a>
                        <div class="dropdown-content">
                            <ul>
                                <c:forEach items='${requestScope["categoryList"]}'
                                           var="category">
                                    <li> <a href="/products?category=${category.getCategoryId()}">${category.getNameCategory()}</a>  </li>
                                </c:forEach>



                                <img src="image/male.jpg"
                                     style="height: 400px ;position:absolute;top: 0px;left: 450px">

                            </ul>
                        </div>
                    </div>
                </li>
                <%
                    String displayManagement;
                    if (session.getAttribute("nullCustomer") == null) {
                        displayManagement = "none";
                    } else {
                        if ((int) session.getAttribute("typeOfId") == CustomerDAO.CHECK_ADMIN) {
                            displayManagement = "block";
                        } else {
                            displayManagement = "none";
                        }
                    }
                %>

                <li class="nav-item" style="display:<%=displayManagement%>">
                    <div class="dropdown">
                        <a class="nav-link dropbtn" href="#" id="navbarDropdown" role="button" data-toggle="dropdown">
                            Management
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown" style="height: auto; width: auto">
                            <a class="dropdown-item" href="/admin/customer">User Management
                            </a>
                            <a class="dropdown-item" href="/admin/product">Product Management
                            </a>
                        </div>
                    </div>
                </li>

                <a class="navbar-brand" href="/homepage" style="position:absolute ; left:600px "><img src="image/Logo-TDA.png" style="height: 40px"></a>
            </ul>
        </div>
        <div>
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <form class="form-inline my-2 my-lg-0" method="get" action="/products">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                               name="search">
                        <input type="search" hidden name="action" value="search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </li>
                <li class="nav-item active"><a class="nav-link" href="/cart">
                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-cart-check-fill" fill="currentColor"
                         xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd"
                              d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM4 14a1 1 0 1 1 2 0 1 1 0 0 1-2 0zm7 0a1 1 0 1 1 2 0 1 1 0 0 1-2 0zm.354-7.646a.5.5 0 0 0-.708-.708L8 8.293 6.854 7.146a.5.5 0 1 0-.708.708l1.5 1.5a.5.5 0 0 0 .708 0l3-3z"/>
                    </svg>
                </a></li>
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
                        <a class="nav-link dropbtn" href="<%=url%>">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-door-open-fill"
                                 fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd"
                                      d="M1.5 15a.5.5 0 0 0 0 1h13a.5.5 0 0 0 0-1H13V2.5A1.5 1.5 0 0 0 11.5 1H11V.5a.5.5 0 0 0-.57-.495l-7 1A.5.5 0 0 0 3 1.5V15H1.5zM11 2v13h1V2.5a.5.5 0 0 0-.5-.5H11zm-2.5 8c-.276 0-.5-.448-.5-1s.224-1 .5-1 .5.448.5 1-.224 1-.5 1z"/>
                            </svg>
                            <%=nameResult%>
                        </a>

                        <div class="dropdown-content" style="height: auto; width: auto">
                            <a href="<%=urlMenu1%>"><%=menu1%>
                            </a>
                            <a href="<%=urlMenu2%>"><%=menu2%>
                            </a>
                            <%--                            <a href="#">Link 3</a>--%>

                        </div>
                    </div>
                </li>


            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid" style="padding-top: 100px">
    <div class="row">
<%--        <div class="col-lg-2">--%>
<%--            <div></div>--%>
<%--        </div>--%>
        <c:forEach items='${requestScope["listProduct"]}'
                   var="product">
            <div class="col-lg-2">
                <div class="card" style="width: 14rem; border: 1px solid white">
                    <a href="/productDetail?productId=${product.getProductId()}"><img src="${product.getImgMain()}" style="max-height: 250px" class="card-img-top" a></a>
                    <div class="card-body">
                        <form action="/cart" id="formAddCart${product.getProductId()}" method="post">
                            <input type="text" name="action" value="add" hidden>
                            <input type="number" name="amoutSelect" value="1" hidden>
                            <input type="text" name="sizeSelect" value="null" hidden>

                            <input type="text" name="IdProduct" value="${product.getProductId()}" hidden>
                        </form>
                        <h6>${product.getProductName()}</h6>
                        <h6 style="font-weight: bold;color: #7abaff!important;">${product.getPrice()}</h6>
                        <a href="#" onclick="addToCart${product.getProductId()}()"> <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-cart-check-fill" fill="currentColor"
                                          xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                  d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM4 14a1 1 0 1 1 2 0 1 1 0 0 1-2 0zm7 0a1 1 0 1 1 2 0 1 1 0 0 1-2 0zm.354-7.646a.5.5 0 0 0-.708-.708L8 8.293 6.854 7.146a.5.5 0 1 0-.708.708l1.5 1.5a.5.5 0 0 0 .708 0l3-3z"/>
                        </svg></a>
                    </div>
                </div>
            </div>
            <script>
                function addToCart${product.getProductId()}(){
                    $("#formAddCart${product.getProductId()}").submit();
                }
            </script>
        </c:forEach>


    </div>



</div>
<div>
    <div class="row" style="height: 150px">
    </div>
</div>
<hr style="background:#b3b7bb">
<footer class="page-footer font-small blue pt-4">

    <!-- Footer Links -->
    <div class="container-fluid text-center text-md-left">

        <div class="row">

            <!-- Grid column -->
            <div class="col-md-4">

                <h5 class="text-uppercase">Công ty cổ phẩn TDT Fashion</h5>

                <ul class="list-unstyled">
                    <li>
                        <a>Số ĐKKD: 0107574310, ngày cấp: 23/09/2016. Nơi cấp: Sở Kế hoạch và đầu tư Hà Nội</a>
                    </li>
                    <li>
                        <a>Địa chỉ liên hệ: Phòng 301 Tòa nhà GP Invest, 170 La Thành, P. Ô Chợ Dừa, Q. Đống Đa, Hà
                            Nội</a>
                    </li>
                    <li>
                        <a>Điện thoại: +8424 - 7303.0222
                            Fax: +8424 - 6277.6419
                        </a>

                    </li>
                    <li>
                        <a>Email: binhminhbenem2801@gmail.com</a>
                    </li>
                </ul>

            </div>
            <!-- Grid column -->

            <hr class="clearfix w-100 d-md-none pb-3">

            <!-- Grid column -->
            <div class="col-md-2">

                <!-- Links -->
                <h5 class="text-uppercase">Products</h5>

                <ul class="list-unstyled">
                    <c:forEach items='${requestScope["categoryList"]}'
                               var="category">
                        <li> <a href="/products?category=${category.getCategoryId()}">${category.getNameCategory()}</a>  </li>
                    </c:forEach>


                </ul>

            </div>

            <div class="col-md-2">

                <!-- Links -->
                <h5 class="text-uppercase">Thương Hiệu</h5>

                <ul class="list-unstyled">
                    <li c>
                        <a href="#!">Giới thiệu</a>
                    </li>
                    <li>
                        <a href="#!">Liên hệ</a>
                    </li>
                    <li>
                        <a href="#!">Tuyển dụng</a>
                    </li>
                    <li>
                        <a href="#!">Hệ thống cửa hàng</a>
                    </li>
                </ul>
            </div>
            <div class="col-md-4">


                <ul class="list-unstyled">
                    <li>
                        <form class="form-inline my-2 my-lg-0" method="get" action="/products">
                            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                                   name="search">
                            <input type="search" hidden name="action" value="search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </li>
                    <li>
                        <a href="#"> <img src="image/Facebook_logo.png" style="height: 50px"></a>
                        <a href="#"> <img src="image/twice.png" style="height: 50px"></a>
                        <a href="#"> <img src="image/zalo-logo.png" style="height: 50px"></a>
                    </li>

                </ul>

            </div>


        </div>

    </div>


    <!-- Footer Links -->

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3" style="color: #b8daff">© 2020 Copyright:
        <a href="#"> TDA.vn</a>
    </div>
</footer>
</body>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
        integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
        crossorigin="anonymous"></script>
</body>
</html>