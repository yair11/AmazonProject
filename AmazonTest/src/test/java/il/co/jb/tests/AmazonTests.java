package il.co.jb.tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import il.co.infra.repository.XmlFile;
import il.co.jb.infra.pages.AmazonAddToCartApprovePage;
import il.co.jb.infra.pages.AmazonCartPage;
import il.co.jb.infra.pages.AmazonSignInPage;
import il.co.jb.infra.web.BrowserType;
import il.co.jb.infra.web.WebDriverFactory;

public class AmazonTests {	
	
	WebDriver driver;
	AmazonSignInPage amazonSignInPage;
	AmazonAddToCartApprovePage amazonAddToCartApprovePage;
	AmazonCartPage amazonCartPage;
	
	@BeforeClass
    public void before() throws ParserConfigurationException, SAXException, IOException {		
		if (driver == null) {
			driver = WebDriverFactory.getDriver(BrowserType.CHROME);
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(XmlFile.geturl());
    }

	@Test(priority=0)	
	public void testSignIn() throws InterruptedException, ParserConfigurationException, SAXException, IOException {	
		
		amazonSignInPage = new AmazonSignInPage(driver);
		amazonSignInPage.signInToAmazon(XmlFile.getUserEmail(), XmlFile.getUserPassword());
		assertTrue(amazonSignInPage.isSignedInToAmazon());		
		
	}	
	
	@Test(priority=1)
	public void testAddToCartButton() throws ParserConfigurationException, SAXException, IOException {
	
		amazonAddToCartApprovePage = new AmazonAddToCartApprovePage(driver);		
		assertTrue(amazonAddToCartApprovePage.isAddedToCart(XmlFile.getItemForSearch()));
		
	}
	
	@Test(priority=2)
	public void testDeleteItemFromCartButton() {
		
		amazonCartPage = new AmazonCartPage(driver);
		assertTrue(amazonCartPage.isDeletedFromCart());
			
	}	
	
	@AfterClass
    public void After(){		
		driver.quit();
    }


}

