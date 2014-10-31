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

import br.com.aulaweb.dao.DisciplinaDAO;
import br.com.aulaweb.vo.CursoVO;
import br.com.aulaweb.vo.DisciplinaVO;

@ManagedBean(name = "disciplinaBean")
@SessionScoped
public class DisciplinaBEAN {
	DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
	private DisciplinaVO disciplinaVO = new DisciplinaVO();
	DataModel<DisciplinaVO> disciplinas;
	private int cursoId;
	
	
	public void novaDisciplina () {
		disciplinaVO = new DisciplinaVO();
	}
	
	public void selecionarDisciplina () {
		disciplinaVO = disciplinas.getRowData();
	}
	
	public void salvar () {
		
		try {
			CursoVO cursoVO = new CursoVO();
			cursoVO.setIdCurso(cursoId);
			disciplinaVO.setFkCurso(cursoVO);
			disciplinaDAO.salvar(disciplinaVO);
			FacesMessage msg = new FacesMessage("Sucesso", "Nova disciplina cadastrada");
		    FacesContext.getCurrentInstance().addMessage(null, msg);
			novaDisciplina();
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	
	
	public void editar () {
		
		try {
			CursoVO cursoVO = new CursoVO();
			cursoVO.setIdCurso(cursoId);
			disciplinaVO.setFkCurso(cursoVO);
			disciplinaDAO.editar(disciplinaVO);
			FacesMessage msg = new FacesMessage("Sucesso", "Disciplina editada");
		    FacesContext.getCurrentInstance().addMessage(null, msg);
			
		
			
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void apagar () {
		
		try {
			
			disciplinaDAO.apagar(disciplinaVO);
			
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	

	public DataModel<DisciplinaVO> getDisciplinas() {
		
		List <DisciplinaVO> lista = disciplinaDAO.selecionarTudo();
		try {
			disciplinas = new ListDataModel<DisciplinaVO>(lista);
		}catch (Exception ex){
			throw new RuntimeException(ex);

		}		
		return disciplinas;
	}
	

	public void setDisciplinas(DataModel<DisciplinaVO> disciplinas) {
		this.disciplinas = disciplinas;
	}

	/**
	 * @return the disciplinaVO
	 */
	public DisciplinaVO getDisciplinaVO() {
		return disciplinaVO;
	}

	/**
	 * @param disciplinaVO the disciplinaVO to set
	 */
	public void setDisciplinaVO(DisciplinaVO disciplinaVO) {
		this.disciplinaVO = disciplinaVO;
	}
	
	public Collection<SelectItem> getListaDisciplinas () {
		Collection<SelectItem> lista = new ArrayList<SelectItem>();
		List <DisciplinaVO> listaDisciplinas = disciplinaDAO.selecionarTudo();
		
		for (int i = 0; i < listaDisciplinas.size(); i++) {
			lista.add(new SelectItem(listaDisciplinas.get(i).getIdDisciplina(), listaDisciplinas.get(i).getNome()));
		}
		
		return lista;
	}
	/**
	 * @return the cursoId
	 */
	public int getCursoId() {
		return cursoId;
	}

	/**
	 * @param cursoId the cursoId to set
	 */
	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}



}
