package com.rbsj.evollo.app.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;
import org.springframework.stereotype.Service;

import com.rbsj.evollo.app.empresa.Empresa;
import com.rbsj.evollo.app.empresa.EmpresaService;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	public Usuario salvar(Usuario usuario) {
		if(usuario.getEmpresa().getId() != null) {
			Long empresaId = usuario.getEmpresa().getId();
			Empresa empresa = this.empresaService.buscar(empresaId);
			usuario.setEmpresa(empresa);			
		}
		
		if (usuario.getCadastroUsuarioPeloFuncionario()) {
			usuario.criar();
		}
		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscarPorEmail(String email) {
		return this.usuarioRepository.findByEmail(email).get();
	}
	
	public String generatePassword() {
		return new RandomValueStringGenerator(8).generate(); 
	}

}
