<%--
  Created by IntelliJ IDEA.
  User: lanus
  Date: 11/08/2020
  Time: 02:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Customer</title>
    <style>
       #input {
           margin-top: 20px;
       }
    </style>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM- CUSTOMER RELATIONSHIP MANAGER</h2>
    </div>
    <input id="input" type="button" value="Add Customer" onclick="window.location.href= 'showFormAdd';
return false;" class="add-button" /><br>
    <form:form action="Search" method="GET" modelAttribute="customer" >
        <input type="text" name="searchCustomer" /> <input type="submit" value="Search" class="add-button">
    </form:form>

    <div id="container">
        <div id="content">
            <table>
                <tr><th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="item" items="${customer}">
                    <c:url var="updateLink" value="/customer/customerUpdate">
                        <c:param name="customerID" value="${item.id}"/>
                    </c:url>
                    <c:url var="deleteLink" value="/customer/customerDelete">
                        <c:param name="customerDeleteID" value="${item.id}"/>
                    </c:url>
                    <tr>
                        <td>${item.firstName}</td>
                        <td>${item.lastName}</td>
                        <td>${item.email}</td>
                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}" onclick=
                                    "if(!(confirm('Are you sure to delete this customer?')))
                                        return false">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div style="clear:both"></div>
            <a href="${pageContext.request.contextPath}/customer/customerList">Return to Customer List</a>
        </div>
    </div>
</div>
</body>
</html>
