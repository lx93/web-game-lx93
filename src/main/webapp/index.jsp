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
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
  <link href='//fonts.googleapis.com/css?family=Marmelad' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <title>MASTERMIND🍑🍑🍑<</title>
</head>
<body>
  <h1>Welcome to MasterMind 🍑🍑🍑</h1>


  <form method="GET" action="/index">
  <button class="btn btn-success" name="button" value="newgame">New Game</button>

  <c:if test="${!correct}">

    <div class="form-group">
      <label for="title">Welcome to MasterMind! Enter your guess, bitchbitch</label>
      <input type="text" name="guess" id="guess" class="form-control" />
    </div>

    <button type="submit" class="btn btn-success" name="button" value="submit">Submit</button>
  </form>
  </c:if>

      <c:choose>
       <c:when test="${empty guess}">
         <p>Guess a color combo (e.g. YBRG)</p>
       </c:when>
      <c:otherwise>
        <c:if test="${!correct}">
           <p>${randomPhrase} is the correct answer.</p>
           <p>${guess} is user guess.</p>
           <p>${exacts} exacts correct</p>
           <p>${partials} partials correct</p>
        </c:if>
        <c:if test="${correct}">
            <p>you won!</p>
        </c:if>
        </c:otherwise>
      </c:choose>








</body>
</html>