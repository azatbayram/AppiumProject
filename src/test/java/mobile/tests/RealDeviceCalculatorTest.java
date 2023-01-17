package mobile.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class RealDeviceCalculatorTest {

    AppiumDriver<MobileElement> driver;

    @Test
    public void calculatorTest() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        //we use android phone
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        //version of android
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "12.0");
        //device name, if it is real device we need to pass UUID parameter
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "here you need to enter your phone serial number");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        //to open app
        //either you specify app apk file path
        // or if app is already installed, you need to specify appActivity and appPackage

        //set your application package name
        desiredCapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        //set your application activity name
        desiredCapabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
        //create appium driver
        //http://localhost:4723/wd/hub"-->addess of appium server, we write localhost because we have appium on the same computer
        driver=new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);

        Thread.sleep(3000);
        MobileElement plus= driver.findElementByAccessibilityId("Plus");
        MobileElement minus= driver.findElementByAccessibilityId("Minus");
        MobileElement multiply=driver.findElementByAccessibilityId("Multiplication");
        MobileElement division= driver.findElementByAccessibilityId("Division");
        MobileElement equals= driver.findElementByAccessibilityId("Equal");
        MobileElement result=driver.findElementByAccessibilityId("Calculator input field");

        getDigit("2").click();
        plus.click();
        getDigit("5").click();
        equals.click();

        String resultText=result.getText();
        Assert.assertEquals("7", resultText);
        System.out.println(resultText);


        Thread.sleep(3000);

        //close app
        driver.closeApp();


    }

    public MobileElement getDigit(String digit){

        return driver.findElementByAccessibilityId(digit);
    }
}
