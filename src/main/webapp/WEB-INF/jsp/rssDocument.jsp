<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="application/atom+xml; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<?xml version="1.0" encoding="UTF-8"?>
  <feed xmlns="http://www.w3.org/2005/Atom">
  <title>${rssLine.title}</title>
  <link type="${rssLine.link.type}" href="${rssLine.link.href}" rel="${rssLine.link.rel}"/>
  <updated>${rssLine.updated}</updated>
  <author>
    <name>${rssLine.authorName}</name>
  </author>
  <id>${rssLine.id}</id>

		<c:forEach var="rssEntry" items="${rssLine.entries}" varStatus="status">
			
			<entry>
    <title>${rssEntry.title}</title>
    <link type="${rssEntry.link.type}" href="${rssEntry.link.href}" rel="${rssEntry.link.rel}"/>
    <id>${rssEntry.id}</id>
    <published>${rssEntry.published}</published>
    <updated>${rssEntry.updated}</updated>
    <description>${rssEntry.description}</description>
  </entry>
			
			
			
			
			
		</c:forEach>
  </feed>