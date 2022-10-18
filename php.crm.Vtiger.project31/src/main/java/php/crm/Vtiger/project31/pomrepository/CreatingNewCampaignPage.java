package php.crm.Vtiger.project31.pomrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaignPage {
	public CreatingNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="Campaigns_editView_fieldName_campaignname")
	//to find campaignNameTextField
	private WebElement campaignNameTextField;
	
	@FindBy(id="Campaigns_editView_fieldName_closingdate")
	//to find expectedClosingDateCalender
	private WebElement expectedClosingDateCalender;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveButton;

	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getExpectedClosingDateCalender() {
		return expectedClosingDateCalender;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void createNewCampaignAction(String campaignName, String date) {
		campaignNameTextField.sendKeys(campaignName);
		expectedClosingDateCalender.sendKeys(date);
		expectedClosingDateCalender.sendKeys(Keys.ENTER);
		saveButton.click();
	}

}
