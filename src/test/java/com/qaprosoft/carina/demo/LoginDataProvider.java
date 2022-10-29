package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.demo.utils.XLUtils2;
import org.testng.annotations.DataProvider;

import java.io.IOException;

/**
 * I have made 2 ways of reading data, the first one is by defining all the data  in
 * 2 dimensional array directly in the method.
 * and the second way is by using an exteranl xlsx  document that I've put into
 * resources folder, and also added XLUTIls class to work with this xlxs document
 */

public class LoginDataProvider
//                                            {
//    @DataProvider(name = "loginCredentials")
//    Object[][] getEmailAndPass() throws IOException {
//
//        String path = "src/main/resources/loginDetails.xlsx";
//
//        int rownum = XLUtils2.getRowCount(path,"details");
//        int colcount = XLUtils2.getCellCount(path, "details", 1);
//
//
//        Object loginCredentials [][] = new String[rownum][colcount];
//
//        for(int i  = 1; i <= rownum; i++){
//            for(int j = 0; j < colcount; j++){
//                loginCredentials[i - 1][j] = XLUtils2.getCellData(path, "details", i, j);
//            }
//        }
//
//        return loginCredentials;
//    }
//
//
//}
    ///////////////////////////////////////////////////////////
{
    @DataProvider(name = "loginCredentials")
    Object [][] getEmailAndPass() {
        String loginCredentials [][] =
                                {{"",""}                        //empty email empty pass
                                ,{"tslktjs@gmail.com",""}      //incorrect email , empty pass
                                ,{"","12366664jjjff!"}         //empty email incorrect pss
                                ,{"fdsjkf@fff.com","Aa123456!"}          //icorrect mail, incorrect pass
                                ,{"koxeb46832abudat.com","Aa1234561ggg"}  //email without @, correct pss
                                ,{"koxeb46832@abudat.com","Aa1234561ggg!"} //correct mail , incorrect pass
                                ,{"koxeb46830@abudat.com","Aa1234561ggg!"}   //incorrect email , correct pass
                                ,{"koxeb46832@abudat.com","Aa1234561ggg"}};  //correct details
        return loginCredentials;
    }

}

