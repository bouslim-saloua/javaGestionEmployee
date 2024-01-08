package com.api.dbconn;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    Connection con = null;

    String base = "reconnaissance_faciale";
    String url = "jdbc:mysql://localhost:3306/" + base;
    String user = "root";
    String password = "";
    public Connection conn;
    public Statement stm;
    public ResultSet rs;

    public Connection getConnexion() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            
        }
       
        return conn;
    }
    
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void executeSQL(String SQL) {
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(SQL);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public ResultSet executerSelect(String s){
		ResultSet rs=null;
		try {
		rs=stm.executeQuery(s);
		} catch (SQLException e) {
		System.out.println("Problème requete select");
		}
		return rs;
		}
    
    
}

