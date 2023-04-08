package com.automationfwk.util;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotUtil 
{
	public static void takeScreenshot(File destFile,WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, destFile);
    }

	public static void takeScreenshotUsingAShot(File destFile,WebDriver driver){
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        try{
            ImageIO.write(screenshot.getImage(), "PNG", destFile);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
