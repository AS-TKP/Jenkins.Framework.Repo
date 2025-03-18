package jenkins.Sample.POM.OR.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
WebDriver driver;
public CreatingNewOrganizationPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(name = "accountname")
private WebElement OrgNameEdit;
@FindBy(name = "industry")
private WebElement industryDD;
@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveButton;


public WebElement getOrganizationNameEdit() {
	return OrgNameEdit;
}
public WebElement getIndustryDD() {
	return industryDD;
}
public WebElement getSaveButton() {
	return saveButton;
}
//business lib to create org using orgname
public void createOrg(String OrgName) {
	OrgNameEdit.sendKeys(OrgName);
	saveButton.click();
}
//business lib to create org using industry and orgname
public void createOrg(String OrgName, String Industry) {
	OrgNameEdit.sendKeys(OrgName);
	Select sel = new Select(industryDD);
	sel.selectByVisibleText(Industry);
	saveButton.click();
}

}
