package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class fblogin1 extends BaseClass {
public fblogin1() {
	PageFactory.initElements(driver, this);
	
}
//@FindBy(id="email")
//private WebElement email;
@FindAll({
	@FindBy(xpath="//input[@id='email']"),
	@FindBy(xpath="//input[@name='email']"),
	@FindBy(xpath="//input[@data-testid='royal_email']")
})
private WebElement varRe;
	


@FindBy(xpath = "//input[@aria-label='Password']")
private WebElement password;

@FindBy(name = "login")
private WebElement loginBtn;


public WebElement getVarRe() {
	return varRe;
}

public WebElement getPassword() {
	return password;
}

public WebElement getLoginBtn() {
	return loginBtn;
}





}
