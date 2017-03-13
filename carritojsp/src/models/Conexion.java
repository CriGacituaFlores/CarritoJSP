package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private String username = "root";
	private String password = "root";
	private String hostname = "localhost";
	private String port = "3306";
	private String database = "carritojsp";
	private String classname = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://" + hostname +":"+port+"/"+database;
	private Connection conn = null;
	
	public Conexion() {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  conn = DriverManager.getConnection("jdbc:mysql://localhost/carritojsp?autoReconnect=true&useSSL=false","root","root");
		} catch (SQLException e) {
		    throw new RuntimeException(e); 
		}
	}

	public Connection getConnection() {
		return this.conn;
	}
	
}
