/*
 * ExecDTDRetanguloCirculo.java
 *
 * Created on 10 de Janeiro de 2006, 15:29
 *
 * @author aluno
 */

package Xml.exercicio;

import org.w3c.dom.*;
import org.xml.sax.*;

import javax.swing.*;
import javax.xml.parsers.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ExecDTDRetanguloCirculo extends JFrame {

    private static final long serialVersionUID = 1L;

    private Document documento;
    private Node raiz;
    private int retx, rety, width, height, radius, cirx, ciry;


    public ExecDTDRetanguloCirculo() {
        super("Exec 8.6");
        File arquivo;

        // Prepare e carrega o xml
        try {
            arquivo = new File(
                    "src\\projetotudo\\XML\\ExecRetanguloCirculo.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            factory.setValidating(true);

            DocumentBuilder construtor = factory.newDocumentBuilder();

            documento = construtor.parse(arquivo);

            raiz = documento.getDocumentElement();
        } catch (SAXParseException spe) {
            spe.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException io) {
            System.err.println("O arquivo nao foi encontrado");
        }

        // Inicializa as coordenadas do retangulo e do circulo
        retx = 0;
        rety = 0;
        width = 0;
        height = 0;
        cirx = 0;
        ciry = 0;
        radius = 0;

        Element raizEle = (Element) raiz;
        NodeList lista = raizEle.getChildNodes();

        // Recupera o elemento retangulo e do circulo
        Node retangulo = lista.item(1);
        Node circulo = lista.item(3);

        // Cria um lista com os atributos de retangulo e circulo
        NamedNodeMap atributosRet = retangulo.getAttributes();
        NamedNodeMap atributosCirc = circulo.getAttributes();

        // Armazenara os atributos de retangulo e circulo
        Attr atributoRetangulo[] = new Attr[atributosRet.getLength()];
        Attr atributoCirculo[] = new Attr[atributosCirc.getLength()];

        // Recupera os valores para o retangulo
        for (int cont = 0; cont < atributosRet.getLength(); cont++) {
            atributoRetangulo[cont] = (Attr) atributosRet.item(cont);
        }

        // Recupera os valores para o circulo
        for (int i = 0; i < atributosCirc.getLength(); i++) {
            atributoCirculo[i] = (Attr) atributosCirc.item(i);
        }

        // Cadastra os valores na respectivas coordenadas
        height = Integer.parseInt(atributoRetangulo[0].getNodeValue());
        width = Integer.parseInt(atributoRetangulo[1].getNodeValue());
        retx = Integer.parseInt(atributoRetangulo[2].getNodeValue());
        rety = Integer.parseInt(atributoRetangulo[3].getNodeValue());

        radius = Integer.parseInt(atributoCirculo[0].getNodeValue());
        cirx = Integer.parseInt(atributoCirculo[1].getNodeValue());
        ciry = Integer.parseInt(atributoCirculo[2].getNodeValue());
    }

    public static void main(String[] args) {
        ExecDTDRetanguloCirculo erc = new ExecDTDRetanguloCirculo();
        erc.setSize(600, 600);
        erc.setVisible(true);
        erc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Desenha as figuras
    public void paint(Graphics g) {
        super.paint(g);

        // desenha o retangulo em baixo relevo
        g.fill3DRect(retx, rety, width, height, false);

        // desenha o circulo
        g.fillOval(cirx, ciry, radius, radius);
    }
}
