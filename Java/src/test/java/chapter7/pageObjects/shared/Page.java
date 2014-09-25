package chapter7.pageObjects.shared;

import org.openqa.selenium.WebDriver;

import java.net.URI;
import java.net.URISyntaxException;

import chapter7.pageObjects.shared.sidebar.Sidebar;

public class Page {

  protected WebDriver selenium;

  public Page(WebDriver selenium) throws Exception {
    this.selenium = selenium;
    verify(selenium);
  }

  public Sidebar getSidebar(){
    return new Sidebar(selenium);
  }

  public PageHeader getPageHeader(){
    return new PageHeader(selenium);
  }

  public PageBody getPageBody(){
    return new PageBody(selenium);
  }

  public PageFooter getPageFooter(){
    return new PageFooter(selenium);
  }

  public void verify(WebDriver selenium) throws URISyntaxException {
    URI uri = new URI(selenium.getCurrentUrl());
    if (!uri.getPath().equals(getPagePath())) {
      throw new RuntimeException(
          "Unexpected page. Expected " + getPagePath() + " but current url is " + selenium
              .getCurrentUrl());
    }
  }


  public String getPagePath() {
    throw new RuntimeException("Method not implemented on " + this.getClass().getCanonicalName());
  }


  public class PageBody{
    public PageBody(WebDriver selenium){
      //IMPLEMENT ME
    }
  }

  public class PageHeader{
    public PageHeader(WebDriver selenium){
      //IMPLEMENT ME
    }
  }

  public class PageFooter{
    public PageFooter(WebDriver selenium){
      //IMPLEMENT ME
    }
  }

}
