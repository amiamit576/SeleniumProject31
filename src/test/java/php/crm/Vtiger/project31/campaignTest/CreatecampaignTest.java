package php.crm.Vtiger.project31.campaignTest;



import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import php.crm.Vtiger.project31.genericUtility.BaseClass;
import php.crm.Vtiger.project31.genericUtility.ExcelUtility;
import php.crm.Vtiger.project31.genericUtility.IPathConstant;
import php.crm.Vtiger.project31.pomrepository.CampaignDetailsPage;
import php.crm.Vtiger.project31.pomrepository.CampaignsPage;
import php.crm.Vtiger.project31.pomrepository.CreatingNewCampaignPage;
import php.crm.Vtiger.project31.pomrepository.Homepage;
@Listeners(php.crm.Vtiger.project31.genericUtility.ListenersImplementationClass.class)

public class CreatecampaignTest extends BaseClass {
	@Test(retryAnalyzer = php.crm.Vtiger.project31.genericUtility.IRetryAnalyserImplementationClass.class)
	
	public void createCampaignAndVerifyCampaignNameTest() throws EncryptedDocumentException, IOException {
		Homepage home=new Homepage(driver);
		home.clickOnCampaignOption();
		
		CampaignsPage campaign=new CampaignsPage(driver);
		campaign.clickonAddCampaign();
		
		int randomNo=jutils.generateRandomNumber(IPathConstant.RANDOM_NUMBER);
		
		ExcelUtility eUtils=new ExcelUtility();
		String campaignName=eUtils.fetchdataFromExcelFile(IPathConstant.SHEET_NAME,1,0);
		String expectedCampaignName=campaignName+randomNo;
		String date=eUtils.fetchdataFromExcelFile(IPathConstant.SHEET_NAME,1,1);
		
		CreatingNewCampaignPage newCampaign = new CreatingNewCampaignPage(driver);
		newCampaign.createNewCampaignAction(expectedCampaignName, date);
		
		
		
		CampaignDetailsPage camapignDetails = new CampaignDetailsPage(driver);
		String actualCampaignName=camapignDetails.verifyCampaignName(campaignName);
	
		
		System.out.println(actualCampaignName);
		System.out.println(expectedCampaignName);
		
		Assert.assertEquals(actualCampaignName, expectedCampaignName);
		System.out.println("camapignName is verified");
		
	}
	
		
		
		
	

}
