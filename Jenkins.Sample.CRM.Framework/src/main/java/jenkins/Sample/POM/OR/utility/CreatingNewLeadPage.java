package jenkins.Sample.POM.OR.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLeadPage {
		WebDriver driver;
		public CreatingNewLeadPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
    @FindBy(name="salutationtype")
	private WebElement FirstNameDD;
    @FindBy(name="lastname")
	private WebElement LastNameEdit;
    @FindBy(name="company")
	private WebElement CompanyEdit;
    @FindBy(name="leadsource")
	private WebElement LeadSourceDD;
    @FindBy(name="industry")
	private WebElement IndustryDD;
    @FindBy(name="leadstatus")
	private WebElement LeadStatusDD;
    @FindBy(name="rating")
	private WebElement RatingDD;
    @FindBy(xpath = "//input[@title='Save [Alt+S]']")
   	private WebElement SaveButton;
	public WebElement getFirstNameDD() {
		return FirstNameDD;
	}
	public WebElement getLastNameEdit() {
		return LastNameEdit;
	}
	public WebElement getCompanyEdit() {
		return CompanyEdit;
	}
	public WebElement getLeadSourceDD() {
		return LeadSourceDD;
	}
	public WebElement getIndustryDD() {
		return IndustryDD;
	}
	public WebElement getLeadStatusDD() {
		return LeadStatusDD;
	}
	public WebElement getRatingDD() {
		return RatingDD;
	}
	public WebElement getSaveButton() {
		return SaveButton;
	}
    
	public void createNewLead(String FirstName, String LastName, String Company,
			String Industry, String LeadStatus, String Rating, String LeadSource) {
		Select sel = new Select(FirstNameDD);
		sel.selectByVisibleText(FirstName);
		getLastNameEdit().sendKeys(LastName);
		getCompanyEdit().sendKeys(Company);
		Select sel1 = new Select(IndustryDD);
		sel1.selectByVisibleText(Industry);
		Select sel2 = new Select(LeadStatusDD);
		sel2.selectByVisibleText(LeadStatus);
		Select sel3 = new Select(RatingDD);
		sel3.selectByVisibleText(Rating);
		Select sel4 = new Select(LeadSourceDD);
		sel4.selectByVisibleText(LeadSource);
		SaveButton.click();
		
	}   
    
}






























