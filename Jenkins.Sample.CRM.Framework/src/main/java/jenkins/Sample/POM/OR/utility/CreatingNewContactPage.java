package jenkins.Sample.POM.OR.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewContactPage {
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "lastname")
	private WebElement lastNameEdit;
	@FindBy(name = "leadsource")
	private WebElement leadsrcDD;
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement OrgNameSelectButton;
	
	@FindBy(name = "support_start_date")
	private WebElement startDateEdit;
	@FindBy(name = "support_end_date")
	private WebElement endDateEdit;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}
	public WebElement getLeadsrcDD() {
		return leadsrcDD;
	}
	public WebElement getOrgNameSelectButton() {
		return OrgNameSelectButton;
	}
	public WebElement getStartDate() {
		return startDateEdit;
	}
	public WebElement getEndDate() {
		return endDateEdit;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//business lib to create contact using last name
	public void createContact(String LastName) {
		lastNameEdit.sendKeys(LastName);
				saveButton.click();
	}
	//business lib to create contact using last name and lead src
	public void createContact(String Lastname, String LeadSource) {
		lastNameEdit.sendKeys(Lastname);
		Select sel = new Select(leadsrcDD);
		sel.selectByVisibleText(LeadSource);
		saveButton.click();
	}
	public void createContact(String LastName, String StartDate, String EndDate) {
		lastNameEdit.sendKeys(LastName);
		startDateEdit.clear();
		startDateEdit.sendKeys(StartDate);//from jlib
		endDateEdit.clear();
		endDateEdit.sendKeys(EndDate);//from jlib
				saveButton.click();
	}
	
	
	

	

}
