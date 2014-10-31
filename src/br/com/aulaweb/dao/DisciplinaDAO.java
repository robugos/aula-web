package br.com.aulaweb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.aulaweb.vo.DisciplinaVO;

public class DisciplinaDAO extends Dao{
	
	public void salvar (DisciplinaVO disciplinaVO) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			DisciplinaVO disciplina = new DisciplinaVO();
			
			disciplina.setNome(disciplinaVO.getNome());
			disciplina.setProfessor(disciplinaVO.getProfessor());
			disciplina.setCargaHoraria(disciplinaVO.getCargaHoraria());
			disciplina.setTipoDisciplina(disciplinaVO.getTipoDisciplina());
			disciplina.setFkCurso(disciplinaVO.getFkCurso());
			
			em.persist(disciplina);
			em.getTransaction().commit();
			
		}catch (Exception ex) {
			em.getTransaction().rollback();
		}
	}

	public void editar (DisciplinaVO disciplinaVO) {
		EntityManager em = getEntityManager();
		
		try {
			em.getTransaction().begin();
			DisciplinaVO disciplina = em.find(DisciplinaVO.class, disciplinaVO.getIdDisciplina());
		
			disciplina.setNome(disciplinaVO.getNome());
			disciplina.setProfessor(disciplinaVO.getProfessor());
			disciplina.setCargaHoraria(disciplinaVO.getCargaHoraria());
			disciplina.setTipoDisciplina(disciplinaVO.getTipoDisciplina());
			disciplina.setFkCurso(disciplinaVO.getFkCurso());
		
		em.getTransaction().commit();
	}catch (Exception ex) {
		em.getTransaction().rollback();
		}
	}
	
	public void apagar (DisciplinaVO disciplinaVO) {
		try {
			EntityManager em = getEntityManager();

			DisciplinaVO disciplina = em.find(DisciplinaVO.class, disciplinaVO.getIdDisciplina());
			getEntityManager().remove(disciplina);
	}catch (Exception ex) {
		throw new RuntimeException(ex);
		}
	}
	
	public DisciplinaVO selecionar (int id) {
		EntityManager em = getEntityManager();
		
		DisciplinaVO disciplinaVO = em.find(DisciplinaVO.class, id);
		return disciplinaVO;
	}
	
	public List <DisciplinaVO> selecionarTudo () {
		EntityManager em = getEntityManager();

		List <DisciplinaVO> lista = new ArrayList<DisciplinaVO>();
		try {
			Query q = em.createQuery("select object (d) from DisciplinaVO as d");
			lista = q.getResultList();
		}catch (Exception ex) {
			em.close();
		}
		
		return lista;
		
	}
}
