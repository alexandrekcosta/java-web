package br.edu.uniceplac.compra.entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.edu.uniceplac.compra.pojo.Produto;
import br.edu.uniceplac.compra.pojo.Usuario;


@Entity
public class CarrinhoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private UsuarioEntity usuario;
	
	@ManyToMany
	private List<ProdutoEntity> listaProduto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public List<ProdutoEntity> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<ProdutoEntity> listaProduto) {
		this.listaProduto = listaProduto;
	}
	
	
	

}
