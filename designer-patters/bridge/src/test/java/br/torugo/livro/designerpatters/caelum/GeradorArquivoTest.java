package br.torugo.livro.designerpatters.caelum;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import br.torugo.livro.designerpatters.caelum.postprocessors.Zipper;
import br.torugo.livro.designerpatters.caelum.processors.GerarArquivoProperties;
import br.torugo.livro.designerpatters.caelum.processors.GerarArquivoXML;

public class GeradorArquivoTest {

	@BeforeClass
	public static void removeOld() {
		Path path = Paths.get("./target");
		try {
			Files.createDirectories(path).forEach(p -> {
				try {
					Files.delete(p);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGeradorArquivoXML() {
		GeradorArquivo gerador = new GerarArquivoXML();
		gerador.setFileName("test-text.xml");
		
		gerador.processar(this.getMapDados());

		assertFileExists("./target/test-text.xml");
	}
	
	@Test
	public void testGeradorArquivoProperties() throws Exception {
		GeradorArquivo gerador = new GerarArquivoProperties();
		gerador.setFileName("test-text.properties");
		
		gerador.processar(this.getMapDados());

		assertFileExists("./target/test-text.properties");
	}

	@Test
	public void testGeradorComCompactacao() throws Exception {
		GeradorArquivo gerador = new GerarArquivoXML();
		gerador.setFileName("test-text-compact.xml");
		gerador.setPost(new Zipper());
		
		gerador.processar(this.getMapDados());
		
		assertFileExists("./target/test-text-compact.xml");
	}
	
	private void assertFileExists(String strPath) {
		Path path = Paths.get(strPath);
		assertTrue(Files.exists(path));
	}
	
	private Map<String, String> getMapDados() {
		Map<String, String> map = new HashMap<>();
		map.put("nada", "alguma coisa");
		map.put("outra", "texto da outra coisa");
		return map;
	}
}
