package br.com.dotchagas.xml_java;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.dotchagas.xml_java.model.Produto;

public class Sistema {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/venda.xml");

		String moeda = document.getDocumentElement().getAttribute("moeda");
		System.out.println(moeda);

		NodeList produtos = document.getElementsByTagName("produto");

		for(int i =0; i < produtos.getLength(); i++) {
		    Element produto = (Element) produtos.item(i);
		    String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
		    String preco = produto.getElementsByTagName("preco").item(0).getTextContent();
		    
		    Produto prod = new Produto(nome,Double.parseDouble(preco));

		    /*
		    System.out.println("-----------");
		    System.out.println("Nome do produto: "+ nome);
		    System.out.println("Preco do produto: "+ preco);
		    System.out.println("-----------");
		    */
		    System.out.println(prod);
		}

		
	}

}
