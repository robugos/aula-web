package br.com.aulaweb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.aulaweb.vo.SalaVO;

public class SalaDAO extends Dao{
	
	public void salvar (SalaVO salaVO) {
		EntityManager em = getEntityManager();
		
		try {
			em.getTransaction().begin();
			SalaVO sala = new SalaVO();
			sala.setNumero(salaVO.getNumero());
			sala.setAndar(salaVO.getAndar());
			sala.setFkPredio(salaVO.getFkPredio());
			sala.setObservacao(salaVO.getObservacao());
			
			em.persist(sala);
			em.getTransaction().commit();
			
		}catch (Exception ex) {
			em.getTransaction().rollback();
		}
	}

	public void editar (SalaVO salaVO) {
		EntityManager em = getEntityManager();

		try {
			em.getTransaction().begin();
			SalaVO sala = em.find(SalaVO.class, salaVO.getIdSala());
			sala.setNumero(salaVO.getNumero());
			sala.setAndar(salaVO.getAndar());
			sala.setFkPredio(salaVO.getFkPredio());
			sala.setObservacao(salaVO.getObservacao());

			
			em.getTransaction().commit();
		}catch (Exception ex) {
			em.getTransaction().rollback();
			
		}
	}
	
	public void apagar (SalaVO salaVO) {
		EntityManager em = getEntityManager();
		
		try {
		em.getTransaction().begin();
		SalaVO sala = em.find(SalaVO.class, salaVO.getIdSala());
		em.remove(sala);
		}catch (Exception ex) {
			
		}
	}
	
	public SalaVO selecionar (int id) {
		EntityManager em = getEntityManager();

		em.getTransaction().begin();
		SalaVO salaVO = em.find(SalaVO.class, id);
		return salaVO;
	}

	public List <SalaVO> selecionarTudo () {
		EntityManager em = getEntityManager();

		List <SalaVO> lista = new ArrayList<SalaVO>();
		try {
			Query q = em.createQuery("select object (s) from SalaVO as s");
			lista = q.getResultList();
		}catch (Exception ex) {
			em.close();
		}
		
		return lista;
		
	}

}
