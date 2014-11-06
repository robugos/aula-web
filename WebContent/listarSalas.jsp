<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>
<%@page import = "java.util.List"%>
<%@page import = "br.com.aulaweb.vo.SalaVO"%>
<%@page import = "br.com.aulaweb.vo.PredioVO"%>
<%@page import = "br.com.aulaweb.dao.SalaDAO"%>




 <%

	PredioVO predioVO = new PredioVO();
	SalaDAO salaDAO = new SalaDAO();
	predioVO.setIdPredio(Integer.parseInt(request.getParameter("idPredio")));
	List  <SalaVO> listaSalas = salaDAO.selecionarTudo(predioVO);

	for (SalaVO s: listaSalas) {
	out.println(s.getIdSala());
	out.println(s.getNumero()+"-"+s.getFkPredio().getNome());
	}
%>