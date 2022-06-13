<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="<c:url value="/img/zesco.png" />" type="image/x-icon">
    <link rel="stylesheet" href="<c:url value="/sweetalert2/sweetalert2.min.css"/>">
    <title>Login</title>

    <%--

            <c:url value="xxxxxxxxxxxx"/>

    --%>

    <link href="<c:url value="/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/css/sb-admin-2.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">

</head>

<body class="bg-green">

<div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">ZESCO | SIGNUP</h1>
                                </div>
                                <form id="SignupForm" style="height: 70vh">

                                    <div class="form-group">
                                        <label>First Name</label><br>
                                        <input type="text" class="form-control form-control-user" name="firstName">
                                    </div>

                                    <div class="form-group">
                                        <label>Last Name</label><br>
                                        <input type="text" class="form-control form-control-user" name="lastName">
                                    </div>

                                    <div class="form-group">
                                        <label>Role</label><br>
                                        <select name="role" class="form-control form-control-user">
                                            <option value="Inspector">Inspector</option>
                                            <option value="Supervisor">Supervisor</option>
                                        </select>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label>Email</label><br>
                                        <input type="email" class="form-control form-control-user" name="email">
                                    </div>
                                    
                                    <div class="form-group mt-4">
                                        <label>Password</label><br>
                                        <input type="password" class="form-control form-control-user"
                                               name="password">
                                    </div>
                                    
                                    <button type="submit" class="btn btn-primary btn-user btn-block mt-4">
                                        Signup
                                    </button>

                                    <div class="text-center mt-5">
                                        <a href="login">Login</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>

<!-- Bootstrap core JavaScript-->
<script src="<c:url value="/vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
<script src="<c:url value="/sweetalert2/sweetalert2.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value="/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value="/js/sb-admin-2.min.js"/>"></script>
<script src="<c:url value="/js/signup.js"/>"></script>

</body>

</html>