package br.com.aulaweb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.aulaweb.vo.CursoVO;

public class CursoDAO extends Dao{
	
	public void salvar (CursoVO cursoVO) {
		EntityManager em = getEntityManager();

		try {
			em.getTransaction().begin();
			
			CursoVO curso = new CursoVO ();
			curso.setNome(cursoVO.getNome());
			curso.setTurno(cursoVO.getTurno());
			curso.setDepartamento(cursoVO.getDepartamento());
			curso.setNomeCordenador(cursoVO.getNomeCordenador());
			curso.setQuantPeriodos(cursoVO.getQuantPeriodos());
			
			em.persist(curso);
			em.getTransaction().commit();
		}catch (Exception ex) {
			em.getTransaction().rollback();
		}
		
	}
	
	public void editar (CursoVO cursoVO) {
		EntityManager em = getEntityManager();

		try {
			em.getTransaction().begin();
			
			CursoVO curso = em.find(CursoVO.class, cursoVO.getIdCurso());
			curso.setNome(cursoVO.getNome());
			curso.setTurno(cursoVO.getTurno());
			curso.setDepartamento(cursoVO.getDepartamento());
			curso.setNomeCordenador(cursoVO.getNomeCordenador());
			curso.setQuantPeriodos(cursoVO.getQuantPeriodos());	
			
			em.getTransaction().commit();


		}catch (Exception ex) {
			em.getTransaction().rollback();
		}
	}
	
	public void apagar (CursoVO cursoVO) {
		EntityManager em = getEntityManager();

		try {
			em.getTransaction().begin();
			
			CursoVO curso = em.find(CursoVO.class, cursoVO.getIdCurso());
			em.remove(curso);

			
		}catch (Exception ex) {
			em.getTransaction().rollback();
		}
	}
	
	public CursoVO selecionar (int i) {
		EntityManager em = getEntityManager();

		em.getTransaction().begin();
		CursoVO curso = em.find(CursoVO.class, i);
		em.getTransaction();
		
		return curso;
	}
	
	public List <CursoVO> selecionarTudo () {
		EntityManager em = getEntityManager();

		List <CursoVO> lista = new ArrayList <CursoVO> ();
		em.getTransaction().begin();
		try {
			
			Query q = em.createQuery("select object (c) from CursoVO as c");
			lista = q.getResultList();
			
		}catch (Exception ex) {
			em.close();
		}
		
		return lista;
	}
}
