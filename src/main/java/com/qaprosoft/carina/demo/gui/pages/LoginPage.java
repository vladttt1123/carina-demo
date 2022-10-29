package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {


    @FindBy(xpath = "//div[contains(@class, 'res-success')]//h3[contains (text(), 'Login successful.')]")
    private ExtendedWebElement resultLogin;

    @FindBy(xpath = "//i[@class='head-icon icon-user']")
    private ExtendedWebElement userIcon;

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement accountInfo;


    public boolean isLoginSuccessful(){
        return resultLogin.isVisible();
    }

    public boolean isAccountInfoVisible(){
        return accountInfo.isVisible();
    }


    public void clickUserIcon(){
        userIcon.click();
    }



















    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
