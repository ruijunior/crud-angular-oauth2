package com.rbsj.evollo.app.funcionario;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.domain.AbstractAggregateRoot;

import com.rbsj.evollo.app.cargo.Cargo;
import com.rbsj.evollo.app.empresa.Empresa;
import com.rbsj.evollo.app.funcionario.events.FuncionarioCriadoEvent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "tb_funcionario")
public class Funcionario extends AbstractAggregateRoot<Funcionario>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(nullable = false, length = 150)
	private String nome;
	
	@Email
	@Column(nullable = false)
	private String email;
	
	@CPF
	@Column(nullable = false)
	private String cpf;
	
	@PositiveOrZero
	private BigDecimal salario;
	
	@ManyToOne()
	@JoinColumn(nullable = false)
	private Cargo cargo;
	
	@ManyToOne()
	@JoinColumn(nullable = false)
	private Empresa empresa;
	
	public void criar() {
		registerEvent(new FuncionarioCriadoEvent(this));
	}

}
