<!DOCTYPE html>
<!-- [START_EXCLUDE] -->
<%--
  ~ Copyright 2017 Google Inc.
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License"); you
  ~ may not use this file except in compliance with the License. You may
  ~ obtain a copy of the License at
  ~
  ~     http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
  ~ implied. See the License for the specific language governing
  ~ permissions and limitations under the License.
  --%>
<!-- [END_EXCLUDE] -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
  <link href='//fonts.googleapis.com/css?family=Marmelad' rel='stylesheet' type='text/css'>
  <title>Do It</title>
</head>
<body>
    <h1>Some references to strings and book properties</h1>

     <p>${fn:escapeXml(title)} is good</p>
     <p>${author} is great</p>
     <p>${book.title} and ${book.author} and ${book.genre}</p>

    <c:choose>
  	<c:when test="${empty bookList}">
       <p>No books</p>
     </c:when>
    <c:otherwise>
      <h1>The entire book list</h1>
          <ol>
              <c:forEach items="${bookList}" var="aBook">
                    <li>${aBook.title} -- ${aBook.author} -- ${aBook.genre}</li>
               </c:forEach>
           </ol>
      </c:otherwise>
  	  </c:choose>

</body>
</html>
