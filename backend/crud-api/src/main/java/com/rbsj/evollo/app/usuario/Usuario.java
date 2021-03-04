package com.rbsj.evollo.app.usuario;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.domain.AbstractAggregateRoot;

import com.rbsj.evollo.app.empresa.Empresa;
import com.rbsj.evollo.app.usuario.events.UsuarioCriadoEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "tb_usuario")
public class Usuario extends AbstractAggregateRoot<Usuario>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(unique = true)
	private String email;
	
	private String senha;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(nullable = false)
	private Empresa empresa;
	
	@ManyToMany
	@JoinTable(name = "tb_usuario_papel",
		joinColumns = @JoinColumn(name = "usuario_id"),
		inverseJoinColumns = @JoinColumn(name="papel_id")
	)
	private Set<Papel> papeis = new HashSet<>();
	
	@Transient
	private Boolean cadastroUsuarioPeloFuncionario = Boolean.FALSE;
	
	public boolean senhaCoincide(String senha) {
		return getSenha().equals(senha);
	}
	
	public boolean isSenhaNaoCoincide(String senha) {
		return !senhaCoincide(senha);
	}
	
	public void criar() {
		registerEvent(new UsuarioCriadoEvent(this));
	}

}
