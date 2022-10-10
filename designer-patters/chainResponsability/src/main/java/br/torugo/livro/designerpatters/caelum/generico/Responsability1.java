package br.torugo.livro.designerpatters.caelum.generico;

/**
 * Created by torugo on 07/04/17.
 */
public class Responsability1 extends Chain {

	public Responsability1(Chain proximo) {
		super(proximo);
	}

	@Override
	public String method(int number) {
		if (number < 25) {
			return "e menor que 25";
		}

		return null;
	}
}
