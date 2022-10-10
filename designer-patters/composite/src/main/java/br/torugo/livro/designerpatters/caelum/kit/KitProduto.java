package br.torugo.livro.designerpatters.caelum.kit;

import java.util.List;

public class KitProduto implements Preco {

	private List<Preco> lista;

	public KitProduto(List<Preco> lista) {
		this.lista = lista;
	}
	
	@Override
	public Double getPreco() {
		return lista.stream()
				.mapToDouble(v -> v.getPreco())
				.sum();
	}

	
}
