package il.co.jb.infra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonResultsPage extends AmazonLandingPage {

	
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div/div/div[2]/div[1]/div/div/span/a/div")
	WebElement firstItemElement;
	
	
	public AmazonResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}	
	
	public void clickOnFirstItem() {
		firstItemElement.click();
	}
	
	public void searchAndgetFirstItemDetails(String searchText) {
		super.searchItem(searchText);
		this.clickOnFirstItem();		
	}
	
	
}
