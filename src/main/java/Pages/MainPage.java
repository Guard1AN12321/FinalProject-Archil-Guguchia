
package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement loginButton = loginButton = $(".swoop-login").$(withText("შესვლა")),
            email = $(byName("Email")),
            password = $(byName("password")),
            authButton = $("#AuthBtn"),
            authInfo = $("#authInfo"),
            registerPanel = $("#ui-id-3"),
            physicalPerson = $("#ui-id-1"),
            newsInfoButton = $("#pIsSubscribedNewsletter"),
            registerButton = $("a[onclick='checkPhysicalFormSubmit()']"),
            Message = $("#physicalInfoMassage");


    public void OpenLoginPanel() {
        loginButton.click();
    }

    public void Open() {
        Selenide.open("");
    }

    public void Login(String emailValue, String passwordValue){
        email.setValue(emailValue);
        password.setValue(passwordValue);
        authButton.click();
    }

    public SelenideElement GetAuthInfo() {
        return authInfo;
    }

    public SelenideElement GetPasswordField() {
        return password;
    }
    public SelenideElement GetPhysicalButton() {
        return physicalPerson;
    }
    public SelenideElement GetReceiveEmailCheckBox(){
        return newsInfoButton;
    }
    public void SelectRegistraction(){
        registerPanel.click();
    }
    public void Register(){
        registerButton.click();
    }
    public SelenideElement GetMessageAfterClick() {
        return Message;
    }
}
