package br.com.aulaweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	public Connection getConnection () {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost/aulaweb","root","mugen");
			//return DriverManager.getConnection("jdbc:postgresql://150.161.89.80:5432/pontoeletronico","postgres","mugen");

			
		}catch (SQLException ex) {
			
			throw new RuntimeException(ex);
			
		}catch (ClassNotFoundException ex) {
			
			throw new RuntimeException(ex);
		}
		
	}
	

}
