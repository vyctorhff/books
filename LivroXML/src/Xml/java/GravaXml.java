/*
 * GravaXml.java
 *
 * Created on 26 de Dezembro de 2005, 23:31
 * Created by @author Victor Hugo
 */

package Xml.java;

import org.w3c.dom.*;
import org.xml.sax.*;

public class GravaXml {

    private final String menor, maior;
    private Node raiz;
    private String pai, filho, valor;
    private int tamanho;

    public GravaXml() {
        pai = "";
        filho = "";
        valor = "";
        tamanho = 0;

        maior = ">";
        menor = "<";
    }

    public void passaDocumento(Node root) {
        raiz = root;

        processaXml();
    }

    public void processaXml() {
        //Testa se o elemento e o raiz
        if (raiz.getNodeType() == Node.ELEMENT_NODE) {
            NodeList filhoLista = raiz.getChildNodes();

            pai = raiz.getNodeName();
            filho = filhoLista.item(1).getNodeName();

            NodeList valorList = filhoLista.item(1).getChildNodes();
            valor = valorList.item(0).getNodeValue();
        } else
            System.out.println("Nao e o root");
    }

    public String mostraXml() {
        String resp;

        if (pai != "") {
            resp = menor + pai + maior + "\n";
            resp += "  " + menor + filho + maior + valor + menor + "\\" + filho + maior + "\n";
            resp += menor + "\\" + pai + maior + "\n";
            resp += tamanho;
        } else
            resp = "variavel vazia";

        return resp;
    }
}