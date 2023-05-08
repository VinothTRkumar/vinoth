package org.stepdefinition;
import io.cucumber.datatable.*;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.base.BaseClass;
import org.pojo.SignINpojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FbRegistration extends BaseClass{
	SignINpojo s;
	@Given("To launch the browser and maximise the window")
	public void to_launch_the_browser_and_maximise_the_window() {
	    launchBrowser();
	    
	   
	}

	@When("To launch url of fb application")
	public void to_launch_url_of_fb_application() {
	  
	  launchUrl("https://www.facebook.com/");
	  
			  }

	@When("To click the create new account button")
	public void to_click_the_create_new_account_button() {
		s=new SignINpojo();
		clickBtn(s.getCreatNewAcc());
				
	}

	@When("To pass firstname in firstname text box")
	public void to_pass_firstname_in_firstname_text_box(DataTable d) throws InterruptedException {
		Thread.sleep(6000);		
		s=new SignINpojo();
		passText("gv", s.getFirstNameTxtBox());
		
	}

	@When("To pass secondname in secondname text box")
	public void to_pass_secondname_in_secondname_text_box() {
		s=new SignINpojo();
		passText("vinoth", s.getSecondNameTxtBox());
	}

	@When("To pass moibilno or email in email text box")
	public void to_pass_moibilno_or_email_in_email_text_box() {
		s=new SignINpojo();
		passText("Seleniumimakes@gmail.com", s.getMobileoreEmailTextBox());
	}

	@When("To create new password using new password text box")
	public void to_create_new_password_using_new_password_text_box() {
		s=new SignINpojo();
		passText("rygtjnh", s.getNewPassword());
	}

	@Then("To close the chrome browser")
	public void to_close_the_chrome_browser() {
		
		//closeEntireBrowser();
	}


}
