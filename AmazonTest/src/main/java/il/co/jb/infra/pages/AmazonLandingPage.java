package il.co.jb.infra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLandingPage {	

	
	protected WebDriver driver;

	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(css="input[value='Go']")
	WebElement searchButton;
	
	@FindBy(id="nav-link-accountList")
	WebElement signInLink;
	
	@FindBy(id="nav-cart")
	WebElement cartButton;			
	
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]/span[1]")
	WebElement signInText;		
		
	public AmazonLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setSearchBox(String searchText ){
		searchBox.sendKeys(searchText);			
	}
	
	public String getSignInText() {
		return signInText.getText();
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	public void clickSignInLink() {
		signInLink.click();
	}
	
	public void clickOnCartButton() {
		cartButton.click();
	}	
	
	public void searchItem(String searchText){
		this.setSearchBox(searchText);
		this.clickSearchButton();
	}	
	
}
