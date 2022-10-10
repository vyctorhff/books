package br.torugo.livro.designerpatters.caelum.executor;

import br.torugo.livro.designerpatters.caelum.command.Concret1Command;
import br.torugo.livro.designerpatters.caelum.command.Concret2Command;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by torugo on 14/04/17.
 */
public class ClientExecutorTest {
	@Test
	public void executeCommands() throws Exception {
		ClientExecutor executor = new ClientExecutor();

		executor.addCommand(new Concret1Command());
		executor.addCommand(new Concret2Command());

		executor.executeCommands();
	}

}