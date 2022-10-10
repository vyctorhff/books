package br.torugo.livro.designerpatters.caelum.postprocessors;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.lang3.Validate;

import br.torugo.livro.designerpatters.caelum.PostProcessor;

public class Zipper implements PostProcessor {

	@Override
	public void processar(Path path) {
		Validate.isTrue(Files.exists(path));
		
		ZipEntry zip = new ZipEntry(path.getFileName() + "zip");
		
		try (FileOutputStream foutput = new FileOutputStream("./target/" + path.getFileName() + ".zip")) {
			
			ZipOutputStream zoutput = new ZipOutputStream(foutput);
			zoutput.putNextEntry(zip);
			
			List<String> lines = Files.readAllLines(path);
			for (String line: lines) {
				zoutput.write(line.getBytes(), 0, line.length());
			}
			
			zoutput.closeEntry();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
