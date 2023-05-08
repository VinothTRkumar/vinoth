package org.stepdefinition;

import org.base.BaseClass;
import org.pojo.fblogin1;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class fblogin2 extends BaseClass {
	
	fblogin1 f;
	
	@Given("User has to launch the browswer and maximize the window")
	public void user_has_to_launch_the_browswer_and_maximize_the_window() {
	    launchBrowser();
	    WindowMaximize();
	}

	@When("User has to hit the facebook url")
	public void user_has_to_hit_the_facebook_url() {
		launchUrl("https://en-gb.facebook.com/");
	   
	} 

	@When("User has to pass the data{string} in email field")
	public void user_has_to_pass_the_data_in_email_field(String em) {
	    f=new fblogin1();
	    passText(em, f.getVarRe());
	}

	@When("user to pass the data {string}in password field")
	public void user_to_pass_the_data_in_password_field(String pass) {
		f=new fblogin1();
		passText(pass, f.getPassword());
	}

	@When("User has to click login button")
	public void user_has_to_click_login_button() {
		f=new fblogin1();
		clickBtn(f.getLoginBtn());
	}
	@When("To check whether navigate to the home page or not")
	public void to_check_whether_navigate_to_the_home_page_or_not() {
	  
	}
	@Then("User has to close the browser")
	public void user_has_to_close_the_browser() {
	   closeEntireBrowser();
	}




}
