/*
 * ComparandoXML.java
 *
 * Created on 30 de Dezembro de 2005, 13:39
 * Created by @author Victor Hugo
 */

package Xml.java;

import org.w3c.dom.*;
import org.xml.sax.*;

import javax.xml.parsers.*;
import java.io.*;

public class ComparandoXML {
    Document documento;
    Node Noderaiz;
    Element Elemraiz;
    String tudo;


    public ComparandoXML() {
        try {
            File arquivo = new File("src\\XML\\Testando2.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();

            DocumentBuilder construtor = factory.newDocumentBuilder();

            documento = construtor.parse(arquivo);
        } catch (SAXParseException saxparse) {
            System.out.println("Problema no saxparse");
        } catch (SAXException saxe) {
            System.out.println("Problema no sax");
        } catch (FileNotFoundException fnfe) {
            System.out.println("Arquivo nao encontrado");
        } catch (Exception e) {
            System.out.println("Exception!!!!");
        }
    }


    public void manipula() {
        Noderaiz = documento.getDocumentElement();
        Elemraiz = (Element) Noderaiz;
        NodeList lista1 = Noderaiz.getChildNodes();

        // Metodos
        // Constanstes-----------------------------------------------------
        tudo = "Variaveis constantes para todos os Node\n";
        tudo += "doc.ELEMENT_NODE: "
                + String.valueOf(Node.ELEMENT_NODE + "\n");
        tudo += "doc.ATTRIBUTE_NODE: "
                + String.valueOf(Node.ATTRIBUTE_NODE + "\n");
        tudo += "doc.TEXT_NODE: " + String.valueOf(Node.TEXT_NODE) + "\n";
        tudo += "doc.PROCESSING_INSTRUCTION_NODE: "
                + String.valueOf(Node.PROCESSING_INSTRUCTION_NODE) + "\n";
        tudo += "doc.COMMENT_NODE: " + String.valueOf(Node.COMMENT_NODE)
                + "\n";
        tudo += "doc.DOCUMENT_NODE: "
                + String.valueOf(Node.DOCUMENT_NODE + "\n\n");

        tudo += "Node.getNodeType: " + Noderaiz.getNodeType() + "\n";
        tudo += "Element.getNodeType: " + Elemraiz.getNodeType() + "\n";
        tudo += "Node.getNodeValue: " + Noderaiz.getNodeName() + "\n";
        tudo += "Element.getNodeValue: " + Elemraiz.getNodeName() + "\n\n";

        tudo += "Utilizando o NodeList item(0)" + "\n";
        tudo += "lista1.getLength: " + lista1.getLength() + "\n";
        tudo += "lista.item(0).getNodeType: " + lista1.item(0).getNodeType()
                + "\n";
        tudo += "lista1.item(0).getNodeName: " + lista1.item(0).getNodeName()
                + "\n";
        tudo += "lista1.item(0).hasChildNodes: "
                + lista1.item(0).hasChildNodes() + "\n\n";

        tudo += "Utilizando o NodeList item(1)\n";
        tudo += "lista1.item(1).getNodeType: " + lista1.item(1).getNodeType()
                + "\n";
        tudo += "lista1.item(1).getNodeName: " + lista1.item(1).getNodeName()
                + "\n";
        tudo += "lista1.item(1).hasChildNodes: "
                + lista1.item(1).hasChildNodes() + "\n\n";

        tudo += "Utilizando o NodeList item(2)\n";
        tudo += "lista1.item(2).getNodeType: " + lista1.item(2).getNodeType()
                + "\n";
        tudo += "lista1.item(2).getNodeName: " + lista1.item(2).getNodeName()
                + "\n";
        tudo += "lista1.item(2).hasChildNodes: "
                + lista1.item(2).hasChildNodes() + "\n\n";

        tudo += "Analisando o filho de lista1.item(1)\n";
        NodeList lista2 = lista1.item(1).getChildNodes();
        tudo += "lista2.getLength: " + lista2.getLength() + "\n";
        tudo += "lista2.getNodeType: " + lista2.item(0).getNodeType() + "\n";
        tudo += "lista2.hasChildNodes: " + lista2.item(0).hasChildNodes()
                + "\n";
        tudo += "lista2.getNodeName: " + lista2.item(0).getNodeName() + "\n";
        tudo += "lista2.getNodeValue: " + lista2.item(0).getNodeValue() + "\n";
    }


    // Este metodo mostra todo o conteudo dos NodeList contido no raiz
    public void xmlTodo() {
        Noderaiz = documento.getDocumentElement();
        NodeList lista = Noderaiz.getChildNodes();
        tudo = "Tamanho do NodeList: " + lista.getLength() + "\n\n";

        for (int i = 0; i < lista.getLength(); i++) {
            tudo += "Mostra informacaes lista.item(" + i + ")\n";
            tudo += "lista.item(" + i + ").getNodeType:"
                    + lista.item(i).getNodeType() + "\n";
            tudo += "lista.item(" + i + ").getNodeName:"
                    + lista.item(i).getNodeName() + "\n";
            tudo += "lista.item(" + i + ").getNodeValue:"
                    + lista.item(i).getNodeValue() + "\n";
            tudo += "lista.item(" + i + ").hasChildNodes:"
                    + lista.item(i).hasChildNodes() + "\n\n";
        }
    }


    public String mostra() {
        return tudo;
    }
}
