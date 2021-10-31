/*
 * CriandoXml.java
 *
 * Created on 22 de Dezembro de 2005, 13:21
 */
package Xml.java;

import org.w3c.dom.*;

import javax.xml.parsers.*;


public class CriandoXml {

    private Document document;


    public CriandoXml() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();

            document = builder.newDocument();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }

        //root e commet sao os unicos que sao inseridos em documento
        Element root = document.createElement("root");
        document.appendChild(root);

        Comment simpleCommet = document.createComment("Comentario");
        document.appendChild(simpleCommet);

        Node contactNode = createContactNode(document);
        root.appendChild(contactNode);

        ProcessingInstruction pi =
                document.createProcessingInstruction("minhaInstrucao", "action silent");
        root.appendChild(pi);

        CDATASection cdata = document.createCDATASection("Eu posso adicionar <, > e ?");
        root.appendChild(cdata);

        //Conserta para gravar o arquivo criado.
        /*try
		{
		( (XmlDocument) document).write(new FileOutputStream("MeuDocumento.xml"));
		}
		catch(IOException ioe)
		{
		ioe.printStackTrace();
		}*/

        System.out.println(root.toString());
    }

    public static void main(String[] args) {
        new CriandoXml();
    }

    public Node createContactNode(Document doc) {
        Element priNome = doc.createElement("PriNome");
        Element segNome = doc.createElement("SegNome");

        priNome.appendChild(doc.createTextNode("Victor"));
        segNome.appendChild(doc.createTextNode("Hugo"));

        Element contato = doc.createElement("contato");

        Attr generoAtr = doc.createAttribute("genero");
        generoAtr.setValue("M");

        contato.setAttributeNode(generoAtr);
        contato.appendChild(priNome);
        contato.appendChild(segNome);

        return contato;
    }


}
