package tests;

import configuration.AppiumConfiguration;
import model.Auth;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class RegistrationTests extends AppiumConfiguration {

    @Test
    public void registrationSuccess(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        new LoginScreen(driver)
                .complexRegistration(Auth.builder().email("anna"+i+"@gmail.com").password("Aanna12345$").build())
                .skipWizard()
                .checkFabButtonPresent()
                .openMenu()
                .logout();
    }

    @Test
    public void loginRegistrationSuccess(){
        new LoginScreen(driver)
                .complex(Auth.builder().email("anna06@gmail.com").password("Aanna12345$").build())
                .skipIfWizard()
                .checkFabButtonPresent()
                .openMenu()
                .logout();
    }
}
