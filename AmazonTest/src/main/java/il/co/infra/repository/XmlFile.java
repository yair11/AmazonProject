package il.co.infra.repository;

import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;



public class XmlFile {
	
	public static Document readingFromXmlFile() throws ParserConfigurationException, SAXException, IOException {
		
		File file = new File(System.getProperty("user.dir") +"\\properties.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
		        .newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(file);
		return document;
	}

	public static String getChromDriverName() throws ParserConfigurationException, SAXException, IOException {
		
		String chromDriverName = readingFromXmlFile().getElementsByTagName("driverName").item(0).getTextContent();		
		return chromDriverName;
	}
	
	
	public static String getChromDriverPath() throws ParserConfigurationException, SAXException, IOException {
				
		String chromDriverPath = readingFromXmlFile().getElementsByTagName("chromDriverPath").item(0).getTextContent();		
		return chromDriverPath;
	}
	
	public static String geturl() throws ParserConfigurationException, SAXException, IOException {
		
		String url = readingFromXmlFile().getElementsByTagName("url").item(0).getTextContent();		
		return url;
	}
	
	public static String getUserEmail() throws ParserConfigurationException, SAXException, IOException {
		
		String userEmail = readingFromXmlFile().getElementsByTagName("userEmail").item(0).getTextContent();		
		return userEmail;
	}
	
	public static String getUserPassword() throws ParserConfigurationException, SAXException, IOException {
		
		String userPassword = readingFromXmlFile().getElementsByTagName("userPassword").item(0).getTextContent();		
		return userPassword;
	}
	
	public static String getItemForSearch() throws ParserConfigurationException, SAXException, IOException {
		
		String itemForSearch = readingFromXmlFile().getElementsByTagName("itemForSearch").item(0).getTextContent();		
		return itemForSearch;
	}
	
	
}
