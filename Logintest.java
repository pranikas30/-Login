package TESTNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Logintest {
	WebDriver driver;
	Loginpage login;
	@BeforeMethod
	public void setup() {
		System.setProperty("WebDriver.edge.driver","E:\\Selenium");
		driver=new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
		login=new Loginpage(driver);
	}
	@Test
	public void Validusernamepass() {
		login.enterUsername("standard_user");
		login.enterPassword("secret_sauce");
		login.clickLogin();
		login.Output();
	}
	@Test
	public void invalidusername() {
		login.enterUsername("wrong_user");
		login.enterPassword("secret_sauce");
		login.clickLogin();
		login.Output();
	}
	@Test
	public void invalidpass() {
		login.enterUsername("standard_user");
		login.enterPassword("wrong_pass");
		login.clickLogin();
		login.Output();
	}
	@Test
	public void invalidUserPass() {
		login.enterUsername("wrong_user");
		login.enterPassword("wrong_pass");
		login.clickLogin();
		login.Output();
	}
	@Test
	public void emptyUsername() {
		login.enterPassword("secret_sauce");
		login.clickLogin();
		login.Output();
	}
	@Test
	public void emptyPass() {
		login.enterUsername("standard_user");
		login.clickLogin();
		login.Output();
	}
	@Test
	public void AttributeUsername() {
		login.Attributeusername("standard_user");
	}
	@Test
	public void AttributePassword() {
		login.Attributepassword("secret_sauce");
	}
	@Test
	public void LoginbtnstateTest() {
		login.loginButton();
	}
	@Test
	public void logout() {
		login.enterUsername("standard_username");
		login.enterPassword("secret_sauce");
		login.clickLogin();
		login.Logout();
		String b=driver.getCurrentUrl();
		if(b.equals("https://www.saucedemo.com/")) {
			System.out.println("Successfully signed out");
		}else {
			System.out.println("failed to sign out");
		}
	}
	@AfterMethod
	public void QuitWindow() {
		driver.quit();
	}
}
