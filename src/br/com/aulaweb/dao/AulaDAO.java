package br.com.aulaweb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.aulaweb.vo.AulaVO;

public class AulaDAO extends Dao {
	
public void salvar (AulaVO aulaVO) {
	
	EntityManager em = getEntityManager();
	
	try {
		
		em.getTransaction().begin();
		
		AulaVO aula = new AulaVO();
		aula.setDiaAula(aulaVO.getDiaAula());
		aula.setHoraInicial(aulaVO.getHoraInicial());
		aula.setHoraFinal(aulaVO.getHoraInicial());
		aula.setData(aulaVO.getData());
		aula.setFkDisciplina(aulaVO.getFkDisciplina());
		aula.setFkSala(aulaVO.getFkSala());
		
		em.persist(aula);
		em.getTransaction().commit();
		
	}catch (Exception ex) {
		em.getTransaction().rollback();
		
	}
		
	}

	public void editar (AulaVO aulaVO) {
		
		EntityManager em = getEntityManager();

		try {
			
			em.getTransaction().begin();
			
			AulaVO aula = em.find(AulaVO.class, aulaVO.getIdAula());
			aula.setDiaAula(aulaVO.getDiaAula());
			aula.setHoraInicial(aulaVO.getHoraInicial());
			aula.setHoraFinal(aulaVO.getHoraInicial());
			aula.setData(aulaVO.getData());
			aula.setFkDisciplina(aulaVO.getFkDisciplina());
			aula.setFkSala(aulaVO.getFkSala());
			
			em.getTransaction().commit();
			
		}catch (Exception ex) {
			em.getTransaction().rollback();
			
		}
		
	}
	
	public void apagar (AulaVO aulaVO) {
		
		EntityManager em = getEntityManager();
		
		try {
			em.getTransaction().begin();
			AulaVO aula = em.find(AulaVO.class, aulaVO.getIdAula());
			em.remove(aula);
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public AulaVO selecionar (int id) {
		
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		AulaVO AulaVO = em.find(AulaVO.class, id);
		return AulaVO;
	}
	
	public List <AulaVO> selecionarTudo () {
	
		EntityManager em = getEntityManager();
		
		List <AulaVO> lista = new ArrayList<AulaVO>();
		try {
			Query q = em.createQuery("select object (a) from AulaVO as a");
			lista = q.getResultList();
		}catch (Exception ex) {
			em.close();
		}
		
		return lista;
		
	}
	
	

}
