package il.co.jb.infra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSignInPage extends AmazonLandingPage {

	@FindBy(id="ap_email")
	WebElement emailInput;
	
	@FindBy(id="ap_password")
	WebElement passwordInput;
	
	@FindBy(id="signInSubmit")
	WebElement signInButton;
	
	@FindBy(id="createAccountSubmit")
	WebElement creatAccountButton;
	
	public AmazonSignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void setEmail(String strEmail){
		emailInput.sendKeys(strEmail);
	}
	
	public void setPassword(String strPassword){
		passwordInput.sendKeys(strPassword);
	}
	
	public void clickSignInButton() {
		signInButton.click();
	}
	
	public void clickCreatAccountButton() {
		creatAccountButton.click();		
	}
	
	public void getCreatAccountPage() {
		super.clickSignInLink();
		this.clickCreatAccountButton();
	}
	
	
	public void signInToAmazon(String strEmail, String strPasword){	
		super.clickSignInLink();
		this.setEmail(strEmail);			
		this.setPassword(strPasword);		
		this.clickSignInButton();		
	}	
	
	public boolean isSignedInToAmazon(){	
		if (super.getSignInText().contains("Hello, Sign in")) 
			return false;				
		return true;				
	}	
	
}
