package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.pages.MerchPage;
import com.qaprosoft.carina.demo.gui.pages.SignupPage;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GSMArenaTests extends LoginDataProvider implements IAbstractTest {

    SoftAssert softAssert = new SoftAssert();

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final String EMAIL  = "koxeb46832@abudat.com";
    private final String PASSWORD = "Aa1234561ggg";
    private final String RED_COLOUR = "rgba(213, 0, 0, 1)";


    @Test(suiteName = "registration")
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
    @Test(suiteName = "login", dataProvider = "loginCredentials")
    /**
     * please clarify
     * 5. check info messages on each step of the data provider scenario
     */
    @MethodOwner(owner = "VladT")
    public void testLogin(String Email, String Password){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickLoginIcon();
        homePage.enterEmail(Email); //being ta
        homePage.enterPass(Password);
        LoginPage loginPage =  homePage.clickLoginButton();
//        assertTrue(loginPage.isLoginSuccessful(),"Login was not successful");
        loginPage.clickUserIcon();
        assertTrue(loginPage.isAccountInfoVisible(),"The login was not successful");
    }

    @Test(suiteName = "elementsVisibility")
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
    @Test(suiteName = "elementsVisibility")
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

    @Test(suiteName = "elementsVisibility")
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

}
