package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //Click on Register Link
        homePage.clickOnRegisterLink();
        //Verify "Register" text
        registerPage.verifyRegisterText();
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        // Click on Register Link
        homePage.clickOnRegisterLink();
        // Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        // Verify the error message "First name is required."
        registerPage.verifyFirstNameIsRequired();
        // Verify the error message "Last name is required."
        registerPage.verifyLastNameIsRequired();
        // Verify the error message "Email is required."
        registerPage.verifyEmailIsRequired();
        // Verify the error message "Password is required."
        registerPage.verifyPasswordIsRequired();
        // Verify the error message "Password is required."
        registerPage.verifyConfirmedPasswordIsRequired();
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        // Click on Register Link
        homePage.clickOnRegisterLink();
        // Select gender "Female"
        registerPage.selectFemaleRadioButton();
        // Enter firstname
        registerPage.enterFirstName("Alex");
        // Enter lastname
        registerPage.enterLastName("pope");
        // Select day
        registerPage.selectDateOfBirth("5");
        // Select month
        registerPage.selectMonthOfBirth("May");
        // Select year
        registerPage.selectYearOfBirth("1985");
        // Enter email
        registerPage.enterEmailId();
        // Enter password
        registerPage.enterPassword("123456");
        // Enter Confirm Password
        registerPage.enterConfirmedPassword("123456");
        // Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        // Verify message "Your registration completed"
        registerPage.verifyRegisterText();

    }

}
