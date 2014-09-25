package chapter7.pageObjects.shared.sidebar;

import org.openqa.selenium.WebDriver;

public class Sidebar {

  private WebDriver selenium;
  public Sidebar(WebDriver selenium){
    this.selenium = selenium;
  }

  public SidebarCart getSidebarCart(){
    return new SidebarCart(selenium);
  }

  public Advertisement getAdvertisment(){
    return new Advertisement();
  }

  public class Advertisement {
    //IMPLEMENT ME
  }

}
