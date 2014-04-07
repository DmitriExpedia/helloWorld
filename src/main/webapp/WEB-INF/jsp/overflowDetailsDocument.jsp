<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

Event details
<table border="1" style="width:300px">

<tr>
  <th>IP Address</th>
  <th>Event time</th> 
  <th>VM status</th>
  <th>Queue name</th>
  <th>Events in queue</th>
  <th>Queue low threshold</th>
  <th>Queue warn threshold</th>
  <th>Queue critical threshold</th>
</tr>

<c:forEach var="historyRecord" items="${historyRecords}" varStatus="status">

<tr>
  <td>${historyRecord.ipAddress}</td>
  <td>${historyRecord.creationDate}</td> 
  <td>${historyRecord.statusCode}</td>
  <td>${historyRecord.queueName}</td>
  <td>${historyRecord.overflowValue}</td> 
  <td>${historyRecord.lowThreshold}</td>
  <td>${historyRecord.warningThreshold}</td>
  <td>${historyRecord.criticalThreshold}</td> 
</tr>	

</c:forEach>
</table>