<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Employee Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add an Employee
</h1>

<c:url var="addAction" value="/employee/add" ></c:url>

<form:form action="${addAction}" commandName="employee">
<table>
	<tr>
	    <td>
			<form:label path="empNo">
				<spring:message text="empNo"/>
			</form:label>
		</td>
			<td>
			<form:input path="empNo" />
		</td> 
	<tr>
	<tr>
		<td>
			<form:label path="firstName">
				<spring:message text="First Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="firstName" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="lastName">
				<spring:message text="Last Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="lastName" />
		</td>
	</tr>
    	<tr>
		<td>
			<form:label path="gender">
				<spring:message text="Gender"/>
			</form:label>
		</td>
		<td>
			<form:input path="gender" />
		</td>
	</tr>
    	<tr>
		<td>
			<form:label path="birthDate">
				<spring:message text="Birth Date"/>
			</form:label>
		</td>
		<td>
			<form:input path="birthDate" />
		</td>
	</tr>
    	<tr>
		<td>
			<form:label path="hireDate">
				<spring:message text="Hire Date"/>
			</form:label>
		</td>
		<td>
			<form:input path="hireDate" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty employee.firstName}">
				<input type="submit"
					value="<spring:message text="Edit Employee"/>" />
			</c:if>
			<c:if test="${empty employee.firstName}">
				<input type="submit"
					value="<spring:message text="Add Employee"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Employee List</h3>
<c:if test="${!empty listEmployees}">
	<table class="tg">
	<tr>
		<th width="120">Employee EmpNo</th>
        <th width="120">Employee First Name</th>
        <th width="120">Employee Last Name</th>
        <th width="120">Employee Gender</th>
		<th width="120">Employee Birth Date</th>
        <th width="120">Employee Hire Date</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listEmployees}" var="employee">
		<tr>
            <td>${employee.empNo}</td>
            <td>${employee.firstName}</td>
			<td>${employee.lastName}</td>
            <td>${employee.gender}</td>
            <td>${employee.birthDate}</td>
			<td>${employee.hireDate}</td>
			<td><a href="<c:url value='/edit/${employee.empNo}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${employee.empNo}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
