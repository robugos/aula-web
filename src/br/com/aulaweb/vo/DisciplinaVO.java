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
@Table(name = "disciplina")
public class DisciplinaVO {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int idDisciplina;
	
	@Column
	private String nome;
	
	@Column
	private String professor;
	
	@Column
	private String cargaHoraria;
	
	@Column
	private String tipoDisciplina;
	
	@ManyToOne()
	@JoinColumn(name = "idCurso")
	private CursoVO fkCurso;
	
	@OneToMany(mappedBy = "fkDisciplina", targetEntity = AulaVO.class,
			cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set <AulaVO> aulas;

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getTipoDisciplina() {
		return tipoDisciplina;
	}

	public void setTipoDisciplina(String tipoDisciplina) {
		this.tipoDisciplina = tipoDisciplina;
	}

	public CursoVO getFkCurso() {
		return fkCurso;
	}

	public void setFkCurso(CursoVO fkCurso) {
		this.fkCurso = fkCurso;
	}

	
}
