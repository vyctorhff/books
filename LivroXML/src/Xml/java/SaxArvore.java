/*
 * SaxArvore.java
 *
 * Created on 10 de Janeiro de 2006, 17:57
 *
 * @author aluno
 */

package Xml.java;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.FileReader;

public class SaxArvore extends DefaultHandler {
    private int indent = 0;


    public SaxArvore() {
    }

    public static void main(String[] args) {
        try {
            XMLReader saxParser = (XMLReader) Class.forName(
                    "org.apache.xerces.parsers.SAXParser").newInstance();

            saxParser.setContentHandler(new SaxArvore());
            FileReader reader = new FileReader(args[0]);
            saxParser.parse(new InputSource(reader));
        } catch (SAXParseException spe) {
            System.err.println("Erro no Parser:" + spe.getMessage());
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    private String spacer(int count) {
        String temp = "";

        for (int cont2 = 0; cont2 < count; cont2++) {
            temp += "  ";
        }

        return temp;
    }

    public void startDocument() throws SAXException {
        System.out.println("<?xml version = \"1.0\"?>");
    }

    public void endDocument() throws SAXException {
        System.out.println("[document end");
    }

    public void startElement(String uri, String eleName, String raw, Attributes attributes) throws SAXException {
        System.out.println(spacer(indent++) + "<" + eleName);

        if (attributes != null)
            for (int cont = 0; cont < attributes.getLength(); cont++)
                System.out.println(" " + attributes.getLocalName(cont) + " = "
                        + "\"" + attributes.getValue(cont) + "\"");
        System.out.println(">");
        indent += 3;
    }

    public void endElement(String uri, String eleName, String raw)
            throws SAXException {
        indent -= 3;
        System.out.println(spacer(indent) + "</" + eleName + ">");
    }

    public void processingInstruction(String target, String value)
            throws SAXException {
        System.out.println(spacer(indent) + "<?" + target + " " + value + "?>");
    }

    public void characters(char buffer[], int offset, int length) {
        if (length > 0) {

            String temp = new String(buffer, offset, length);

            if (!temp.trim().equals(""))
                System.out.println(spacer(indent) + temp.trim());

            System.out.println(spacer(indent) + "+-[text] \"" + temp + "\"");
        }
    }
}
