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
		String sql = "insert into usuario(email, nome, senha)"
		+" values "+"('"+request.getParameter("email")+"','"+request.getParameter("nome")
		+"','"+request.getParameter("senha")+"')";			
		
		int gravar = statement.executeUpdate(sql);
		
		if (gravar == 1) {
			out.print("1");
		}else {
			out.print("0");
		}
	}
	catch (ClassNotFoundException Driver) 
	{
		out.println("Driver não localizado: "+Driver);	
	}catch (SQLException ex) {
		out.println("Erro de SQL:"+ex);
	}
	out.println("^");

%> 