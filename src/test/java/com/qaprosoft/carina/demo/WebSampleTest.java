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
package com.qaprosoft.carina.demo;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.qaprosoft.carina.demo.gui.pages.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs.SpecType;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * This sample shows how create Web test.
 *
 * @author qpsdemo
 */
public class WebSampleTest implements IAbstractTest {

    SoftAssert softAssert = new SoftAssert();

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final String EMAIL  = "koxeb46832@abudat.com";
    private final String PASSWORD = "Aa1234561ggg";
    private final String RED_COLOUR = "rgba(213, 0, 0, 1)";


    @Test(description = "registration")
    @MethodOwner(owner = "VladT")
    public void testRegistration(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        SignupPage signupPage =  homePage.getSignUpPage();
        signupPage.setNickname("funkyCdCCChunky");
        signupPage.setEmail("koxeb46832@abudat.com");
        signupPage.setPass("Aa1234561ggg");
        signupPage.agreeToTerms();
        signupPage.clickSubmit();
        /// I've made 2 types of asserts ( by text present and by element visiblity )
        assertTrue(signupPage.getRegistrationResult().contains("Your account was created."),
                "your registration has not been successful");
        assertTrue(signupPage.isRegistrationBlockVisible(),
               "your registration has not been successful");
    }
    @Test
    @MethodOwner(owner = "VladT")
    public void testLogin(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickLoginIcon();
        homePage.enterEmail(EMAIL);
        homePage.enterPass(PASSWORD);
        LoginPage loginPage =  homePage.clickLoginButton();
//        assertTrue(loginPage.isLoginSuccessful(),"Login was not successful");
        loginPage.clickUserIcon();
        assertTrue(loginPage.isAccountInfoVisible(),"The login was not successful");
    }

    @Test
    @MethodOwner(owner = "VladT")
    public void testLoginFunctionality(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickLoginIcon();
        softAssert.assertTrue(homePage.isLoginTextPresent(),"Login Text is not visible");
        softAssert.assertTrue(homePage.getLoginPageText().contains("Login"),"Word Login is not present");
        softAssert.assertTrue(homePage.isEmailFieldVisible(),"email field not visible");
        softAssert.assertTrue(homePage.canTextBeEnteredEmailField(), "text can not be entered tp Email");
        softAssert.assertTrue(homePage.isPasswordFieldVisible(),"password field is not visible");
        softAssert.assertTrue(homePage.canTextBeEnteredPasswordField(), "text can not be entered to password field");
        softAssert.assertTrue(homePage.isLogInButtonVisible(), "Login button not visible");
        softAssert.assertTrue(homePage.isLoginButtonClickable(),"Login button is not clickable");
        softAssert.assertTrue(homePage.isForgotPasswordButtonVisible(),"forgot password button is not visible");
        softAssert.assertTrue(homePage.isForgotPasswordButtonClickable(), "forogt password button is not clickable");
        homePage.hoverOverLogin();


        assertEquals(homePage.getColourLoginButton(),RED_COLOUR);
        softAssert.assertAll();

    }
    @Test
    @MethodOwner(owner = "VladT")
    public void checkHeaderFunctionality(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickHamburgerMenu();
        softAssert.assertTrue(homePage.isHomeMenuVisible());
        softAssert.assertTrue(homePage.isNewsMenuVisible());
        softAssert.assertTrue(homePage.isReviewsMenuVisible());
        softAssert.assertTrue(homePage.isVideosMenuVisible());
        softAssert.assertTrue(homePage.isFeaturedMenuVisible());
        softAssert.assertTrue(homePage.isPhoneFinderMenuVisible());
        softAssert.assertTrue(homePage.isDealsMenuVisible());
        softAssert.assertTrue(homePage.isMerchMenuVisible());
        softAssert.assertTrue(homePage.isContactMenuVisible());
        homePage.clickHomeMenu();
        softAssert.assertEquals(homePage.getCurrentUrl(),"https://www.gsmarena.com/",
                "Home Menu Link is wrong");
        homePage.clickNewsMenu();
        softAssert.assertEquals(homePage.getCurrentUrl(),"https://www.gsmarena.com/news.php3",
                "News Menu Link is Wrong");
        homePage.clickReviewsMenu();
        softAssert.assertEquals(homePage.getCurrentUrl(),"https://www.gsmarena.com/reviews.php3",
                "Reviews Menu link is wrong");
        homePage.clickVideosMenu();
        softAssert.assertEquals(homePage.getCurrentUrl(),"https://www.gsmarena.com/videos.php3",
                "Videos Menu Link is wrong");
        homePage.clickFeaturedMenu();
        softAssert.assertEquals(homePage.getCurrentUrl(),"https://www.gsmarena.com/news.php3?sTag=Featured",
                "Featured Menu Link is wrong");
        homePage.clickPhoneFinderMenu();
        softAssert.assertEquals(homePage.getCurrentUrl(),"https://www.gsmarena.com/search.php3?",
                        "Phone Finder Menu link is wrong");
        homePage.clickDealsMenu();
        softAssert.assertEquals(homePage.getCurrentUrl(), "https://www.gsmarena.com/deals.php3",
                "Deals Menu Link is wrong");
        homePage.clickCoverageMenu();
        softAssert.assertEquals(homePage.getCurrentUrl(),"https://www.gsmarena.com/network-bands.php3",
                "Coverage Menu Link is wrong");
        homePage.clickContactMenu();
        softAssert.assertEquals(homePage.getCurrentUrl(),"https://www.gsmarena.com/contact.php3",
                "Contact Menu Link is wrong");

        /// can't test  the new window of Merch
        MerchPage merchPage = new MerchPage(getDriver());
        merchPage =  homePage.clickMerchMenu();

        softAssert.assertEquals(merchPage.getCurrentUrl(),"https://merch.gsmarena.com/",
                "merch page menu is wrong ");
        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "VladT")
    public void checkFooterFunctionality() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.scrollToFooter();
        softAssert.assertTrue(homePage.isHomeFooterVisible(),"home footer not visible");
        softAssert.assertTrue(homePage.isNewsFooterVisible(),"news footer not visible");
        softAssert.assertTrue(homePage.isReviewsFooterVisible(),"reviews footer not visible");
        softAssert.assertTrue(homePage.isCompareFooterVisible(),"compare footer not visible");
        softAssert.assertTrue(homePage.isCoverageFooterVisible(),"coverage footer not visible");
        softAssert.assertTrue(homePage.isGlossaryFooterVisible(),"glossary footer not visible");
        softAssert.assertTrue(homePage.isFAQFooterVisible(),"glossary footer not visible");
        homePage.clickNewsFooter();
        softAssert.assertEquals(homePage.getCurrentUrl(),"https://www.gsmarena.com/news.php3");
        homePage.scrollToFooter();
        homePage.clickReviewsFooter();
        softAssert.assertEquals(homePage.getCurrentUrl(),"https://www.gsmarena.com/reviews.php3");
        homePage.scrollToFooter();
        homePage.clickCompareFooter();
        softAssert.assertEquals(homePage.getCurrentUrl(),"https://www.gsmarena.com/compare.php3");
        homePage.scrollToFooter();
        homePage.clickCoverageFooter();
        softAssert.assertEquals(homePage.getCurrentUrl(),"https://www.gsmarena.com/network-bands.php3");
        homePage.scrollToFooter();
        homePage.clickGlossaryFooter();
        softAssert.assertEquals(homePage.getCurrentUrl(),"https://www.gsmarena.com/glossary.php3");
        homePage.scrollToFooter();
        homePage.clickFAQFooter();
        softAssert.assertEquals(homePage.getCurrentUrl(),"https://www.gsmarena.com/faq.php3");
        softAssert.assertAll();

    }


    




    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testModelSpecs() {
        // Open GSM Arena home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        //Closing advertising if it's displayed
        homePage.getWeValuePrivacyAd().closeAdIfPresent();
        
        // Select phone brand
        homePage = new HomePage(getDriver());
        BrandModelsPage productsPage = homePage.selectBrand("Samsung");
        // Select phone model
        ModelInfoPage productInfoPage = productsPage.selectModel("Galaxy A52 5G");
        // Verify phone specifications
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productInfoPage.readDisplay(), "6.5\"", "Invalid display info!");
        softAssert.assertEquals(productInfoPage.readCamera(), "64MP", "Invalid camera info!");
        softAssert.assertEquals(productInfoPage.readRam(), "6/8GB RAM", "Invalid ram info!");
        softAssert.assertEquals(productInfoPage.readBattery(), "4500mAh", "Invalid battery info!");
        softAssert.assertAll();
    }


    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testCompareModels() {
        // Open GSM Arena home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        // Open model compare page
        FooterMenu footerMenu = homePage.getFooterMenu();
        assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu wasn't found!");
        CompareModelsPage comparePage = footerMenu.openComparePage();
        // Compare 3 models
        List<ModelSpecs> specs = comparePage.compareModels("Samsung Galaxy J3", "Samsung Galaxy J5", "Samsung Galaxy J7 Pro");
        // Verify model announced dates
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(specs.get(0).readSpec(SpecType.ANNOUNCED), "2016, March 31");
        softAssert.assertEquals(specs.get(1).readSpec(SpecType.ANNOUNCED), "2015, June 19");
        softAssert.assertEquals(specs.get(2).readSpec(SpecType.ANNOUNCED), "2017, June");
        softAssert.assertAll();
    }
    
    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testNewsSearch() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        
        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        assertTrue(newsPage.isPageOpened(), "News page is not opened!");
        
        final String searchQ = "iphone";
        List<NewsItem> news = newsPage.searchNews(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(news), "News not found!");
        SoftAssert softAssert = new SoftAssert();
        for(NewsItem n : news) {
            System.out.println(n.readTitle());
            softAssert.assertTrue(StringUtils.containsIgnoreCase(n.readTitle(), searchQ),
                    "Invalid search results for " + n.readTitle());
        }
        softAssert.assertAll();
    }

}
