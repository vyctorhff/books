package br.torugo.livro.designerpatters.caelum.executor;

import br.torugo.livro.designerpatters.caelum.command.Command;
import br.torugo.livro.designerpatters.caelum.command.Concret1Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by torugo on 14/04/17.
 */
public class ClientExecutor {

	private List<Command> commands;

	public ClientExecutor() {
		this.commands = new ArrayList<>();
	}

	public void executeCommands() {
		StringBuilder stringBuilder = new StringBuilder();

		commands.stream().forEach(command -> {
			command.executar(stringBuilder);
			stringBuilder.append("\n");
		});

		System.out.println(stringBuilder.toString());
	}

	public void addCommand(Command command) {
		commands.add(command);
	}
}
