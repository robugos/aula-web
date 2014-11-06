<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>
<% 
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://150.161.16.234/aulaweb";
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
		String sql = "select * from usuario where "
				+"nome = '"+request.getParameter("nome")+"' and senha = '"+request.getParameter("senha")+"'";
		resultSet = statement.executeQuery(sql);
						
		if (resultSet.next()) {
			out.println("1");
		
		}else {
			out.println("0");
			}
		}catch (Exception ex) {
			out.println("Erro: "+ex.getMessage());
		}
	
%>