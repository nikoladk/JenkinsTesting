package dockerTests;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DockerFirefox {

    @Test
    public void firefoxTestOne() throws MalformedURLException {

        FirefoxOptions firefoxOptions = new FirefoxOptions();

        URL url = new URL("http://localhost:4444/wd/hub");

        RemoteWebDriver driver = new RemoteWebDriver(url, firefoxOptions);

        driver.get("https://www.gmail.com");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Title is: " + driver.getTitle());

        driver.quit();
    }
}
