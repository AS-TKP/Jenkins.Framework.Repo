package jenkins.Sample.POM.OR.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationsPage {
WebDriver driver;
public OrganizationsPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//img[@alt='Create Organization...']")
private WebElement createorganizationbtn;

public WebElement getCreateorganizationbtn() {
	return createorganizationbtn;
}
@FindBy(className = "dvHeaderText")
private WebElement OrgheaderMsg;

public WebElement getOrgHeaderMsg() {
	return OrgheaderMsg;
}
@FindBy(name = "search_text")
private WebElement SearchEdit;

public WebElement getSearchEdit() {
	return SearchEdit;
}
@FindBy(name = "submit")
private WebElement OrgSearchNowButton;

public WebElement getOrgSearchNowButton() {
	return OrgSearchNowButton;
}
@FindBy(name = "search")
private WebElement SearchNowButtonChildPage;

public WebElement getSearchNowButtonChildPage() {
	return SearchNowButtonChildPage;
}
@FindBy(linkText = "del")
private WebElement DeleteLink;

public WebElement getDeleteLink() {
	return DeleteLink;
}
@FindBy(id = "bas_searchfield")
private WebElement SearchFieldDD;

public WebElement getSearchFieldDD() {
	return SearchFieldDD;
}

/*business lib to srch org using orgnamedd*/
public void searchOrg(String OrgName, String OrgNameDD) {
	SearchEdit.sendKeys(OrgName);
	Select sel = new Select(SearchFieldDD);
	sel.selectByVisibleText(OrgNameDD);
	OrgSearchNowButton.click();
}
/* move to del element and click */
public void moveToDeleteButton() throws Throwable { 
Actions act = new Actions(driver);
Thread.sleep(2000);
act.moveToElement(DeleteLink).click().perform();
}

/* handle alert */
public void handleDeleteAlert() throws Throwable {
Alert confirmationalrt = driver.switchTo().alert();
Thread.sleep(2000);

confirmationalrt.accept();
System.out.println("OrgName deleted successfully");
}



}