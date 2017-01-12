<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.itu.testcloud.MainConfig"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
     Connection connection=MainConfig.dataSource();
            Statement stmt = connection.createStatement();
           stmt.executeUpdate("CREATE TABLE IF NOT EXISTS personne (nom character varying(30))");
           stmt.executeUpdate("INSERT INTO personne VALUES ('manda')");
           ResultSet rs = stmt.executeQuery("SELECT nom FROM personne");
            while (rs.next()) {
                out.println("Lecture database: " + rs.getString("nom") + "\n");
            }

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= "Database reussite" %></h1>
    </body>
</html>
