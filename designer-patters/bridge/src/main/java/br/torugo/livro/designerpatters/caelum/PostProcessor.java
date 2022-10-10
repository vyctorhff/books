package br.torugo.livro.designerpatters.caelum;

import java.io.File;
import java.nio.file.Path;

public interface PostProcessor {
    void processar(Path path);
}
