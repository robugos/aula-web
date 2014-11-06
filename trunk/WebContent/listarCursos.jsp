<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>
;<% 
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/aulaweb";
	String usuario = "root";
	String senha = "mugen";
	Connection conexao;
	Statement statement;
	ResultSet resultSet;
	
	try {
		Class.forName(driver);
		conexao = DriverManager.getConnection(url, usuario, senha);
		System.out.println("conexão está ok");
		statement = conexao.createStatement();
		resultSet = statement.executeQuery("select * from predio");
				
		while (resultSet.next()) {
			out.println(resultSet.getString("nome")+"#");
		}
	}
	catch (ClassNotFoundException Driver) 
	{
		out.println("Driver não localizado: "+Driver);	
	}catch (SQLException ex) {
		out.println("Erro no conaxão com a fonte: "+ex);
	}
	
	out.println("^");

%>