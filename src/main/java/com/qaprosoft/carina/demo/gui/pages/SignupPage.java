package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends AbstractPage {

    /**
     1. Is it better to create one single method  that will do all the things ?
      or better for each action to create a sperate method ?
     2. How to create a tets where it will each time change data of test client like username and email
    */

    @FindBy(xpath = "//input[@id='uname']")
    private ExtendedWebElement nickname;

    @FindBy(xpath = "(//*[@id='email'])[2]")
    private ExtendedWebElement email;

    @FindBy(xpath = "(//input[@id='upass'])[2]")
    private ExtendedWebElement password;


    @FindBy(xpath = "//input[@type='submit'and @value='Submit']")
    private ExtendedWebElement submit;

    @FindBy(xpath = "//label[@for='iagree1']")
    private ExtendedWebElement agreeToStoreInfo;

    @FindBy(xpath = "//label[@for='iagree2']")
    private ExtendedWebElement confirmOver16;

    @FindBy(xpath = "//div[@class='normal-text res-success']")
    private ExtendedWebElement resultRegistrationText;

    @FindBy(xpath = "//div[@class='normal-text res-success']")
    private ExtendedWebElement resultRegistrationBlock;





    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public void setNickname(String nickText){
        nickname.type(nickText);
    }

    public void setEmail(String emailText){
        email.type(emailText);
    }

    public void setPass(String passText){
        password.type(passText);
    }

    public void agreeToTerms(){
        agreeToStoreInfo.click();
        confirmOver16.click();
    }

    public void clickSubmit(){
        submit.click();
    }

    public String getRegistrationResult(){
        return resultRegistrationText.getText();
    }

    public boolean isRegistrationBlockVisible(){
       return resultRegistrationBlock.isVisible();
    }



}
