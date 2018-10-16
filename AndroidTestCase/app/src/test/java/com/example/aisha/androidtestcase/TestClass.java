package com.example.aisha.androidtestcase;

import java.net.MalformedURLException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;

import static java.util.Optional.ofNullable;


public class TestClass {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", "Pixel_XL_API_25");

        // Set BROWSER_NAME desired capability. It's Android in our case here.
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

        // Set android VERSION desired capability. Set your mobile device's OS version.
        capabilities.setCapability(CapabilityType.VERSION, "7.1.1");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android appPackage desired capability. It is
        // com.android.calculator2 for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appPackage", "com.vbanthia.androidsampleapp");
        capabilities.setCapability("browserName", "");
        // Set android appActivity desired capability. It is
        // com.android.calculator2.Calculator for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appActivity", "com.vbanthia.androidsampleapp.MainActivity");

        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        // It will launch calculator app in android device.
       driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //chrome= new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //chrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @After
    public void reset() {
        driver.findElement(By.xpath("//android.widget.Button[@index=4]")).click();
    }

    @Test
    public void testReset() {
        driver.findElement(By.xpath("//android.widget.EditText[@index='0']")).sendKeys("7");
        driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).sendKeys("3");

        driver.findElement(By.xpath("//android.widget.Button[@index=4]")).click();

        String left = driver.findElement(By.xpath("//android.widget.EditText[@index='0']")).getText();
        String right = driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).getText();

        if (!left.trim().equals("") || !right.trim().equals("")) {
            throw new AssertionError("reset failed");
        }
    }

    @Test
    public void testAddition() {


        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='inputFieldLeft']")).sendKeys("7");
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='inputFieldRight']")).sendKeys("3");


        driver.findElement(By.xpath("//android.widget.Button[@content-desc='additionButton']")).click();
        String result = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='resultTextView']")).getText();

        if(!result.contains("7.00 + 3.00 = 10.00")) {
            throw new AssertionError("addition failed");
        }

    }

    @Test
    public void testSubtraction() {

        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='inputFieldLeft']")).sendKeys("7");
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='inputFieldRight']")).sendKeys("3");


        driver.findElement(By.xpath("//android.widget.Button[@content-desc='subtractButton']")).click();
        String result = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='resultTextView']")).getText();
        if(!result.contains("7.00 - 3.00 = 4.00")) {
            throw new AssertionError("subtraction failed");
        }
    }

    @Test
    public void testMultiplication() {

        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='inputFieldLeft']")).sendKeys("7");
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='inputFieldRight']")).sendKeys("3");


        driver.findElement(By.xpath("//android.widget.Button[@content-desc='multiplicationButton']")).click();
        String result = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='resultTextView']")).getText();
        if(!result.contains("7.00 * 3.00 = 21.00")) {
            throw new AssertionError("multiplication failed");
        }

    }

    @Test
    public void testDivision() {

        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='inputFieldLeft']")).sendKeys("4");
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='inputFieldRight']")).sendKeys("2");


        driver.findElement(By.xpath("//android.widget.Button[@content-desc='divisionButton']")).click();
        String result = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='resultTextView']")).getText();
        if(!result.contains("4.00 / 2.00 = 2.00")) {
            throw new AssertionError("division failed");
        }

    }

    @Test
    public void testDivision_divideByZero() {


        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='inputFieldLeft']")).sendKeys("4");
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='inputFieldRight']")).sendKeys("0");


        driver.findElement(By.xpath("//android.widget.Button[@content-desc='divisionButton']")).click();
        String result = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='resultTextView']")).getText();
        if(!result.contains("4.00 / 0.00 = Infinity")) {
            throw new AssertionError("division by zero failed");
        }

    }




    @AfterClass
    public static void End() {
        driver.quit();
    }
}
