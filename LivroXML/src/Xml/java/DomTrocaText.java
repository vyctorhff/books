/*
 * DomTrocaText.java
 *
 * Created on 18 de Dezembro de 2005, 21:41
 *
 *Premeiro exemplo utilizando java para alterar xml.
 */

package Xml.java;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;

public class DomTrocaText {
    private Document document;
    private File arquivoXML;
    //private GravaXml grava;


    public DomTrocaText() {
        try {
            arquivoXML = new File("src\\XML\\Testando.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();

            // Sera validado por um navegador.
            factory.setValidating(true);

            DocumentBuilder builder = factory.newDocumentBuilder();

            document = builder.parse(arquivoXML);

            // Os exceptions SaxParseException e SaxException ser�o
            // tratados se algum erro for ocorrido aqui.
            Node root = document.getDocumentElement();

            if (root.getNodeType() == Node.ELEMENT_NODE) {
                Element myMessageNode = (Element) root;
                NodeList messageNodes = myMessageNode
                        .getElementsByTagName("message");

                if (messageNodes.getLength() != 0) {
                    Node message = messageNodes.item(0);

                    Text newText = document
                            .createTextNode("Olha ai a diferenca");
                    Text oldText = (Text) message.getChildNodes().item(0);

                    message.replaceChild(newText, oldText);
                }
            }
            // Nao pode ser usado ate que a classe esteja criada.
            // ( (XmlDocument) document).write(new
            // FileOutputStream("intro.xml"));
            // grava = new GravaXml();
            // grava.passaDocumento(root);
            // System.out.println(grava.mostraXml());
        } catch (SAXParseException spe) {
            System.err.println("Parse error: " + spe.getMessage());
            System.exit(1);
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (FileNotFoundException fnfe) {
            System.err.println("O arquivo nao foi encontrado");
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new DomTrocaText();
    }
}