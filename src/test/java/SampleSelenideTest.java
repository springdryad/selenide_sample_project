import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SampleSelenideTest {

  @BeforeMethod
  public void setUp(){
    Configuration.browser = "firefox";
  }

  @Test
  public void loginTest (){
    open ("https://jira.hillel.it/secure/Dashboard.jspa");
    $(By.id("login-form-username")).setValue("RuslanaChumachenko");
    $(By.id("login-form-password")).setValue("RuslanaChumachenko");
    $(By.id("login")).click();

    $(By.id("header-details-user-fullname")).shouldBe(Condition.visible);

  }

  @AfterMethod
  public void tearDown() {
    Selenide.closeWebDriver();
  }

}
