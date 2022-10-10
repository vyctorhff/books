package br.torugo.livro.designerpatters.caelum.generico;

/**
 * Created by torugo on 07/04/17.
 */
public class ResponsabilityNull extends Chain {

	public ResponsabilityNull() {
		super(null);
	}

	@Override
	public String method(int number) {
		return "nada encontrado";
	}
}
