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

import br.com.aulaweb.dao.CursoDAO;
import br.com.aulaweb.vo.CursoVO;


@ManagedBean(name = "cursoBean")
@SessionScoped
public class CursoBEAN {
	CursoDAO cursoDAO = new CursoDAO();
	DataModel<CursoVO> cursos;
	CursoVO cursoVO = new CursoVO();
	
	public void novoCurso () {
		cursoVO = new CursoVO();
	}
	
	public void selecionarCurso () {
		cursoVO = cursos.getRowData();
	}
	
	public void salvar () {
		
		try {
			cursoDAO.salvar(cursoVO);
			FacesMessage msg = new FacesMessage("Sucesso", "Novo curso cadastrado");
		    FacesContext.getCurrentInstance().addMessage(null, msg);
		    novoCurso();
		}catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}
	
	
	
	public void editar () {
		
		try {
			
			cursoDAO.editar(cursoVO);
			FacesMessage msg = new FacesMessage("Sucesso", "Curso editado");
		    FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void apagar () {
		
		try {
			cursoDAO.apagar(cursoVO);
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	
	public DataModel<CursoVO> getCursos() {
		
		List <CursoVO> lista = cursoDAO.selecionarTudo();
		
		try {
			cursos = new ListDataModel<CursoVO>(lista);
		}catch (Exception ex){
			throw new RuntimeException(ex);
		}		
		return cursos;
	}
	
	public void setCursos(DataModel<CursoVO> cursos) {
		this.cursos = cursos;
	}

	public Collection <SelectItem> getListaCursos () {
		Collection <SelectItem> lista = new ArrayList<SelectItem>();
		List <CursoVO> listaCursos = cursoDAO.selecionarTudo();
		
		for (int i = 0; i < listaCursos.size(); i++) {
			lista.add(new SelectItem(listaCursos.get(i).getIdCurso(), listaCursos.get(i).getNome()));
		}
		
		return lista;
	}
	
	public CursoVO getCursoVO() {
		return cursoVO;
	}

	/**
	 * @param cursoVO the cursoVO to set
	 */
	public void setCursoVO(CursoVO cursoVO) {
		this.cursoVO = cursoVO;
	}


	
}
