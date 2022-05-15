package tests;


import configuration.AppiumConfiguration;
import model.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfiguration {

    @Test
    public void loginSuccess(){

        boolean isFabButtonPresent = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("anna789@gmail.com")
                .fillPassword("Aanna12345$")
                .submitLogin()
                .isFabPlusPresent();

        Assert.assertTrue(isFabButtonPresent);

//        new HomeScreen(driver)
//                .openMenu()
//                .logout();
    }

    @Test
    public void loginSuccessHomeWork(){
    //    new SplashScreen(driver).checkVersion("0.0.3")
        new LoginScreen(driver)
                .complexLogin(Auth.builder().email("anna789@gmail.com").password("Aanna12345$").build())
                .checkFabButtonPresent();
//                .openMenu()
//                .logout();

    }

    @Test
    public void loginSuccessHomeWork2(){
        new LoginScreen(driver)
                .complexLogin(Auth.builder().email("anna789@gmail.com").password("Aanna12345$").build())
                .checkFabButtonPresent();
//                .openMenu()
//                .logout();

    }
    @Test // wick@gmail.com Aanna12345$ ----. wrong email or password
    public void loginCheckErrorMessage(){
        new LoginScreen(driver)
                .complexNegLogin(Auth.builder().email("wick@gmail.com").password("Aanna12345$").build())
                .errorNotifPresents()
                .submitError();
    }


    @AfterMethod (enabled = false)
    public void postCondition(){
        new HomeScreen(driver)
                .openMenu()
                .logout();
    }
}