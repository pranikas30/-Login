package TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
	WebDriver driver;
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		}
	By username=By.id("user-name");
	By password=By.id("password");
	By loginbtn=By.id("login-button");
	By errormsg=By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3");
	
	public void enterUsername(String user) {
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(user);
	}
	public void enterPassword(String pass) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
	}
	public void clickLogin() {
		driver.findElement(loginbtn).click();
	}
	public void Output() {
		String add=driver.getCurrentUrl();
		if(add.equals("https://www.saucedemo.com/inventory.html")){
			System.out.println("Login Successfull");
		}else {
		String err=driver.findElement(errormsg).getText();
		System.out.println("Login Failed: "+ err);
	}
	}
	public void loginButton() {
		boolean isEnabled=driver.findElement(loginbtn).isEnabled();
		if(isEnabled) {
			System.out.println("LoginButton Enabled: PASSED");
		}else {
			System.out.println("LoginButton Disabled: Failed");
		}
	}
	public void Attributeusername(String user) {
		driver.findElement(username).sendKeys(user);
		String enteredText=driver.findElement(username).getAttribute("value");
		if(enteredText.equals(user)) {
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}
	}
	public void Attributepassword(String pass) {
		driver.findElement(password).sendKeys(pass);
		String enteredPass=driver.findElement(password).getAttribute("value");
		if(enteredPass.equals(pass)) {
		System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
	}
	public void Logout() {
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		
	}
}

