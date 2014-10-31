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

import br.com.aulaweb.dao.PredioDAO;
import br.com.aulaweb.vo.PredioVO;

@ManagedBean(name = "predioBean")
@SessionScoped
public class PredioBEAN {
	PredioDAO predioDAO = new PredioDAO();
	PredioVO predioVO = new PredioVO();
	DataModel<PredioVO> predios;

	
	public void novoPredio () {
		predioVO = new PredioVO();
	}
	
	public void selecionarPredio () {
		predioVO = predios.getRowData();
	}
	
	public void salvar () {
		
		try {
			
			predioDAO.salvar(predioVO);
			FacesMessage msg = new FacesMessage("Sucesso", "Novo prédio cadastrado");
		    FacesContext.getCurrentInstance().addMessage(null, msg);
		    novoPredio();
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	
	
	public void editar () {
		
		try {
			
			predioDAO.editar(predioVO);
			FacesMessage msg = new FacesMessage("Sucesso", "Prédio editado");
		    FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void apagar () {
		
		try {
			
			predioDAO.apagar(predioVO);
			
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public PredioVO getPredioVO() {
		return predioVO;
	}

	public void setPredioVO(PredioVO predioVO) {
		this.predioVO = predioVO;
	}

	public DataModel<PredioVO> getPredios() {
		List <PredioVO> lista = predioDAO.selecionarTudo();

		try {
			predios = new ListDataModel<PredioVO>(lista);
		}catch (Exception ex) {
			
		}
		return predios;
	}
	
	public Collection<SelectItem> getListaPredios () {
		Collection<SelectItem> lista = new ArrayList<SelectItem>();
		List <PredioVO> listaPredios = predioDAO.selecionarTudo();
		
		for (int i = 0; i < listaPredios.size(); i++) {
			lista.add(new SelectItem(listaPredios.get(i).getIdPredio(), listaPredios.get(i).getNome()));
			
		}
		
		return lista;
	}

	public void setPredios(DataModel<PredioVO> predios) {
		this.predios = predios;
	}
	

	



}
