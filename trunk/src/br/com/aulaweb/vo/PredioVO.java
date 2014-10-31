package br.com.aulaweb.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "predio")
public class PredioVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int idPredio;
	@Column
	private String nome;
	@Column
	private int quantAndares;
	@Column
	private String observacao;
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
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the quantAndares
	 */
	public int getQuantAndares() {
		return quantAndares;
	}
	/**
	 * @param quantAndares the quantAndares to set
	 */
	public void setQuantAndares(int quantAndares) {
		this.quantAndares = quantAndares;
	}
	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}
	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}
