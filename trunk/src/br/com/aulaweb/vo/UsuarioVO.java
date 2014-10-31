package br.com.aulaweb.vo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int idUsuario;
	@Column
	private String nome;
	@Column
	private String email;
	@Column
	private String senha;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "disciplinaFavorita" ,
	joinColumns = @JoinColumn(name = "fkUsuario"), 
	inverseJoinColumns = @JoinColumn(name = "fkDisciplina"))
	private Collection <DisciplinaVO> disciplinasFavoritas;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable (name = "aulaFavorita",
	joinColumns = @JoinColumn(name = "fkUsuario"), 
	inverseJoinColumns = @JoinColumn(name = "fkDisciplina"))
	private Collection  <AulaVO> aulasFavoritas;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "predioFavorito",
	joinColumns = @JoinColumn(name = "fkUsuario"), 
	inverseJoinColumns = @JoinColumn(name = "fkPredio"))
	private Collection <PredioVO> prediosFavoritos;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "salaFavorita",
	joinColumns = @JoinColumn(name = "fkUsuario"),
	inverseJoinColumns = @JoinColumn(name = "fkSala"))
	private Collection <SalaVO> salasFavoritas;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
