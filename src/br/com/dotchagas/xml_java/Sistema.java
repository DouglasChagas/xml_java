package br.com.dotchagas.xml_java;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Sistema {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.parse("src/venda.xml");

		String moeda = document.getDocumentElement().getAttribute("moeda");
		System.out.println(moeda);
		
		Element tagFormaDePagamento = (Element) document.getElementsByTagName("formaDePagamento").item(0);
		String formaDePagamento = tagFormaDePagamento.getTextContent();

		System.out.println(formaDePagamento);
	}

}
