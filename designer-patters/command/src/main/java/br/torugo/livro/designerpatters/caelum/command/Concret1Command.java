package br.torugo.livro.designerpatters.caelum.command;

/**
 * Created by torugo on 14/04/17.
 */
public class Concret1Command implements Command {
	@Override
	public void executar(StringBuilder stringBuilder) {
		stringBuilder.append("passou pelo concret 1");
	}
}
