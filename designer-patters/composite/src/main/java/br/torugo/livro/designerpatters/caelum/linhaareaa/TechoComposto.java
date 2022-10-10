package br.torugo.livro.designerpatters.caelum.linhaareaa;

public class TechoComposto implements TrechoAreo {
	
	private TrechoAreo primeiro;
	
	private TrechoAreo segundo;
	
	private Double taxaArea;
	
	public TechoComposto(TrechoAreo primeiro, TrechoAreo segundo, Double taxa) {
		this.primeiro = primeiro;
		this.segundo = segundo;
		this.taxaArea = taxa;
		
		if (primeiro.getDestino().equals(segundo.getDestino())) {
			throw new IllegalArgumentException("O destino não pode ser igual ao destino");
		}
	}

	@Override
	public String getOrigem() {
		return primeiro.getOrigem();
	}

	@Override
	public String getDestino() {
		return segundo.getDestino();
	}

	@Override
	public Double getPreco() {
		return primeiro.getPreco() + segundo.getPreco() + taxaArea;
	}

}
