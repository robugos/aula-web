package br.com.aulaweb.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aula")
public class AulaVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int idAula;
	
	@Column
	private String diaAula;
	@Column
	private Date horaInicial;
	@Column
	private Date horaFinal;
	@Column
	private Date data;
	
	@ManyToOne()
	@JoinColumn(name = "idDisciplina")
	private DisciplinaVO fkDisciplina;
	
	@ManyToOne()
	@JoinColumn(name = "idSala")
	private SalaVO fkSala;

	public int getIdAula() {
		return idAula;
	}

	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}

	public String getDiaAula() {
		return diaAula;
	}

	public void setDiaAula(String diaAula) {
		this.diaAula = diaAula;
	}

	public Date getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Date horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public DisciplinaVO getFkDisciplina() {
		return fkDisciplina;
	}

	public void setFkDisciplina(DisciplinaVO fkDisciplina) {
		this.fkDisciplina = fkDisciplina;
	}

	public SalaVO getFkSala() {
		return fkSala;
	}

	public void setFkSala(SalaVO fkSala) {
		this.fkSala = fkSala;
	}
	
}
