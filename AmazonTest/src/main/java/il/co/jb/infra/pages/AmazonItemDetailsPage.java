package il.co.jb.infra.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonItemDetailsPage extends AmazonResultsPage {
 	
 	@FindBy(id="dropdown_selected_size_name")
	WebElement itemSizeButton;
	
	@FindBy(xpath="//*[@class=\"a-popover a-dropdown a-dropdown-common a-declarative\"]/div/div/ul")
	WebElement listOfSIzes;
	
	@FindBy(id="add-to-cart-button")
	WebElement addToCartButton;
	
	private final By itemSize = By.tagName("li");
	
	
	public AmazonItemDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	

	public void clickSizeButton(){
		itemSizeButton.click();
		List<WebElement> sizes = listOfSIzes.findElements(itemSize);
		for (WebElement size : sizes) {
			if(size.isEnabled() && size.isDisplayed() && !size.getText().equals("Select")) {
				size.click();	
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if (addToCartButton.isDisplayed()) {					
					break;
				}				
			}
		}
	}	
	
	public void clickAddToCartButton(){
		addToCartButton.click();
	}		
	
	public void searchAndAddToCartFirstItem(String searchText){
		super.searchAndgetFirstItemDetails(searchText);
		this.clickSizeButton();
		this.clickAddToCartButton();		
	}
		
}
