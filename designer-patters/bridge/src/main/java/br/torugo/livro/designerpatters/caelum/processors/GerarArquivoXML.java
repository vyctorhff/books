package br.torugo.livro.designerpatters.caelum.processors;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import br.torugo.livro.designerpatters.caelum.GeradorArquivo;

public class GerarArquivoXML extends GeradorArquivo {

	@Override
	public String getConteudo(Map<String, String> map) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		buffer.append(StringUtils.LF);
		
		for (Map.Entry<String, String> entry: map.entrySet()) {
			buffer.append(this.convertToTag(entry));
			buffer.append(StringUtils.LF);
		}
		
		buffer.append(StringUtils.LF);
		return buffer.toString();
	}

	private String convertToTag(Entry<String, String> entry) {
		return MessageFormat.format("<{1}>{2}</{1}>", entry.getKey(), entry.getValue());
	}

}
