package il.co.jb.infra.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AmazonCartPage extends AmazonLandingPage {
	
	
	@FindBy(xpath="//*[@class=\"a-row sc-list-item sc-list-item-border sc-java-remote-feature\"]/div[4]/div/div[1]/div/div/div[2]/div/span[1]/span/input")
	WebElement deletetButton;
	
	@FindBy(xpath="//*[@class=\"a-row sc-list-item sc-list-item-border sc-java-remote-feature\"]/div[3]/div[1]/span")
	WebElement deleteApproveText;
	
		
	public AmazonCartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
		
	public void clickOnDeleteButton() {
		deletetButton.click();
	}	
	
	public boolean isDeleted() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (deleteApproveText.getText().contains("was removed from Shopping Cart"))		
			return true;		
		return false;
	}
	
	
	public boolean isDeletedFromCart() {
		super.clickOnCartButton();
		this.clickOnDeleteButton();
		return isDeleted();
	}	
	
	
}
