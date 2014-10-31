package br.com.aulaweb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.aulaweb.vo.PredioVO;

public class PredioDAO extends Dao{
	
	
	public void salvar (PredioVO predioVO) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			
			PredioVO predio = new PredioVO();
			predio.setNome(predioVO.getNome());
			predio.setQuantAndares(predioVO.getQuantAndares());
			predio.setObservacao(predioVO.getObservacao());
			
			em.persist(predio);
			em.getTransaction().commit();
		}catch (Exception ex) {
			em.getTransaction().rollback();
		}
	}
	
	public void editar (PredioVO predioVO) {
		EntityManager em = getEntityManager();

		try {
			em.getTransaction().begin();
		
			PredioVO predio = em.find(PredioVO.class, predioVO.getIdPredio());
			predio.setNome(predioVO.getNome());
			predio.setQuantAndares(predioVO.getQuantAndares());
			predio.setObservacao(predioVO.getObservacao());
			
			em.getTransaction().commit();
		
	}catch (Exception ex) {
		em.getTransaction().rollback();
	}
		
	}

	public void apagar(PredioVO predioVO) {
		EntityManager em = getEntityManager();
		
		try {
			em.getTransaction().begin();
			PredioVO predio = em.find(PredioVO.class, predioVO.getIdPredio());
			em.remove(predio);
		}catch (Exception ex) {
			throw new RuntimeException();
		}
	}

	public PredioVO selecionar(int id) {
		EntityManager em = getEntityManager();

		em.getTransaction().begin();
		PredioVO predio = em.find(PredioVO.class, id);
		return predio;
		
	}

	public List <PredioVO> selecionarTudo() {
		EntityManager em = getEntityManager();

		List <PredioVO> lista = new ArrayList<PredioVO>();
		try {
			Query q = em.createQuery("select object (p) from PredioVO as p");
			lista = q.getResultList();
		}catch (Exception ex) {
			em.close();
		}
		
		return lista;
	}




}
