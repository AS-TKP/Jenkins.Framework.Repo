package jenkins.Sample.POM.OR.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
WebDriver driver;
public LeadsPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement createLeadButton;

public WebElement getCreateLeadButton() {
	return createLeadButton;
}
@FindBy(className="dvHeaderText")
private WebElement leadInfoMsg;

public WebElement getLeadInfoMsg() {
	return leadInfoMsg;
}


}
