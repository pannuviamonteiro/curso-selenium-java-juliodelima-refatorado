package framework.tools;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.StatusConfigurator;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import framework.utils.DateTimeUtils;

public class Report {
	private static final String DEFAULT_DESCRIPTION = "DBSERVER TEST SUITE";
	private static final String DEFAULT_PATH = "./reports/report_%s.html";
	private static ExtentReports extentReport;
	private static ExtentTest logger;
	
	public static void create(String title, String description) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(getNewReportPath());
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle(title);
		htmlReporter.config().setReportName(description);
		htmlReporter.config().setEncoding("UFT-8");
		htmlReporter.config().setCSS(".nav-wrapper { background-color: #1E317A !important; } .brand-logo { padding: 0 10px 0 0 !important; margin: 0 !important; position: absolute !important } .report-name { margin-left: 80px !important } .blue.darken-3 { background-color: #1E317A !important; color: #FFF !important;  }");
		htmlReporter.config().setJS("$('.brand-logo').html('<img src=\"https://i.imgur.com/qDYwkD2.png\" class=\"db-logo\"/>');");
		
		defineStatusHierarchy();
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
	}

	public static void startTest(String testDescription) {
		if(extentReport == null) {
			create(DEFAULT_DESCRIPTION, testDescription);
		}
		
		logger = extentReport.createTest(testDescription);
	}

	public static void log(Status logStatus, String message, String imagePath) {		
		try {
			if(logger == null) {
				startTest(DEFAULT_DESCRIPTION);
			}
			
			logger.log(logStatus, message, MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
		} catch (IOException ex) {
			logger.log(logStatus, message + " (Screenshot fail)");
		}
	}

	public static void log(Status logStatus, String message) {		
		if(logger == null) {
			startTest(DEFAULT_DESCRIPTION);
		}
		
		logger.log(logStatus, message);
	}

	public static void log(String message, String imagePath) {
		log(Status.INFO, message, imagePath);
	}

	public static void log(String message) {
		log(Status.INFO, message);
	}

	public static void logPass(String message, String imagePath) {
		log(Status.PASS, message, imagePath);
	}

	public static void logPass(String message) {
		log(Status.PASS, message);
	}

	public static void logFail(String message, String imagePath) {
		log(Status.FAIL, message, imagePath);
	}

	public static void logFail(String message) {
		log(Status.FAIL, message);
	}
	
	public static void close() {
		if(extentReport != null) {
			extentReport.flush();
		} else {
			startTest("O TestCase passou!");
			log(Status.INFO, "O teste encerrou.");
			close();
		}
	}

	private static void defineStatusHierarchy() {
		List<Status> statusHierarchy = Arrays.asList(
                Status.FATAL,
                Status.FAIL,
                Status.ERROR,
                Status.PASS,
                Status.WARNING,
                Status.SKIP,
                Status.INFO,
                Status.DEBUG);
		StatusConfigurator.getInstance().setStatusHierarchy(statusHierarchy);
	}

	private static String getNewReportPath() {
		return String.format(DEFAULT_PATH, DateTimeUtils.getDateTimeFormatReport());
	}
}