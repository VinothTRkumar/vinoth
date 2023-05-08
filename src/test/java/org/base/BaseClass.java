package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.constant.Constable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



import io.github.bonigarcia.wdm.WebDriverManager;

//import com.google.common.collect.Table.Cell;

public class BaseClass {
	public static WebDriver driver;
	
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	public static void WindowMaximize() {
		driver.manage().window().maximize();
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	public static String pageTitle() {
		String title=driver.getTitle();
		return  title;
		//System.out.println(title);
	}
	
	public static String pageUrl() {
		String url=driver.getCurrentUrl();
		return url;
		//System.out.println(url);
	}
	
	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);
	}
	public static void closeEntireBrowser() {
		driver.quit();
	}
	
	public static void clickBtn(WebElement ele) {
		ele.click();
	}
	
	public static void screenShot(String imgName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File imge=ts.getScreenshotAs(OutputType.FILE);
		File f=new File("location+ imgName.png");
		FileUtils.copyFile(imge,f);
		
	}
	
	public static Actions a;
	
	public static void moveTheCursor(WebElement targetWebElement) {
		a=new Actions(driver);
		a.moveToElement(targetWebElement).perform();
	}
	
	public static void dragDrop(WebElement dragWebElement, WebElement dropElement) {
		a=new Actions(driver);
		a.dragAndDrop(dragWebElement, dropElement);
	}
	
	public static JavascriptExecutor js;
	
	public static void scrollThePage(WebElement tarWebEle ) {
		js=(JavascriptExecutor) driver;  
		js.executeScript("arguments(0).scrollIntoView(true)", tarWebEle );
	}
	
	public static void scroll(WebElement element ) {
		js=(JavascriptExecutor) driver;  
		js.executeScript("arguments(0).scrollIntoView(false)", element );
	}

	public static void excelRead(String sheetName,int rowNum,int cellNum) throws IOException {
		File f=new File("C:\\Users\\vinot\\eclipse-workspace\\.metadata\\.plugins\\Datadrivensam\\Excel\\newfile.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
		Sheet mySheet =wb.getSheet("Data");
		Row r=mySheet.getRow(rowNum);
		org.apache.poi.ss.usermodel.Cell c=r.getCell(cellNum);
		int cellType=c.getCellType();
		
		String value=" ";
		
		if(cellType==1) {
			String value2=c.getStringCellValue();
		}
		else if(DateUtil.isCellDateFormatted(c)) {
			Date dd=c.getDateCellValue();
			SimpleDateFormat s=new SimpleDateFormat(value);
			String value1=s.format(dd);
		}
		
		else {
			double d=c.getNumericCellValue();
			long l=(long)d;
			String valueOf=String.valueOf(l);
		}	
	
	}
	public static void createNewExcleFile(int rowNum, int cellNum, String newData) throws IOException {
		File f=new File("C:\\Users\\vinot\\eclipse-workspace\\.metadata\\.plugins\\Datadrivensam\\Excel\\newfile.xlsx");
		XSSFWorkbook w=new XSSFWorkbook();
		Sheet newsheet=w.createSheet("Data1");
		Row newRow=newsheet.createRow(rowNum);
		Cell newCell=newRow.createCell(cellNum);
		newCell.setCellValue(newData);
		FileOutputStream fos=new FileOutputStream(f);
		w.write(fos);
	}
	
	public static void createCell(int getRow, int creCell,String newData) throws IOException {
		File f=new File("C:\\Users\\vinot\\eclipse-workspace\\.metadata\\.plugins\\Datadrivensam\\Excel\\newfile.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		Sheet s=w.getSheet("Data1");
		Row r=s.getRow(getRow);
		Cell c=r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos=new FileOutputStream(f);
		w.write(fos);
	}
	
	public static void createRow(int creRow,int creCell,String newData) throws IOException {
		File f=new File("C:\\Users\\vinot\\eclipse-workspace\\.metadata\\.plugins\\Datadrivensam\\Excel\\newfile.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		Sheet s=w.getSheet("Data1");
		Row r=s.createRow(creRow);
		Cell c=r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos=new FileOutputStream(f);
		w.write(fos);
	}
	
	public static void updateDataToparticularCell(int getTheRow,int getThecell,String exisitingData,String writeNewData) throws IOException {
		File f=new File("C:\\Users\\vinot\\eclipse-workspace\\.metadata\\.plugins\\Datadrivensam\\Excel\\newfile.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
		Sheet mySheet =wb.getSheet("Data1");
		Row r=mySheet.getRow(getTheRow);
		Cell c=r.getCell(getThecell);
		String str=c.getStringCellValue();
		if(str.equals(exisitingData)) {
			c.setCellValue(writeNewData);
		}
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
	}
}
