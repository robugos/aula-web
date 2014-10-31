package br.com.aulaweb.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import br.com.aulaweb.dao.AulaDAO;
import br.com.aulaweb.dao.SalaDAO;
import br.com.aulaweb.vo.AulaVO;
import br.com.aulaweb.vo.DisciplinaVO;
import br.com.aulaweb.vo.SalaVO;

@ManagedBean(name = "aulaBean")
@SessionScoped
public class AulaBEAN {
	private AulaVO aulaVO = new AulaVO();
	private AulaDAO aulaDAO = new AulaDAO();
	private DataModel<AulaVO> aulas;
	private int disciplinaId;
	private int salaId;
	
	
	public void novaAula () {
		this.aulaVO = new AulaVO();
	}
	
	public void selecionarAula() {
		this.aulaVO = aulas.getRowData();
	}
	
	public void salvar () {
	
		try {
			DisciplinaVO disciplinaVO = new DisciplinaVO();
			disciplinaVO.setIdDisciplina(disciplinaId);
			SalaVO salaVO = new SalaVO();
			salaVO.setIdSala(salaId);
			
			aulaVO.setFkDisciplina(disciplinaVO);
			aulaVO.setFkSala(salaVO);
			aulaDAO.salvar(aulaVO);
			FacesMessage msg = new FacesMessage("Sucesso", "Nova aula cadastrada");
		    FacesContext.getCurrentInstance().addMessage(null, msg);
			novaAula();
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void editar() {
		
		try {
			aulaDAO.editar(aulaVO);
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void apagar () {
		
		try {
			aulaDAO.apagar(aulaVO);
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		
	}
	
	public DataModel<AulaVO> getAulas() {
		List <AulaVO> lista = aulaDAO.selecionarTudo();
		
		try {
			aulas = new ListDataModel<AulaVO>(lista);
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		
		return aulas;
	}

	public void setAulas(DataModel<AulaVO> aulas) {
		this.aulas = aulas;
	}
	

	public AulaVO getAulaVO() {
		return aulaVO;
	}

	public void setAulaVO(AulaVO aulaVO) {
		this.aulaVO = aulaVO;
	}

	/**
	 * @return the disciplinaId
	 */
	public int getDisciplinaId() {
		return disciplinaId;
	}

	/**
	 * @param disciplinaId the disciplinaId to set
	 */
	public void setDisciplinaId(int disciplinaId) {
		this.disciplinaId = disciplinaId;
	}
	

	/**
	 * @return the salaId
	 */
	public int getSalaId() {
		return salaId;
	}

	/**
	 * @param salaId the salaId to set
	 */
	public void setSalaId(int salaId) {
		this.salaId = salaId;
	}

	
}
