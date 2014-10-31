package br.com.aulaweb.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.aulaweb.vo.UsuarioVO;

public class UsuarioDAO extends Dao{
	
	public void salvar(UsuarioVO usuarioVO) {
		EntityManager em = getEntityManager();

		
		try {
			em.getTransaction().begin();
		
			UsuarioVO usuario = new UsuarioVO();
			usuario.setNome(usuarioVO.getNome());
			usuario.setEmail(usuarioVO.getEmail());
			usuario.setSenha(usuarioVO.getSenha());
		
			em.persist(usuario);
			em.getTransaction().commit();
		}catch (Exception ex) {
			em.getTransaction().rollback();
		}
		
	}

	public void editar (UsuarioVO usuarioVO) {
		EntityManager em = getEntityManager();

		
		try {
			em.getTransaction().begin();
			
			UsuarioVO usuario = em.find(UsuarioVO.class, usuarioVO.getIdUsuario());
			
			usuario.setNome(usuarioVO.getNome());
			usuario.setEmail(usuarioVO.getEmail());
			usuario.setSenha(usuarioVO.getSenha());
			
			em.getTransaction().commit();
			
		}catch (Exception ex) {
			em.getTransaction().rollback();
		}
		
	}

	public void apagar(UsuarioVO usuarioVO) {
		EntityManager em = getEntityManager();

		try {
			em.getTransaction().begin();
			UsuarioVO usuario = em.find(UsuarioVO.class, usuarioVO.getIdUsuario());
			em.remove(usuario);
		}catch (Exception ex) {
			em.getTransaction().rollback();
		}
	}

	public UsuarioVO selecionar(int id) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		UsuarioVO usuario = em.find(UsuarioVO.class, id);
		
		return usuario;
		
	}

	public List <UsuarioVO> selecionarTudo(UsuarioVO usuarioVO) {
		EntityManager em = getEntityManager();
		List <UsuarioVO> lista = new ArrayList<UsuarioVO>();
		try {
			Query q = em.createQuery("select object (u) from UsuarioVO as u");
			lista = q.getResultList();
		}catch (Exception ex) {
			em.close();
		}
		
		return lista;
	}



}
