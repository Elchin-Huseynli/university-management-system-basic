<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Teacher Management Application</title>
  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
</head>
<body>

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

<div class="row">
  <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

  <div class="container">
    <h3 class="text-center">List of Teachers</h3>
    <hr>
    <div class="container text-left">
      <form action="<%=request.getContextPath()%>/newTeacher"  method="post">
        <button type="submit" class="btn btn-success">Add New Teacher</button>
      </form>
    </div>
    <br>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Subject</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <!--   for (Todo todo: todos) {  -->
      <c:forEach var="teacher" items="${teacherList}">

        <tr>
          <td><c:out value="${teacher.id}" /></td>
          <td><c:out value="${teacher.name}" /></td>
          <td><c:out value="${teacher.email}" /></td>
          <td><c:out value="${teacher.subject}" /></td>
          <td>
            <a href="editTeacher?id=<c:out value='${teacher.id}' />" class="btn-primary">Edit</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="deleteTeacher?id=<c:out value='${teacher.id}' />" class="btn-danger">Delete</a>
          </td>
        </tr>
      </c:forEach>
      <!-- } -->
      </tbody>

    </table>
  </div>
</div>
</body>
</html>