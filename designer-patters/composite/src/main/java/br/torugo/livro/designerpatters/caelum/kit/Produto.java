package br.torugo.livro.designerpatters.caelum.kit;

public class Produto implements Preco {

	private Double preco;
	
	public Produto(Double preco) {
		this.preco = preco;
	}
	
	@Override
	public Double getPreco() {
		return preco;
	}

}
