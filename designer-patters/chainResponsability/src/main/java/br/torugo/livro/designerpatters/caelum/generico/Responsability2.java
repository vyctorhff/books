package br.torugo.livro.designerpatters.caelum.generico;

/**
 * Created by torugo on 07/04/17.
 */
public class Responsability2 extends Chain {

	public Responsability2(Chain proximo) {
		super(proximo);
	}

	@Override
	public String method(int number) {
		if (number > 25) {
			return "e maior que 25";
		}
		return null;
	}
}
