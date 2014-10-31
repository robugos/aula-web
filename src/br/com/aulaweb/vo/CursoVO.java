package br.com.aulaweb.vo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "curso")
public class CursoVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int idCurso;
	@Column
	private String nome;
	@Column
	private String turno;
	@Column
	private String departamento;
	@Column
	private String nomeCordenador;
	@Column
	private int quantPeriodos;
	
	@OneToMany(mappedBy = "fkCurso", targetEntity = DisciplinaVO.class, 
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	
	private Set <DisciplinaVO> disciplinas;

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getNomeCordenador() {
		return nomeCordenador;
	}

	public void setNomeCordenador(String nomeCordenador) {
		this.nomeCordenador = nomeCordenador;
	}

	public int getQuantPeriodos() {
		return quantPeriodos;
	}

	public void setQuantPeriodos(int quantPeriodos) {
		this.quantPeriodos = quantPeriodos;
	}

	public Set<DisciplinaVO> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<DisciplinaVO> disciplinas) {
		this.disciplinas = disciplinas;
	}


}
