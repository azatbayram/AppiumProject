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

public class CalculatorTest {

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
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

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
        MobileElement digit_2=driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        MobileElement plus=driver.findElement(MobileBy.AccessibilityId("plus"));
        MobileElement equals=driver.findElement(MobileBy.AccessibilityId("equals"));
        MobileElement result=driver.findElement(By.id("com.android.calculator2:id/result"));

        digit_2.click();
        plus.click();
        digit_2.click();
        equals.click();

        String resultText= result.getText();
        System.out.println(resultText);
        Assert.assertEquals("4",resultText);

        Thread.sleep(2000);

        MobileElement digit_4=driver.findElement(By.id("com.android.calculator2:id/digit_4"));
        MobileElement digit_5= driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        MobileElement multiply=driver.findElementByAccessibilityId("multiply");

        digit_4.click();
        multiply.click();
        digit_5.click();
        equals.click();
        resultText=result.getText();
        System.out.println(resultText);
        Assert.assertEquals("20",resultText);

        Thread.sleep(2000);

        //25-15=10
        MobileElement minus= driver.findElementByAccessibilityId("minus");
        getDigit(2).click();
        getDigit(5).click();
        minus.click();
        getDigit(1).click();
        getDigit(5).click();
        equals.click();
        resultText=result.getText();
        System.out.println(resultText);
        Assert.assertEquals("10",resultText);




        Thread.sleep(3000);

        //close app
        driver.closeApp();


    }

    public MobileElement getDigit(int digit){
        String locatorText="com.android.calculator2:id/digit_"+digit;
        return driver.findElement(By.id(locatorText));
    }




}
