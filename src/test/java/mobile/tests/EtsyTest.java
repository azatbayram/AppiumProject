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

public class EtsyTest {

    AppiumDriver<MobileElement> driver;

    @Test
    public void test2() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "8.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"//data/etsy.apk");

        driver=new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        Thread.sleep(3000);

        MobileElement favorites= driver.findElementByAccessibilityId("Favorites tab, 2 of 5");
        favorites.click();
        Thread.sleep(3000);
        MobileElement you= driver.findElement(MobileBy.AccessibilityId("You tab, 4 of 5"));
        you.click();
        Thread.sleep(3000);
        MobileElement settings= driver.findElement(By.xpath("//*[@text='Settings']"));
        settings.click();
        Thread.sleep(3000);
        MobileElement checkBox=driver.findElement(By.id("com.etsy.android:id/settings_checkbox"));
        checkBox.click();
        Thread.sleep(3000);
        Assert.assertFalse(driver.findElement(By.id("com.etsy.android:id/settings_checkbox")).isSelected());

        Thread.sleep(2000);
        driver.closeApp();

    }

}
