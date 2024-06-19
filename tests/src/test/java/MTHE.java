import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class MTHE {
    private WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        this.driver.manage().window().maximize();

        int timeoutSeconds = 30; 
        driver.manage().timeouts().implicitlyWait(timeoutSeconds, TimeUnit.SECONDS);
    }

    @Test
    public void MTHE() {
        try {
            driver.get("https://mthe.gov.sl/");
            Thread.sleep(1000);

            // Instantiate the Login page and call the loginbuttonfunc method
            Login loginPage = new Login(this.driver);
            loginPage.loginbuttonfunc();
            Thread.sleep(1000);
            loginPage.login();
            Thread.sleep(3000);
            String expectedTitle = "Dashboard";

            assertTrue(expectedTitle.contains(expectedTitle));

            
            loginPage.gotosettings();
            Thread.sleep(2000);
            loginPage.sendingform();
            Thread.sleep(2000);
            loginPage.testStaticWebPage();
            Thread.sleep(2000);

            loginPage.logout();
            Thread.sleep(2000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }   

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }   
}
