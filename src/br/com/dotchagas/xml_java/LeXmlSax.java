package br.com.dotchagas.xml_java;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.dotchagas.xml_java.model.ProdutosHandler;

public class LeXmlSax {

	public static void main(String[] args) throws SAXException, IOException {
		// TODO Auto-generated method stub
		XMLReader reader = XMLReaderFactory.createXMLReader(); 
		ProdutosHandler handler = new ProdutosHandler();
		reader.setContentHandler(handler);

		InputStream is = new FileInputStream("src/venda.xml");
		InputSource arquivo = new InputSource(is);

		reader.parse(arquivo);

		System.out.println(handler.getProdutos());
	}

}
