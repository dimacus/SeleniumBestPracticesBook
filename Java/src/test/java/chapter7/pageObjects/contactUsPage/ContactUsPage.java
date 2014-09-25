package chapter7.pageObjects.contactUsPage;


import org.openqa.selenium.WebDriver;

import chapter7.pageObjects.shared.Page;

public class ContactUsPage extends Page{

  public ContactUsPage(WebDriver selenium) throws Exception {
    super(selenium);
  }

  @Override
  public String getPagePath() {
    return "/contact-us/";
  }

}
