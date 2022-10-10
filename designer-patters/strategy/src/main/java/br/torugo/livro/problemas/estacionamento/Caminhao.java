package br.torugo.livro.problemas.estacionamento;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.base.MoreObjects;

public class Caminhao extends Veiculo {

	private static final long serialVersionUID = 2983620183478441286L;
	
	private double peso;
	
	private int numeroEixos;
	
	public Caminhao(String nome, CategoriaVeiculo categoriaVeiculo) {
		super(nome, categoriaVeiculo);
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getNumeroEixos() {
		return numeroEixos;
	}

	public void setNumeroEixos(int numeroEixos) {
		this.numeroEixos = numeroEixos;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Caminhao) {
			Caminhao t = (Caminhao) obj;
			
			return new EqualsBuilder()
					.append(peso, t.getPeso())
					.append(numeroEixos, t.getNumeroEixos())
					.build();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(peso)
				.append(numeroEixos)
				.build();
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Caminhao.class)
				.add("peso", peso)
				.add("numeroEixos", numeroEixos)
				.toString();
	}

}
