<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>
<%@page import = "java.util.*"%>
<%@page import = "java.util.*"%>
<%@page import = "br.com.aulaweb.vo.DisciplinaVO"%>



<% 
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/aulaweb";
	String usuario = "root";
	String senha = "mugen";
	Connection conexao;
	Statement statement;
	ResultSet resultSet;
	List <DisciplinaVO> listaDisciplina = new ArrayList <DisciplinaVO> ();
	
	try {
		Class.forName(driver);
		conexao = DriverManager.getConnection(url, usuario, senha);
		System.out.println("conexão está ok");
		statement = conexao.createStatement();
		resultSet = statement.executeQuery("select * from disciplina where idCurso = '"+request.getParameter("idCurso")+"'");
		List <String> lista = new ArrayList <String>();
		while (resultSet.next()) {
			DisciplinaVO disciplinaVO = new DisciplinaVO();
			disciplinaVO.setIdDisciplina((resultSet.getInt("idDisciplina")));
			disciplinaVO.setNome(resultSet.getString("nome"));
			disciplinaVO.setProfessor(resultSet.getString("professor"));

			listaDisciplina.add(disciplinaVO);
			
		}
		
		for (DisciplinaVO d: listaDisciplina) {
			out.println(d.getIdDisciplina());
			out.println(d.getNome());
			out.println(d.getProfessor());

		}
	}
	catch (ClassNotFoundException Driver) 
	{
		out.println("Driver não localizado: "+Driver);	
	}catch (SQLException ex) {
		out.println("Erro no conaxão com a fonte: "+ex);
	}
	

%>