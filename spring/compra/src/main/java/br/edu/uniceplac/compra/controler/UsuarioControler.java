package br.edu.uniceplac.compra.controler;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uniceplac.compra.entidade.UsuarioEntity;
import br.edu.uniceplac.compra.pojo.Usuario;
import br.edu.uniceplac.compra.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")

public class UsuarioControler {
	
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioControler(UsuarioRepository usuarioRepository){
		
		this.usuarioRepository = usuarioRepository;
		
	}
	
	@PostMapping
	
	public Usuario create(@RequestBody Usuario usuario){
		
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setNome(usuario.getNome());
		usuarioEntity.setSenha(usuario.getSenha());
		usuarioRepository.save(usuarioEntity);
		usuario.setId(usuarioEntity.getId());
		
		return usuario;
	}
	
}
