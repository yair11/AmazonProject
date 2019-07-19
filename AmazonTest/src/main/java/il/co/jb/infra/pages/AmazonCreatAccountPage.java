package il.co.jb.infra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AmazonCreatAccountPage extends AmazonSignInPage{
	
	@FindBy(id="ap_customer_name")
	WebElement nameInput;
	
	@FindBy(id="ap_email")
	WebElement emailInput;
	
	@FindBy(id="ap_password")
	WebElement passwordInput;
	
	@FindBy(id="ap_password_check")
	WebElement repasswordInput;	
	
	@FindBy(id="continue")
	WebElement createAccountButton;
	
	public AmazonCreatAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String strUserName){
		nameInput.sendKeys(strUserName);
						
	}
	
	public void setEmail(String strEmail){
		emailInput.sendKeys(strEmail);
	}
	
	public void setPassword(String strPassword){
		passwordInput.sendKeys(strPassword);
	}
	
	public void setrePassword(String strPassword){
		repasswordInput.sendKeys(strPassword);
	}
									
	public void clickCreateAccountButton(){
		createAccountButton.click();
	}
							
							
	public void createAmazonAccount(String strUserName,String strEmail, String strPasword, String strPassword){
		super.getCreatAccountPage();
		this.setUserName(strUserName);
		this.setEmail(strEmail);			
		this.setPassword(strPasword);
		this.setrePassword(strPasword);
		this.clickCreateAccountButton();		
	}
						
				
	

}
