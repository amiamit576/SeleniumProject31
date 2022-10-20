package php.crm.Vtiger.project31.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	
	public CampaignsPage(WebDriver driver){
		PageFactory.initElements(driver,this);	//to use @find by annotation
		
	}
	@FindBy(xpath="//button[@id='Campaigns_listView_basicAction_LBL_ADD_RECORD']")
	//to find Add campaign element in webpage
	private WebElement addCampaignButton;

	public WebElement getAddCampaignButton() {
		return addCampaignButton;
	}
	public void clickonAddCampaign() {
		addCampaignButton.click(); 
		// method to click on add campaign button to transverse into add campaign page 
	}
	
}
