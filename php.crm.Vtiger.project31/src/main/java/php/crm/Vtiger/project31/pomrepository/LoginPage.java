package php.crm.Vtiger.project31.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver){
		PageFactory.initElements( driver,this);//for intiallising find by annotation
		
		 
	}
	@FindBy(id="username")
	private WebElement usernameTextField;

	@FindBy(id="password")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement signInButton;

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}
	public void loginAction(String username, String password) {
		usernameTextField.clear();//for clearing text field before providing user input
		usernameTextField.sendKeys(username);//use to send  value to username text field
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
		signInButton.click();//click on Sign in button
	}
	

}
