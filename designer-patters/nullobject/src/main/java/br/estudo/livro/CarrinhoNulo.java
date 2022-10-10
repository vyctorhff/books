package br.estudo.livro;

/**
 * O padrão Null Object propõe a criação de uma classe para representar
 * objetos nulos em uma aplicação. Essa classe deve estender a classe original e imple-
 * mentar seus métodos de forma a executar o comportamento esperado da aplicação
 * quando um valor nulo for recebido. Dessa forma, em vez de se retornar um valor
 * nulo, retorna-se uma instância dessa nova classe.
 */
public class CarrinhoNulo extends Carrinho {

	@Override
	public String getNomeUsuario() {
		return "";
	}
	
	@Override
	public Double getValor() {
		return 0.0;
	}
	
	@Override
	public int getTamanho() {
		return 0;
	}
}
