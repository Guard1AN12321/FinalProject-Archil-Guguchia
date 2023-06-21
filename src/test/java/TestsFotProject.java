import Pages.MainPage;
import Pages.Vacation;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;

public class TestsFotProject {
    private MainPage mainPage = new MainPage();
    private Vacation vacation = new Vacation();
    public TestsFotProject(){
        Configuration.timeout=6000;
        Configuration.browser="chrome";
        Configuration.browserSize="1920x1080";
        baseUrl="https://www.swoop.ge/";
    }

    @Test(priority = 0)
    public void FirstTask(){
        mainPage.Open();
        mainPage.OpenLoginPanel();
        mainPage.Login("project@yahoo.com", "11111111");
        mainPage.GetAuthInfo().should(appear);
        mainPage.GetAuthInfo().shouldHave(exactText("მეილი ან პაროლი არასწორია, თუ დაგავიწყდათ პაროლი,გთხოვთ ისარგებლოთ პაროლის აღდგენის ფუნქციით!"));
        mainPage.GetPasswordField().text().isEmpty();
    }
    @Test(priority = 1)
    public void SecondTask(){
        mainPage.Open();
        mainPage.OpenLoginPanel();
        mainPage.SelectRegistraction();
        mainPage.GetPhysicalButton().shouldBe(visible,enabled);
        mainPage.Register();
        mainPage.GetReceiveEmailCheckBox().shouldBe(selected);
        mainPage.GetMessageAfterClick().shouldHave(exactText("გთხოვთ შეიყვანოთ სახელი!"));
    }

    @Test(dependsOnMethods = {"SecondTask"},priority = 2)
    public void ThirdTask(){
        vacation.OpenVacation();
        vacation.FillPriceFilter("170", "180");
        vacation.Search();

    }
}
