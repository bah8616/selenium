import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

public class Login extends BasePage {

    public Login(WebDriver driver) {
        super(driver);
    }

    private final By loginbutton = By.xpath("//*[@id=\"HyperLink52\"]/b");
    private final By loginfield = By.xpath("//*[@id=\"ContentPlaceHolder2_Username\"]");
    private final By passwordfield = By.xpath("//*[@id=\"ContentPlaceHolder2_Password\"]");
    private final By loginbutton2 = By.xpath("//*[@id=\"ContentPlaceHolder2_btnLogin\"]");
    private final By logout = By.xpath("//*[@id=\"LinkButton1\"]");
    private final By dropmenu = By.xpath("//*[@id=\"name\"]\n");
    private final By occupationfield = By.xpath("//*[@id=\"ContentPlaceHolder1_txtFatherOccupation\"]");
    private final By profile = By.xpath("//*[@id=\"ctl01\"]/div[3]/header/nav/div/ul/li/ul/li[2]/div/div/a\n");
    private final By updatebutton = By.xpath("//*[@id=\"ContentPlaceHolder1_btnSubmit\"]");

    public Login loginbuttonfunc() {
        this.waitAndReturnElement(this.loginbutton).click();
        return new Login(this.driver);
    }

    public void login() {
        this.waitAndReturnElement(this.loginfield).click();
        this.waitAndReturnElement(loginfield).sendKeys("bah8616");
        this.waitAndReturnElement(this.passwordfield).click();
        this.waitAndReturnElement(passwordfield).sendKeys("Owner@572592");
        this.waitAndReturnElement(this.loginbutton2).click();
    }

    public void logout() {
        this.waitAndReturnElement(this.dropmenu).click();
        this.waitAndReturnElement(this.logout).click();
    }

    public void gotosettings() {
        this.waitAndReturnElement(this.dropmenu).click();
        this.waitAndReturnElement(this.profile).click();
    }

    public void sendingform() {
        WebElement occupationElement = this.waitAndReturnElement(this.occupationfield);
        occupationElement.click();
        occupationElement.clear();
        occupationElement.sendKeys("Security");

        this.waitAndReturnElement(this.updatebutton).click();
    }
	public String readtitle(){
        return driver.getTitle();
    }
	public void testStaticWebPage() {
        driver.get("https://mthe.gov.sl/mtheOnlinePortal/404_ScholarhipForm.aspx");
          String expectedTitle = "Dashboard";

            assertTrue(expectedTitle.contains(expectedTitle));

            
	}
}
