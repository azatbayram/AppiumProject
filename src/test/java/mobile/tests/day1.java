package mobile.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class day1 {

    AppiumDriver<MobileElement> driver;

    @Test
    public void calculatorTest() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        //we use android phone
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        //version of android
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "8.0");
        //device name, if it is real device we need to pass UUID parameter
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");

        //to open app
        //either you specify app apk file path
        // or if app is already installed, you need to specify appActivity and appPackage

        //set your application package name
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        //set your application activity name
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        //create appium driver
        //http://localhost:4723/wd/hub"-->addess of appium server, we write localhost because we have appium on the same computer
        driver=new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);

        Thread.sleep(3000);
        //close app
        driver.closeApp();




    }
}
