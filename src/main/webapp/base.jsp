<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>University Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body style="background-color: aliceblue">

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #33539a">
        <div>
            <a href="http://localhost:8080/UniversityManagementSystem_Web_war_exploded/base.jsp" class="navbar-brand"> University
                Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/studentList"
                   class="nav-link">Students</a></li>
            <li><a href="<%=request.getContextPath()%>/teacherList"
                   class="nav-link">Teachers</a></li>
        </ul>
    </nav>
</header>
<br>

<div>
    <div>
        <h3 class="text-center" style="color: rgb(255,2,2)">University Management System</h3><br><br>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <img src="https://www.kln.ac.lk/images/2022/03/03/graduated.png" alt="" width="300" height="300">
                        <h5 class="card-title mt-3">Student List</h5>
                        <a href="<%=request.getContextPath()%>/studentList" class="btn btn-primary">Student List</a>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <img src="https://t3.ftcdn.net/jpg/01/07/71/94/360_F_107719471_KnQZB77SHLN6sPOJ65lYcsAfeZLqyws9.jpg" alt="" width="300" height="300">
                        <h5 class="card-title mt-3">Teacher List</h5>
                        <a href="<%=request.getContextPath()%>/teacherList" class="btn btn-primary">Teacher List</a>
                    </div>
                </div>
            </div>
        </div>


    </div>

</div>
</body>
</html>