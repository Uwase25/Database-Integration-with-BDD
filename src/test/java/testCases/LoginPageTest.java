package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.DatabasePage;
import page.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPageObj;
	
@BeforeMethod
	 public void setUp() {
	  initializeDriver();
	  loginPageObj = PageFactory.initElements(driver, LoginPage.class);
	 }

@Test(priority=1)
    public void LoginTest() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
	loginPageObj.enterUserName(DatabasePage.getData("username"));
	Thread.sleep(2000);
	
	loginPageObj.enterPassword(DatabasePage.getData("password"));
	Thread.sleep(2000);
	loginPageObj.clickSignInButton();
	
	takeScreenshotAtEndOfTest(driver);

}


@AfterMethod
public void tearDown() {  
 driver.close();
 driver.quit();
}



}
