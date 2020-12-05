package com.jaxb.test;


import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBExampleUnMarsh {
	public static void main(String[] args) {

	 try {

		File file = new File("/home/elitecore/workspace/demo2/WebContent/WEB-INF/resource/marsh_file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
		System.out.println(customer);
		System.out.println(customer.getName());

	  } catch (JAXBException e) {
		e.printStackTrace();
	  }

	}
}