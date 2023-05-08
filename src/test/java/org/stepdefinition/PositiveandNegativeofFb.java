package org.stepdefinition;

import org.base.BaseClass;
import org.pojo.fblogin1;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PositiveandNegativeofFb extends BaseClass {

	fblogin1 f;
	@Given("To launch the chrome browser and maximise window")
	public void to_launch_the_chrome_browser_and_maximise_window() {
	launchBrowser();
	WindowMaximize();
	}

	@When("To launch the url of the facebook application")
	public void to_launch_the_url_of_the_facebook_application() {
	    launchUrl("https://en-gb.facebook.com/");
	}

	@When("To pass valid username in email field")
	public void to_pass_valid_username_in_email_field(String em) {
	   f=new fblogin1();
	   passText(em, f.getVarRe());
	}

	@When("To pass invalid password in password field")
	public void to_pass_invalid_password_in_password_field(String pass) {
		  f=new fblogin1();
		  passText(pass, f.getPassword());
	}

	@When("To click the login button")
	public void to_click_the_login_button() {
		  f=new fblogin1();
		  clickBtn(f.getLoginBtn());
	}


	@Then("To close the browser")
	public void to_close_the_browser() {
	 closeEntireBrowser();
	}



}
