package br.torugo.livro.designerpatters.caelum;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import br.torugo.livro.designerpatters.caelum.postprocessors.PostProcessorNull;

public abstract class GeradorArquivo {

	private String fileName;
	
    // Abstração ponte que da acesso a outra arvore
    private PostProcessor post;
    
    public GeradorArquivo() {
    	post = new PostProcessorNull();
	}

    public void processar(Map<String, String> map) {
        String conteudo = this.getConteudo(map);

        Path path = Paths.get("./target", fileName);
        this.saveFile(path, conteudo);

        post.processar(path);
    }
    
    private void saveFile(Path path, String conteudo) {
    	try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.defaultCharset())) {
            writer.write(conteudo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPost(PostProcessor post) {
		this.post = post;
	}
    
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public abstract String getConteudo(Map<String, String> map);
}
