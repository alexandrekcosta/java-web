package br.edu.uniceplac.compra.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uniceplac.compra.entidade.ProdutoEntity;
import br.edu.uniceplac.compra.entidade.UsuarioEntity;
import br.edu.uniceplac.compra.pojo.Produto;
import br.edu.uniceplac.compra.pojo.Usuario;
import br.edu.uniceplac.compra.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {
	
	private final ProdutoRepository produtoRepository;

	public ProdutoController(ProdutoRepository produtoRepository) {
		
		
		this.produtoRepository = produtoRepository;
	}
	
	@PostMapping
	
public Produto create(@RequestBody Produto produto){
		
		ProdutoEntity produtoEntity = new ProdutoEntity();
		produtoEntity.setNome(produto.getNome());
		produtoEntity.setCategoria(produto.getCategoria());
		produtoEntity.setValor(produto.getValor());
		produtoRepository.save(produtoEntity);
		produto.setId(produtoEntity.getId());
		
		return produto;
	}
	
	@GetMapping(path = "{id}")
	public Produto get(@PathVariable Long id){
		
		ProdutoEntity entity = produtoRepository.getById(id);
		Produto produto = new Produto();
		produto.setId(entity.getId());
		produto.setNome(entity.getNome());
		produto.setCategoria(entity.getCategoria());
		produto.setValor(entity.getValor());
		
		return produto;
		
		
		}
	
	@PutMapping
	public Produto update(@RequestBody Produto produto){
		
			ProdutoEntity produtoEntity = new ProdutoEntity();
			produtoEntity.setId(produto.getId());
			produtoEntity.setNome(produto.getNome());
			produtoEntity.setCategoria(produto.getCategoria());
			produtoEntity.setValor(produto.getValor());
			produtoEntity = produtoRepository.save(produtoEntity);
		
			return produto;
		}
	
	@DeleteMapping(path = "{id}")
	public void delete(@PathVariable Long id){
		
		produtoRepository.deleteById(id);

	
}
	
	@GetMapping 
	public List<Produto> listAll(){
		
		List<ProdutoEntity> listEntity = produtoRepository.findAll();
		List<Produto> listPojo = new ArrayList<>();
		
		for (ProdutoEntity entity:listEntity){
			
			Produto produto = new Produto();
			produto.setId(entity.getId());
			produto.setNome(entity.getNome());
			produto.setCategoria(entity.getCategoria());
			produto.setValor(entity.getValor());
			listPojo.add(produto);
		}
		
		return listPojo;
	
	
	
	

	}
}
