package br.torugo.livro.designerpatters.caelum.postprocessors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.Validate;

import br.torugo.livro.designerpatters.caelum.PostProcessor;

public class CriptographPostProcessor implements PostProcessor {

	@Override
	public void processar(Path path) {
		Validate.isTrue(Files.exists(path));
		
		try {
			byte[] readAllBytes = Files.readAllBytes(path);
			Files.write(Paths.get("./target" + path.getFileName() + ".cript"), readAllBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
