<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>${partnerName} : 24 hours VM's nacks history</h1>
<table border="1" style="width:300px">

<tr>
  <th>Event Time</th>
  <th>IP Address</th>
  <th>PctMessageIn</th>
  <th>PctUpdate</th>
  <th>PctOutFail</th>
  <th>PctOutResponseTime</th>
  <th>PctCapacityAllowed</th>
</tr>

<c:forEach var="historyRecord" items="${historyRecords}" varStatus="status">

<tr>
  <td>${historyRecord.creationDate}</td>
  <td>${historyRecord.ipAddress}</td>
  <td>${historyRecord.pctMessageIn}</td> 
  <td>${historyRecord.pctUpdate}</td>
  <td>${historyRecord.pctOutFail}</td>
  <td>${historyRecord.pctOutResponseTime}</td> 
  <td>${historyRecord.pctCapacityAllowed}</td>
</tr>	

</c:forEach>
</table>