package il.co.jb.infra.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonAddToCartApprovePage extends AmazonItemDetailsPage {
	
	@FindBy(xpath="//*[@id=\"huc-v2-order-row-confirm-text\"]/h1")
	WebElement addToCartApproveText;
	
	@FindBy(id="hlb-view-cart-announce")
	WebElement cartButton;
		
	
	public AmazonAddToCartApprovePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean isAdded() {
		if (addToCartApproveText.getText().equals("Added to Cart"))
		{
			return true;
		}
		return false;
	}
	
	public void clickOnCartButton() {
		cartButton.click();
	}	
	
	public boolean isAddedToCart(String searchText) {
		super.searchAndAddToCartFirstItem(searchText);
		return isAdded();
	}
	
	
	
	
	
	
	
	
	
}
