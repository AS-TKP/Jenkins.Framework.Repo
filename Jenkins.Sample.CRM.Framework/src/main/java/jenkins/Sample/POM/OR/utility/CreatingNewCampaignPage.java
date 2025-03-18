package jenkins.Sample.POM.OR.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewCampaignPage {
	WebDriver driver;
	public CreatingNewCampaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "campaignname")
	private WebElement campaignNameEdit;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement assignToRadioBtn;
	
	@FindBy(name = "assigned_group_id")
	private WebElement groupDD;
	
	@FindBy(name = "campaigntype")
	private WebElement campaignTypeDD;
	
	@FindBy(name = "campaignstatus")
	private WebElement campaignStatusDD;
	
	@FindBy(name = "closingdate")
	private WebElement closingDateEdit;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public WebElement getCampaignNameEdit() {
		return campaignNameEdit;
	}
	public WebElement getAssignToRadioBtn() {
		return assignToRadioBtn;
	}
	public WebElement getGroupDD() {
		return groupDD;
	}
	public WebElement getCampaignTypeDD() {
		return campaignTypeDD;
	}
	public WebElement getCampaignStatusDD() {
		return campaignStatusDD;
	}
	public WebElement getClosingDateEdit() {
		return closingDateEdit;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//business lib to create camp using CampaignType and CampStatus & end date
	public void createCampaigns(String CampaignName, String CampaignType, String CampaignStatus, String EndDate) {
		campaignNameEdit.sendKeys(CampaignName);
		
	    Select sel1 = new Select(campaignTypeDD);
	    sel1.selectByVisibleText(CampaignType);
	    
	    Select sel2 = new Select(campaignStatusDD);
	    sel2.selectByVisibleText(CampaignStatus);
	    closingDateEdit.clear();
	    closingDateEdit.sendKeys(EndDate);
	    saveButton.click();
	}
	public void createCampaigns(String CampaignName, String Group, String CampaignType, String CampaignStatus, String EndDate) {
		campaignNameEdit.sendKeys(CampaignName);
		
        getAssignToRadioBtn().click();
		Select sel = new Select(groupDD);
	    sel.selectByVisibleText(Group);
	    
	    Select sel1 = new Select(campaignTypeDD);
	    sel1.selectByVisibleText(CampaignType);
	    
	    Select sel2 = new Select(campaignStatusDD);
	    sel2.selectByVisibleText(CampaignStatus);
	    closingDateEdit.clear();
	    closingDateEdit.sendKeys(EndDate);
	    saveButton.click();
	}	
}





























