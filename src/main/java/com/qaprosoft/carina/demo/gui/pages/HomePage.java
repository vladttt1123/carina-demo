/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.gui.pages;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.WeValuePrivacyAd;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;

    @FindBy(xpath = "//div[contains(@class, 'brandmenu-v2')]//a")
    private List<ExtendedWebElement> brandLinks;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    @FindBy(xpath = "//i[@class='head-icon icon-user-plus']")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//i[@class='head-icon icon-login']")
    private ExtendedWebElement loginIcon;

    @FindBy(xpath = "//input[@class='button']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//input[@type='email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//form/p[contains(., 'Login')]")
    private ExtendedWebElement loginText;

    @FindBy(xpath = "//a[@class='forgot']")
    private ExtendedWebElement forgotPasswordButton;

    @FindBy(xpath = "//button[@type='button']")
    private ExtendedWebElement hamburgerMenuButton;

    @FindBy(xpath = "//li[contains(., 'Home')]")
    private ExtendedWebElement homeMenu;

    @FindBy(xpath = "//li[contains(., 'News')]")
    private ExtendedWebElement newsMenu;

    @FindBy(xpath = "//li[contains(., 'Reviews')]")
    private ExtendedWebElement reviewsMenu;

    @FindBy(xpath = "//li[contains(., 'Videos')]")
    private ExtendedWebElement videosMenu;

    @FindBy(xpath = "//li[contains(., 'Featured')]")
    private ExtendedWebElement featuredMenu;

    @FindBy(xpath = "//li[contains(., 'Phone Finder')]")
    private ExtendedWebElement phoneFidnerMenu;

    @FindBy(xpath = "//li[contains(., 'Deals')]")
    private ExtendedWebElement dealsMenu;

    @FindBy(xpath = "//li[contains(., 'Merch')]")
    private ExtendedWebElement merchMenu;

    @FindBy(xpath = "//li[contains(., 'Coverage')]")
    private ExtendedWebElement coverageMenu;

    @FindBy(xpath = "//li[contains(., 'Contact')]")
    private ExtendedWebElement contactMenu;

    @FindBy(xpath = "(//div[@class='footer-logo'])[2]")
    private ExtendedWebElement footerLogo;

    @FindBy(xpath = "//div[@id='footer']//p/a[contains(., 'Home')]")
    private ExtendedWebElement footerHome;

    @FindBy(xpath = "//div[@id='footer']//p/a[contains(., 'News')]")
    private ExtendedWebElement footerNews;

    @FindBy(xpath = "//div[@id='footer']//p/a[contains(., 'Reviews')]")
    private ExtendedWebElement footerReviews;

    @FindBy(xpath = "//div[@id='footer']//p/a[contains(., 'Compare')]")
    private ExtendedWebElement footerCompare;

    @FindBy(xpath = "//div[@id='footer']//p/a[contains(., 'Coverage')]")
    private ExtendedWebElement footerCoverage;

    @FindBy(xpath = "//div[@id='footer']//p/a[contains(., 'Glossary')]")
    private ExtendedWebElement footerGlossary;

    @FindBy(xpath = "//div[@id='footer']//p/a[contains(., 'FAQ')]")
    private ExtendedWebElement footerFAQ;

















    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void clickLoginIcon(){
        loginIcon.click();
    }

    public LoginPage clickLoginButton(){
        loginButton.click();
        return new LoginPage(driver);
    }

    public void enterEmail(String email){
        emailField.type(email);
    }

    public void enterPass(String password){
        passwordField.type(password);
    }
    public boolean isLoginTextPresent(){
        return loginText.isVisible();
    }

    public String getLoginPageText(){
        return loginText.getText();
    }





    public boolean isEmailFieldVisible(){
        return emailField.isVisible();
    }

    public boolean canTextBeEnteredEmailField(){
        return emailField.isClickable();
    }

    public boolean isPasswordFieldVisible(){
        return passwordField.isVisible();
    }
    public boolean canTextBeEnteredPasswordField(){
        return passwordField.isClickable();
    }

    public boolean isLogInButtonVisible(){
        return loginButton.isVisible();
    }

    /**
     * don't know how to hover over element and check its colour
     * @return
     */

    public void hoverOverLogin(){
        loginButton.hover();
    }

    public String getColourLoginButton(){
        pause(5);
       return loginButton.getElement().getCssValue("background-color");
    }

    public boolean isLoginButtonClickable(){
        return loginButton.isClickable();
    }

    public boolean isForgotPasswordButtonVisible(){
        return forgotPasswordButton.isVisible();
    }
    public boolean isForgotPasswordButtonClickable(){
        return forgotPasswordButton.isClickable();
    }


    public void clickHamburgerMenu(){
        hamburgerMenuButton.click();
    }
    public boolean isHomeMenuVisible(){
       return homeMenu.isVisible();
    }

    public boolean isNewsMenuVisible(){
        return newsMenu.isVisible();
    }

    public boolean isReviewsMenuVisible(){
        return reviewsMenu.isVisible();
    }

    public boolean isVideosMenuVisible(){
        return videosMenu.isVisible();
    }

    public boolean isFeaturedMenuVisible(){
        return featuredMenu.isVisible();
    }
    public boolean isPhoneFinderMenuVisible(){
        return phoneFidnerMenu.isVisible();
    }

    public boolean isDealsMenuVisible(){
        return dealsMenu.isVisible();
    }

    public boolean isMerchMenuVisible(){
        return merchMenu.isVisible();
    }

    public boolean isCoverageMenuVisible(){
        return coverageMenu.isVisible();
    }

    public boolean isContactMenuVisible(){
        return contactMenu.isVisible();
    }

    public void clickHomeMenu(){
        homeMenu.click();
    }

    public void clickNewsMenu(){
        newsMenu.click();
    }

    public void clickReviewsMenu(){
        reviewsMenu.click();
    }

    public void clickVideosMenu(){
        videosMenu.click();
    }

    public void clickFeaturedMenu(){
        featuredMenu.click();
    }
    public void clickPhoneFinderMenu(){
        phoneFidnerMenu.click();
    }

    public void clickDealsMenu(){
        dealsMenu.click();
    }

    public void clickCoverageMenu(){
        coverageMenu.click();
    }

    public void clickContactMenu(){
        contactMenu.click();
    }
    public MerchPage clickMerchMenu(){
        merchMenu.click();
        return new MerchPage(driver);

    }

    public MerchPage switchToTab(String tabName){
       var MerchPage =  driver.getWindowHandle();
       driver.switchTo().window(tabName);
       return new MerchPage(driver);
    }

    public void scrollToFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "window.scrollBy(0, document.body.scrollHeight)";

        for(int i = 0; i < 10; i++){
            js.executeScript(script);
            pause(0.5);
        }
    }

    public boolean isHomeFooterVisible(){
       return footerHome.isVisible();
    }

    public boolean isNewsFooterVisible(){
        return footerNews.isVisible();
    }

    public boolean isReviewsFooterVisible(){
        return footerReviews.isVisible();
    }

    public boolean isCompareFooterVisible(){
        return footerCompare.isVisible();
    }

    public boolean isCoverageFooterVisible(){
        return footerCoverage.isVisible();
    }

    public boolean isGlossaryFooterVisible(){
        return footerGlossary.isVisible();
    }

    public boolean isFAQFooterVisible(){
        return footerFAQ.isVisible();
    }

    public void clickNewsFooter(){
        footerNews.click();
    }
    public void clickReviewsFooter(){
        footerReviews.click();
    }

    public void clickCompareFooter(){
        footerCompare.click();
    }

    public void clickCoverageFooter(){
        footerCoverage.click();
    }

    public void clickGlossaryFooter(){
        footerGlossary.click();
    }

    public void clickFAQFooter(){
        footerFAQ.click();
    }















    public SignupPage getSignUpPage(){
        signUpButton.click();
        return new SignupPage(driver);
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public BrandModelsPage selectBrand(String brand) {
        LOGGER.info("selecting '" + brand + "' brand...");
        for (ExtendedWebElement brandLink : brandLinks) {
            String currentBrand = brandLink.getText();
            LOGGER.info("currentBrand: " + currentBrand);
            if (brand.equalsIgnoreCase(currentBrand)) {
                brandLink.click();
                return new BrandModelsPage(driver);
            }
        }
        throw new RuntimeException("Unable to open brand: " + brand);
    }
    
    public WeValuePrivacyAd getWeValuePrivacyAd() {
    	return new WeValuePrivacyAd(driver);
    }
}
