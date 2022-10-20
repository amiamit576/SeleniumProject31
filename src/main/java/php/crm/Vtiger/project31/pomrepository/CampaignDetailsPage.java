package php.crm.Vtiger.project31.pomrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CampaignDetailsPage {
	WebDriver driver; //intialise drivervarriable as global because we need this varrible inside the program
	public CampaignDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public String verifyCampaignName(String campaignName) {
		return driver.findElement(By.xpath("//span[contains(text(),'"+campaignName+"')]")).getText();
	}

}
