<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/polarisNews/css/style1.css" type="text/css"  />


<div class="block1" >Event details</div>

<div class="datagrid" style="width:1500px">
<table>
<thead><tr><th>Audit ID</th><th>Admin Tools IP</th><th>User</th><th>Creation Date</th><th>Type</th><th>Property</th><th>Old Value</th><th>New Value</th></tr></thead>
<tbody><tr><td>${event.auditID}</td><td>${event.originatorIP}</td><td style="">${event.creationUser}</td><td>${event.creationDate}</td><td>${event.type}</td><td>${event.path}/${event.propertyName}</td><td>${event.oldValue}</td><td>${event.newValue}</td></tr>
</tbody>
</table>
</div>