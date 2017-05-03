package br.com.dotchagas.xml_java;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.dotchagas.xml_java.model.Produto;

public class LeXmlDom {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/venda.xml");

		String moeda = document.getDocumentElement().getAttribute("moeda");
		System.out.println(moeda);

		XPath xPath = XPathFactory.newInstance().newXPath();

	    String expression = "/venda/produtos/produto[2]";

	    XPathExpression xPathExpression = xPath.compile(expression);
	    NodeList produtos = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);

		//NodeList produtos = document.getElementsByTagName("produto");

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
