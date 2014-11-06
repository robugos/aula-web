<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>
<%@page import = "java.util.*"%>
<%@page import = "java.util.*"%>
<%@page import = "br.com.aulaweb.vo.DisciplinaVO"%>
<%@page import = "br.com.aulaweb.vo.CursoVO"%>
<%@page import = "br.com.aulaweb.dao.DisciplinaDAO"%>



<% 

	CursoVO cursoVO = new CursoVO();
	DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
	cursoVO.setIdCurso(Integer.parseInt(request.getParameter("idCurso")));
	List  <DisciplinaVO> listaDisciplinas = disciplinaDAO.selecionarTudo(cursoVO);
	
	for (DisciplinaVO d: listaDisciplinas) {
	out.println(d.getIdDisciplina());
	out.println(d.getNome());
	out.println(d.getProfessor());


}


%>