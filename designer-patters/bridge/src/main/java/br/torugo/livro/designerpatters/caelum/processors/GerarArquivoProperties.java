package br.torugo.livro.designerpatters.caelum.processors;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Map.Entry;

import br.torugo.livro.designerpatters.caelum.GeradorArquivo;

public class GerarArquivoProperties extends GeradorArquivo {

	@Override
	public String getConteudo(Map<String, String> map) {
		StringBuffer buffer = new StringBuffer();
		
		for (Map.Entry<String, String> entry: map.entrySet()) {
			buffer.append(convertToTag(entry));
		}
		
		return buffer.toString();
	}

	private String convertToTag(Entry<String, String> entry) {
		return MessageFormat.format("{1}={2}", entry.getKey(), entry.getValue());
	}
}
