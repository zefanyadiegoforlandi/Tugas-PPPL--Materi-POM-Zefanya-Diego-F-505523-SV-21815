import org.example.LoggedInPage;
import org.example.LoginPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
    @Test
    public void testLogin() {
        WebDriver driver = new FirefoxDriver();

        try {
            driver.get("https://practicetestautomation.com/practice-test-login/");

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUsername("student");
            loginPage.enterPassword("Password123");
            loginPage.clickLoginButton();

            LoggedInPage loggedInPage = new LoggedInPage(driver);

            if (loggedInPage.isUrlCorrect()) {
                System.out.println("URL verification passed");
            } else {
                System.out.println("URL verification failed");
            }

            if (loggedInPage.isCongratulationsMessageVisible()) {
                System.out.println("Congratulations message verification passed");
            } else {
                System.out.println("Congratulations message verification failed");
            }

            if (loggedInPage.isLogoutButtonVisible()) {
                System.out.println("Logout button verification passed");
            } else {
                System.out.println("Logout button verification failed");
            }

            if (loggedInPage.isSuccessMessageCorrect()) {
                System.out.println("Test passed");
            } else {
                System.out.println("Test failed");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}