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

import br.com.aulaweb.dao.SalaDAO;
import br.com.aulaweb.vo.PredioVO;
import br.com.aulaweb.vo.SalaVO;


@ManagedBean(name = "salaBean")
@SessionScoped
public class SalaBEAN {
	private SalaVO salaVO = new SalaVO();
	private SalaDAO salaDAO = new SalaDAO();
	private DataModel<SalaVO> salas;
	private int idPredio;
	
	public void novaSala () {
		this.salaVO = new SalaVO();
	}
	
	public void selecionarSala() {
		this.salaVO = salas.getRowData();
	}
	
	public void salvar () {
	
		try {
			PredioVO predioVO = new PredioVO();
			predioVO.setIdPredio(idPredio);
			salaVO.setFkPredio(predioVO);
			salaDAO.salvar(salaVO);
			FacesMessage msg = new FacesMessage("Sucesso", "Nova sala adicionada");
		    FacesContext.getCurrentInstance().addMessage(null, msg);
		    novaSala();
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void editar() {
		
		try {
			PredioVO predioVO = new PredioVO();
			predioVO.setIdPredio(idPredio);
			salaVO.setFkPredio(predioVO);
			salaDAO.editar(salaVO);
			FacesMessage msg = new FacesMessage("Sucesso", "Sala editada");
		    FacesContext.getCurrentInstance().addMessage(null, msg);		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void apagar () {
		
		try {
			salaDAO.apagar(salaVO);
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		
	}
	
	
	
	public Collection<SelectItem> getListaSala () {
		Collection<SelectItem> lista = new ArrayList<SelectItem>();
		List <SalaVO> listaSala = salaDAO.selecionarTudo();
		
		for (int i = 0; i < listaSala.size(); i++) {
			lista.add(new SelectItem(listaSala.get(i).getIdSala(), listaSala.get(i).getNumero()));
		}
		
		return lista;
		
	}
	

	/**
	 * @return the salas
	 */
	public DataModel<SalaVO> getSalas() {
		List <SalaVO> lista = salaDAO.selecionarTudo();
		try {
			salas = new ListDataModel<SalaVO>(lista);
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return salas;
	}

	/**
	 * @param salas the salas to set
	 */
	public void setSalas(DataModel<SalaVO> salas) {
		this.salas = salas;
	}
	
	public Collection<SelectItem> getListaSalas () {
		SalaDAO salaDAO = new SalaDAO();
		Collection<SelectItem> lista = new ArrayList<SelectItem>();
		List <SalaVO> listaSalas = salaDAO.selecionarTudo();
		
		for (int i = 0; i < listaSalas.size(); i++) {
			lista.add(new SelectItem(listaSalas.get(i).getIdSala(), listaSalas.get(i).getNumero()+" - "+
					listaSalas.get(i).getFkPredio().getNome()));
		}
		
		return lista;
		
	}

	/**
	 * @return the salaVO
	 */
	public SalaVO getSalaVO() {
		return salaVO;
	}

	/**
	 * @param salaVO the salaVO to set
	 */
	public void setSalaVO(SalaVO salaVO) {
		this.salaVO = salaVO;
	}

	/**
	 * @return the idPredio
	 */
	public int getIdPredio() {
		return idPredio;
	}

	/**
	 * @param idPredio the idPredio to set
	 */
	public void setIdPredio(int idPredio) {
		this.idPredio = idPredio;
	}

	
}
