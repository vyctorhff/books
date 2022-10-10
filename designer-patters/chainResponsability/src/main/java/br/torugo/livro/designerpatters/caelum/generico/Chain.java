package br.torugo.livro.designerpatters.caelum.generico;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Created by torugo on 07/04/17.
 */
public abstract class Chain {

	private final Chain proximo;

	public Chain(Chain proximo) {
		this.proximo = proximo;
	}

	protected abstract String method(int number);

	public String templateMethod(int number) {
		String str = method(number);

		if (StringUtils.isBlank(str) && !Objects.isNull(proximo)) {
			return this.next(number);
		}

		return str;
	}

	public String next(int number) {
		return this.proximo.method(number);
	}
}
