package br.com.dotchagas.xml_java;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.dotchagas.xml_java.model.Venda;

public class MapeiaXmlJaxb {

	public static void main(String[] args) throws JAXBException {
		JAXBContext contexto = JAXBContext.newInstance(Venda.class);
		Unmarshaller unmarshaller = contexto.createUnmarshaller();
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/venda.xml"));

		System.out.println(venda);
	}

}
