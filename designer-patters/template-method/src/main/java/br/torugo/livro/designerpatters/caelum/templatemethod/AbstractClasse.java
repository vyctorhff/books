package br.torugo.livro.designerpatters.caelum.templatemethod;

public abstract class AbstractClasse {

	public void method() {
		// faz precondições
		this.template1();
		
		// faz outra operações
		
		this.template2();
		
		// faz pos condições
	}

	public abstract void template1();
	
	public abstract void template2();
}
