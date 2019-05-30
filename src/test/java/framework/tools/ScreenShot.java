package framework.tools;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import framework.utils.DateTimeUtils;

public class ScreenShot {
	private static final String PATH = "./reports/screenshots/";
			
	public static String capture(WebDriver driver) {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = PATH + source.getName();
	    return saveImageFile(source, path);
	}

	public static String captureFullScreen() {
		String newPath = PATH + DateTimeUtils.getTimeStampWithoutFormat() + ".png";
		try {
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage capture = new Robot().createScreenCapture(screenRect);
			ImageIO.write(capture, "png", new File(newPath));
		} catch (IOException | AWTException ex) {
			Report.log(Status.WARNING, "Erro ao capturar ScreenShot: " + ex.getMessage());
		}
		return newPath.replace("./reports/", "");
	}
	
	public static String captureRegion(int x, int y, int w, int h) {
		String newPath = PATH + DateTimeUtils.getTimeStampWithoutFormat() + ".png";
		try {
			Rectangle rectangle = new Rectangle(x, y, w, h);
			BufferedImage capture = new Robot().createScreenCapture(rectangle);
			ImageIO.write(capture, "png", new File(newPath));
		} catch (IOException | AWTException ex) {
			Report.log(Status.WARNING, "Erro ao capturar ScreenShot: " + ex.getMessage());
		}
		return newPath.replace("./reports/", "");
	}
	
	private static String saveImageFile(File source, String path) {
		try {
	        FileUtils.copyFile(source, new File(path)); 
	    } catch(IOException ex) {
	    	Report.log(Status.FAIL, "Erro ao capturar ScreenShot: " + ex.getMessage());
	    }
	    return path.replace("./reports/", "");
	}
}