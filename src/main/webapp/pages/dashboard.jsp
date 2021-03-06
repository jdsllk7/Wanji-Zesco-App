<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<jsp:include page="header.jsp"/>


<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
    </div>

    <!-- Content Row -->
    <div class="row">

        <div class="text-center col-lg-12 m-2">
            <img src="<c:url value="/img/zesco.png" />" alt="">
        </div>

        <div class="col-lg-12 mb-4 text-center">
            <div class="card bg-transparent text-info m-2">
                <div class="card-body p-5">
                    Welcome to ZESCO Limited Issue Tracking Web App
                </div>
            </div>
        </div>

    </div>

</div>


<jsp:include page="footer.jsp"/>