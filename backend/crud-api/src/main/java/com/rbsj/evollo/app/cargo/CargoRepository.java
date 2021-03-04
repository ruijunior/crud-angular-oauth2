package com.rbsj.evollo.app.cargo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rbsj.evollo.app.empresa.Empresa;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
	
	List<Cargo> findByEmpresa(Empresa empresa);

}
