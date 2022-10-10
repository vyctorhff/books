package br.torugo.livro.designerpatters.caelum.factoryMethod;

/**
 * Created by torugo on 14/04/17.
 */
public class FactoryMethod {

	private Integer valor;

	private Boolean logico;

	/**
	 * tem desvantagens
	 */
	public FactoryMethod() {
	}

	public static FactoryMethod getInstance() {
		return new FactoryMethod();
	}

	public static FactoryMethod getInstanceDefault() {
		return getInstance(2, Boolean.TRUE);
	}

	public static FactoryMethod getInstance(Integer valor, Boolean logico) {
		FactoryMethod factory = new FactoryMethod();
		factory.setLogico(logico);
		factory.setValor(valor);
		return factory;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Boolean getLogico() {
		return logico;
	}

	public void setLogico(Boolean logico) {
		this.logico = logico;
	}
}
