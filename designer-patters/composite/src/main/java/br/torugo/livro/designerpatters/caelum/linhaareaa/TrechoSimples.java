package br.torugo.livro.designerpatters.caelum.linhaareaa;

public class TrechoSimples implements TrechoAreo {
	
	private String origem;
	
	private String destino;
	
	private Double preco;
	
	public TrechoSimples(String origem, String destino, Double preco) {
		this.origem = origem;
		this.destino = destino;
		this.preco = preco;
	}

	@Override
	public String getOrigem() {
		return origem;
	}

	@Override
	public String getDestino() {
		return destino;
	}

	@Override
	public Double getPreco() {
		return preco;
	}

}
