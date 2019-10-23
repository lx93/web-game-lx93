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
<%@ page import="com.example.appengine.java8.HelloAppEngine" %>
<html>
<head>
  <link href='//fonts.googleapis.com/css?family=Marmelad' rel='stylesheet' type='text/css'>
  <title>Book Sample: Objects and Lists</title>
</head>
<body>
    

 
  
  <form method="GET" action="/doit">

    <div class="form-group">
      <label for="title">Title</label>
      <input type="text" name="title" id="title" value="" class="form-control" />
    </div>
    
    <div class="form-group">
      <label for="author">Author</label>
      <input type="text" name="author" id="author" value="" class="form-control" />
    </div>

    <div class="form-group">
      <label for="genre">Genre</label>
      <input type="radio" name="genre" id="genre" value="fiction" checked class="form-control" /> Fiction
      <input type="radio" name="genre" id="genre" value="non-fiction" class="form-control" /> Non-fiction
    </div>

    <button type="submit" class="btn btn-success">Submit</button>
  </form>
   <h2>Some other servlets</h2>
  <table>
    <tr>
      <td colspan="2" style="font-weight:bold;">Available Servlets:</td>
    </tr>
    <tr>
      <td><a href='/hello'>Hello App Engine</a></td>
      <td><a href='/goodbye'>Goodbye App Engine</a></td>
    </tr>
  </table>

</body>
</html>