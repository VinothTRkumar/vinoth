package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignINpojo extends BaseClass {
	
	public SignINpojo() {
	PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//a[text()='Create New Account']")
private WebElement creatNewAcc;

@FindBy(xpath="(//input[@type='text'])[2]")
private WebElement firstNameTxtBox;

@FindBy(name="lastname")
private WebElement secondNameTxtBox;

@FindBy(name="reg_email__")
private WebElement mobileoreEmailTextBox;

@FindBy(name="reg_passwd__")
private WebElement newPassword;

public WebElement getCreatNewAcc() {
	return creatNewAcc;
}

public WebElement getFirstNameTxtBox() {
	return firstNameTxtBox;
}

public WebElement getSecondNameTxtBox() {
	return secondNameTxtBox;
}

public WebElement getMobileoreEmailTextBox() {
	return mobileoreEmailTextBox;
}

public WebElement getNewPassword() {
	return newPassword;
}
}
