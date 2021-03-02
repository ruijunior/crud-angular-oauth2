package com.rbsj.evollo.app.funcionario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rbsj.evollo.app.empresa.Empresa;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	List<Funcionario> findByEmpresa(Empresa empresa);

}
