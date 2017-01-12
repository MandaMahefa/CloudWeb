/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itu.testcloud;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mandaR
 */
public class MainConfig {
    //postgres://hxukwcapjrkyyt:a2f163fed68ba3450d5a196fa5882ec8204de308c5fa6df33f937eefd48afeab@ec2-54-225-127-147.compute-1.amazonaws.com:5432/d41fjr3pfed1m4
    public static Connection dataSource() throws URISyntaxException, SQLException {
//        URI dbUri = new URI(System.getenv("postgres://hxukwcapjrkyyt:a2f163fed68ba3450d5a196fa5882ec8204de308c5fa6df33f937eefd48afeab@ec2-54-225-127-147.compute-1.amazonaws.com:5432/d41fjr3pfed1m4"));
        String url=System.getenv("JDBC_DATABASE_URL");
        
//        String username = dbUri.getUserInfo().split(":")[0];
//        String password = dbUri.getUserInfo().split(":")[1];
//        String username = "hxukwcapjrkyyt";
//        String password = "a2f163fed68ba3450d5a196fa5882ec8204de308c5fa6df33f937eefd48afeab";
//        String host="ec2-54-225-127-147.compute-1.amazonaws.com";
//        String port="5432";
//        String path="d41fjr3pfed1m4";
//        String ConnectionString = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
//         String ConnectionString = "jdbc:postgresql://" + host + ':' + port +"/"+ path;
         
//        return DriverManager.getConnection(ConnectionString, username, password);
        
         return DriverManager.getConnection(url);
    }
    public static void main(String [] args) throws Exception{
            Connection connection=dataSource();System.out.println("OK");
            Statement stmt = connection.createStatement();
           stmt.executeUpdate("CREATE TABLE IF NOT EXISTS personne (nom character varying(30))");
           stmt.executeUpdate("INSERT INTO personne VALUES ('manda')");
           ResultSet rs = stmt.executeQuery("SELECT nom FROM personne");
            while (rs.next()) {
                System.out.println("Lecture database: " + rs.getString("nom") + "\n");
            }
        
    }
    
}
