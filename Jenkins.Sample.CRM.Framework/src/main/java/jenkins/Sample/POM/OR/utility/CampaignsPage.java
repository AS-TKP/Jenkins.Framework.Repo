package jenkins.Sample.POM.OR.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	WebDriver driver;
	public CampaignsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement CreateCampaignButton;

public WebElement getCreateCampaignButton() {
	return CreateCampaignButton;
}
@FindBy(className = "dvHeaderText")
private WebElement CampInfoMsg;

public WebElement getCampInfoMsg() {
	return CampInfoMsg;
}


}
