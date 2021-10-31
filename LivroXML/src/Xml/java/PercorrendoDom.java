/*
 * PercorrendoDom.java
 *
 * Created on 10 de Janeiro de 2006, 14:12
 *
 * @author aluno
 */

package Xml.java;

import org.w3c.dom.*;
import org.xml.sax.*;

import javax.swing.*;
import javax.xml.parsers.*;
import java.io.*;

public class PercorrendoDom {
    private Document document;

    public PercorrendoDom() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);

            DocumentBuilder construtor = factory.newDocumentBuilder();

            document = construtor.parse(new File("src\\projetotudo\\XML\\Testando.xml"));
            //process(document);
        } catch (ParserConfigurationException p) {
            System.err.println("Nao faz nada");
        } catch (SAXException sax) {
            sax.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PercorrendoDom dom = new PercorrendoDom();
    }

    public void processNode(Node currentNode) {
        switch (currentNode.getNodeType()) {
            case Node.DOCUMENT_NODE:
                Document doc = (Document) currentNode;
                System.out.println("Document node: " + doc.getNodeName() +
                        "\nRoot element: " + doc.getDocumentElement().getNodeName());
                processChildNodes(doc.getChildNodes());
                break;

            case Node.ELEMENT_NODE:
                System.out.println("\nElement node: " + currentNode.getNodeName());
                NamedNodeMap attributeNodes = currentNode.getAttributes();
                for (int cont = 0; cont < attributeNodes.getLength(); cont++) {
                    Attr attribute = (Attr) attributeNodes.item(cont);

                    System.out.println("Attribute: " + attribute.getNodeName() + "; Value: " + attribute.getNodeValue());
                }
                processChildNodes(currentNode.getChildNodes());
                break;

            case Node.CDATA_SECTION_NODE:
                break;
            case Node.TEXT_NODE:
                Text text = (Text) currentNode;

                if (!text.getNodeValue().trim().equals(""))
                    System.out.println("\nText: " + text.getNodeValue());
                break;
        }
    }

    public void processChildNodes(NodeList children) {
        if (children.getLength() != 0)
            for (int cont = 0; cont < children.getLength(); cont++)
                processNode(children.item(0));
    }
}
