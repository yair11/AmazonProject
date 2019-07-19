package il.co.jb.infra.web;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.xml.sax.SAXException;

import il.co.infra.repository.XmlFile;

public class WebDriverFactory {

	public static WebDriver getDriver(BrowserType browserType) throws ParserConfigurationException, SAXException, IOException {

		WebDriver driver = null;
		
		switch (browserType) {
		case CHROME:
			System.setProperty(XmlFile.getChromDriverName(), XmlFile.getChromDriverPath());
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty("", "");
			//driver = new FirefoxDriver();
			break;
		case INTERNET_EXPLORER:
			System.setProperty("", "");
			driver = new InternetExplorerDriver();
			break;
		}
		
		driver.manage().window().maximize();
		
		return driver;
	}


}
