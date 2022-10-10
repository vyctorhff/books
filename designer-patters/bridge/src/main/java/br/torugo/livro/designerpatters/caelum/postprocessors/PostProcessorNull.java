package br.torugo.livro.designerpatters.caelum.postprocessors;

import java.nio.file.Path;

import br.torugo.livro.designerpatters.caelum.PostProcessor;

public class PostProcessorNull implements PostProcessor {

	@Override
	public void processar(Path path) {
	}

}
