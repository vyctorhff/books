package br.torugo.livro.designerpatters.caelum.builder;

import java.time.LocalDateTime;

/**
 * Created by torugo on 14/04/17.
 */
public class Builder {

	private Pessoa pessoa;

	public Builder() {
		pessoa = new Pessoa();
	}

	/**
	 * Usando principios da interface fluente
	 * <p>
	 * O termo interface fluente foi cunhado por Martin Fowler e Erick Evans [14],
	 * como uma forma de descrever um estilo de construção de interfaces. A ideia é dar o
	 * nome dos métodos da classe de forma que o código pareça uma frase em linguagem natural.
	 */

	public Builder chamada(String nome) {
		pessoa.setNome(nome);
		return this;
	}

	public Builder nascidaEm(LocalDateTime data) {
		pessoa.setDataNascimento(data);
		return this;
	}

	public Builder noCargo(String cargo) {
		pessoa.setCargo(cargo);
		return this;
	}
}
