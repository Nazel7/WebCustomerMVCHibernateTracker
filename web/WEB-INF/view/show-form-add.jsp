<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="Form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lanus
  Date: 14/08/2020
  Time: 03:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<style>
    #wrapper {width: 100%; margin-top: 0px; }
    #header {width: 70%; background: #09c332; margin-top: 0px; padding:15px 0px 15px 15px;}
    #header h2 {width: 100%; margin:auto; color: #FFFFFF;}
    #container {width: 100%; margin:auto}
    #container h3 {color: #000;}
    #container #content {margin-top: 20px;}
</style>
    <title>Add-New-Customer</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM- CUSTOMER RELATIONSHIP MANAGER</h2>
    </div>
</div>

<div id="container">
    <h3>Save Customer</h3>
        <Form:form action="showCustomer" Method="POST" modelAttribute="customer">
            <form:hidden path="id"/>
            <table>
                <tbody>
                <tr>
                    <td><label>First Name:</label></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><label>Last Name:</label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><label>Email:</label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><label><br><br></label></td>
                    <td><input type="submit" value="Save" class="save"/></td>
                </tr>
                </tbody>
            </table>
        </Form:form>
      <div style="clear:both"></div>
        <a href="${pageContext.request.contextPath}/customer/customerList">Return to Customer List</a>
    </div>
</body>
</html>
