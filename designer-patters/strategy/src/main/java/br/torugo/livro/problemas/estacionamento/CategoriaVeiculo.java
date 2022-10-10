package br.torugo.livro.problemas.estacionamento;

import java.io.Serializable;

public class CategoriaVeiculo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private CategoriaVeiculoEnum categoria;

	public CategoriaVeiculo(CategoriaVeiculoEnum categoria) {
		this.categoria = categoria;
	}

	public CategoriaVeiculoEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaVeiculoEnum categoria) {
		this.categoria = categoria;
	}
	
}
