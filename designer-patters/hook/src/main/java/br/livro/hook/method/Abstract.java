package br.livro.hook.method;

public abstract class Abstract {

	public void method() {
		// chamada ao metodo gancho
		this.hookmethod();
	}

	public abstract void hookmethod();
	
}
