package br.com.aulaweb.vo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sala")
public class SalaVO {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column
	private int idSala;
	
	@Column
	private String numero;
	
	@Column
	private String andar;
	
	@Column
	private String observacao;
	
	@ManyToOne()
	@JoinColumn(name = "idPredio")
	private PredioVO fkPredio;
	
	@OneToMany(mappedBy = "fkSala", targetEntity = AulaVO.class, 
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set <AulaVO> aulas;

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}



	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}

	public PredioVO getFkPredio() {
		return fkPredio;
	}

	public void setFkPredio(PredioVO fkPredio) {
		this.fkPredio = fkPredio;
	}

	public Set<AulaVO> getAulas() {
		return aulas;
	}

	public void setAulas(Set<AulaVO> aulas) {
		this.aulas = aulas;
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

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
