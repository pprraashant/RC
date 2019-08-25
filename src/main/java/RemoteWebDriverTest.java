import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriverTest {
    WebDriver driver;
    String baseURL, nodeURL;

    public RemoteWebDriverTest() throws FileNotFoundException {
    }

    @BeforeTest
    public void setUp() throws MalformedURLException {
        baseURL = "http://demo.guru99.com/test/guru99home/";
        nodeURL = "http://0.0.0.0:4444/wd/hub";
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL(nodeURL), capability);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
    @Test
    public void sampleTest() throws IOException {
        driver.get(baseURL);
        driver.get(baseURL);

        if (driver.getPageSource().contains("MOBILE TESTING")) {
            Assert.assertTrue(true, "Mobile Testing Link Found");
        } else {
            Assert.assertTrue(false, "Failed: Link not found");
        }

        System.out.println(driver.getTitle());

    String projectPath= System.getProperty("user.dir");
    File newFile = new File(projectPath+"/screenshots/screenshot+"+System.currentTimeMillis()+".png");
    byte[] fname = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    OutputStream os=new FileOutputStream(newFile);
		os.write(fname);
		os.close();
    }
}
