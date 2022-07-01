package br.edu.uniceplac.compra.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uniceplac.compra.entidade.CarrinhoEntity;
import br.edu.uniceplac.compra.entidade.ProdutoEntity;
import br.edu.uniceplac.compra.entidade.UsuarioEntity;
import br.edu.uniceplac.compra.pojo.Carrinho;
import br.edu.uniceplac.compra.pojo.Produto;
import br.edu.uniceplac.compra.repository.CarrinhoRepository;

@RestController
@RequestMapping("/carrinhos")

public class CarrinhoController {

	private final CarrinhoRepository carrinhoRepository;

	public CarrinhoController(CarrinhoRepository carrinhoRepository) {
		this.carrinhoRepository = carrinhoRepository;
	}
	
	@PostMapping
	public Carrinho create (@RequestBody Carrinho carrinho){
		CarrinhoEntity entity = new CarrinhoEntity();
		
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setNome(carrinho.getUsuario().getNome());
		usuarioEntity.setSenha(carrinho.getUsuario().getSenha());
		usuarioEntity.setId(carrinho.getUsuario().getId());
		entity.setUsuario(usuarioEntity);
		List<ProdutoEntity> listaEntity = new ArrayList<>();
		
		for(Produto produto:carrinho.getListaProduto()){
			
			ProdutoEntity produtoEntity = new ProdutoEntity();
			produtoEntity.setId(produto.getId());
			produtoEntity.setNome(produto.getNome());
			produtoEntity.setCategoria(produto.getCategoria());
			produtoEntity.setValor(produto.getValor());
			
		}
		
		entity.setListaProduto(listaEntity);
		entity = carrinhoRepository.save(entity);
		carrinho.setId(entity.getId());
		
		return carrinho;
		
	}
	
	
	
}
