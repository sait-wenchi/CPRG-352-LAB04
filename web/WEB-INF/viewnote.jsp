<%-- 
    Document   : viewnote
    Created on : 30-Sep-2021, 8:30:25 PM
    Author     : wenchi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Note View Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <b>Title:</b> ${note.title}</p>
        <b>Contents:</b> <br>${note.contents}</p>
        <a href="note?edit">Edit</a>
    </body>
</html>
