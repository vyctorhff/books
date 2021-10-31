/*
 * MetodosXML.java
 *
 * Created on 29 de Dezembro de 2005, 17:23
 * Created by @author Victor Hugo
 */
package Xml.java;

import org.w3c.dom.*;
import org.xml.sax.*;

import javax.xml.parsers.*;
import java.io.*;

public class MetodosXML {
    Document documento;
    Node raiz;
    String resp = "";

    public MetodosXML() {
        //Configura validador;
        //Construi o documento
        //Carrega o documento xml
        //recupera o raiz
        try {
            File arquivo = new File("src\\XML\\Testando.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);

            DocumentBuilder construtor = factory.newDocumentBuilder();

            documento = construtor.parse(arquivo);

            raiz = documento.getDocumentElement();
        } catch (FileNotFoundException fnfe) {
            System.err.println("O arquivo nao foi encontrado");
            System.exit(0);
        } catch (SAXParseException s) {
            System.out.println("SAXParserException");
            System.exit(0);
        } catch (SAXException se) {
            System.out.println("SAXException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Deu Exception");
            System.exit(0);
        }
    }

    //Metodos que mostram e manipulam o dom
    public void investiga() {
        //Metodos Constanstes-----------------------------------------------------
        resp = "Variaveis constantes para todos os Node\n";
        resp += "doc.ATTRIBUTE_NODE: " + String.valueOf(documento.ATTRIBUTE_NODE + "\n");
        resp += "doc.DOCUMENT_NODE: " + String.valueOf(documento.DOCUMENT_NODE + "\n");
        resp += "doc.ELEMENT_NODE: " + String.valueOf(documento.ELEMENT_NODE + "\n");
        resp += "doc.TEXT_NODE: " + String.valueOf(documento.TEXT_NODE) + "\n";
        resp += "doc.COMMENT_NODE: " + String.valueOf(documento.COMMENT_NODE) + "\n";
        resp += "doc.PROCESSING_INSTRUCTION_NODE: " + String.valueOf(documento.PROCESSING_INSTRUCTION_NODE) + "\n\n";

        //Metodos para Document---------------------------------------------------------
        resp += "Metodos de Document----------------------------------------\n";
        resp += "doc.getLocalName: " + documento.getLocalName() + "\n";
        resp += "doc.getNodeName: " + documento.getNodeName() + "\n";
        resp += "doc.getNodeType: " + String.valueOf(documento.getNodeType()) + "\n";
        resp += "doc.getNodeValue: " + documento.getNodeValue() + "\n";
        resp += "doc.getPrefix: " + documento.getPrefix() + "\n";
        resp += "doc.hasAttributes: " + String.valueOf(documento.hasAttributes()) + "\n";
        resp += "doc.hasChildNodes: " + String.valueOf(documento.hasChildNodes()) + "\n";
        resp += "doc.toString: " + documento.toString() + "\n\n";

        //Metodos para Node----------------------------------------------------------
        resp += "Metodos para Node------------------------------------" + "\n";
        resp += "Node.getLocalname: " + raiz.getLocalName() + "\n";
        resp += "Node.getNodeName: " + raiz.getNodeName() + "\n";
        resp += "Node.getNodeType: " + raiz.getNodeType() + "\n";
        resp += "Node.getNodeValue: " + raiz.getNodeValue() + "\n";
        resp += "Node.getPrefix: " + raiz.getPrefix() + "\n";
        resp += "Node.hasAttributes: " + String.valueOf(raiz.hasAttributes()) + "\n";
        resp += "Node.hasChildNodes: " + String.valueOf(raiz.hasChildNodes()) + "\n";
        resp += "Node.toString" + "\n" + raiz.toString() + "\n\n";

        //Metodos de Element----------------------------------------------------------
        Element message = (Element) raiz;
        resp += "Metodos de Element----------------------------------------\n";
        resp += "element.getLocalname: " + message.getLocalName() + "\n";
        resp += "element.getNodeName: " + message.getNodeName() + "\n";
        resp += "element.getNodeType: " + message.getNodeType() + "\n";
        resp += "element.getNodeValue: " + message.getNodeValue() + "\n";
        resp += "element.getPrefix: " + message.getPrefix() + "\n";
        resp += "element.hasAttributes: " + String.valueOf(message.hasAttributes()) + "\n";
        resp += "element.hasChildNodes: " + String.valueOf(message.hasChildNodes()) + "\n";
        resp += "element.toString:\n" + message.toString() + "\n\n";

        //Metodos para NodeList------------------------------------------------------
        NodeList lista = raiz.getChildNodes();
        resp += "Metodos para NodeList-------------------------------------\n";
        resp += "nodeList: " + String.valueOf(lista.getLength()) + "\n";
        resp += "nodeList:\n" + lista.toString() + "\n\n";

        //Metodos Text para o item(0)
        Text texto = (Text) message.getChildNodes().item(0);
        resp += "Metodos de Text item(0)----------------------------------------\n";
        resp += "text.getLocalname: " + texto.getLocalName() + "\n";
        resp += "text.getNodeName: " + texto.getNodeName() + "\n";
        resp += "text.getNodeType: " + texto.getNodeType() + "\n";
        resp += "text.getNodeValue: " + texto.getNodeValue() + "\n";
        resp += "text.getPrefix: " + texto.getPrefix() + "\n";
        resp += "text.hasAttributes: " + String.valueOf(texto.hasAttributes()) + "\n";
        resp += "text.hasChildNodes: " + String.valueOf(texto.hasChildNodes()) + "\n";
        resp += "text.toString" + "\n" + texto.toString() + "\n\n";
        
        Text texto2 = (Text) message.getChildNodes().item(2);
        resp += "Metodos de Text item(2)----------------------------------------\n";
        resp += "text2.getLocalname: " + texto2.getLocalName() + "\n";
        resp += "text2.getNodeName: " + texto2.getNodeName() + "\n";
        resp += "text2.getNodeType: " + texto2.getNodeType() + "\n";
        resp += "text2.getNodeValue: " + texto2.getNodeValue() + "\n";
        resp += "text2.getPrefix: " + texto2.getPrefix() + "\n";
        resp += "text2.hasAttributes: " + String.valueOf(texto2.hasAttributes()) + "\n";
        resp += "text2.hasChildNodes: " + String.valueOf(texto2.hasChildNodes()) + "\n";
        resp += "text2.toString" + "\n" + texto2.toString() + "\n\n";
    }

    public String mostra() {
        return resp;
    }
}
