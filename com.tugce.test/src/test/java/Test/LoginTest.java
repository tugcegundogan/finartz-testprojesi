package Test;

import Base.BaseTest;
import Page.LoginPage;
import org.junit.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;


    @Test
   public void loginWithTrueData() throws InterruptedException
    {
        loginPage= new LoginPage();

        loginPage.loginControls();
        loginPage.loginWithTrueData();
    }

    @Test
    public void loginWrongDataForUsername() throws InterruptedException
    {
        loginPage= new LoginPage();

        loginPage.loginControls();
        loginPage.loginWithWrongDataUsername();
    }
    @Test
    public void loginWrongDataForPassword() throws InterruptedException
    {
        loginPage= new LoginPage();

        loginPage.loginControls();
        loginPage.loginWithWrongDataForPassword();
    }
    @Test
    public void loginWithHelp() throws InterruptedException
    {
        loginPage= new LoginPage();

        loginPage.loginControls();
        loginPage.loginTrueDataWithHelp();
    }
}
