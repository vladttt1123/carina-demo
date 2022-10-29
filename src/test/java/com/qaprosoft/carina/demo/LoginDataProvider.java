package com.qaprosoft.carina.demo;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginCredentials")
    Object [][] getEmailAndPass() {
        String loginCredentials [][] =
                                {{"",""}
                                ,{"tslktjs@gmail.com",""}
                                ,{"","12366664jjjff!"}
                                ,{"fdsjkf@fff.com","Aa123456!"}
                                ,{"koxeb46832abudat.com","Aa1234561ggg"}
                                ,{"koxeb46832@abudat.com","Aa1234561ggg!"}
                                ,{"koxeb46830@abudat.com","Aa1234561ggg!"}   //incorrect email , correct pass
                                ,{"koxeb46832@abudat.com","Aa1234561ggg"}};  //correct details
        return loginCredentials;
    }



}
