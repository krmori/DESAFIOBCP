package support;

import definitions.hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class util extends hooks {
    public static WebDriverWait wait;
    @FindBy(xpath = "//*[text()='Next']") protected WebElement btn_nextMonth;
    @FindBy(className = "ui-datepicker-month") protected WebElement lbl_month;
    @FindBy(className = "ui-datepicker-year") protected WebElement lbl_year;
    @FindBy(id = "calendario_mes") protected WebElement cmb_month;
    @FindBy(id = "calendario_anio") protected WebElement cmb_year;

    public util() {
        wait = new WebDriverWait(driver, 30);
    }

    public void datepicker(String fecha){
        String mes = "";
        String[] date = fecha.split("-");
        switch (date[1]){
            case "01":
                mes = "January";
                break;
            case "02":
                mes = "February";
                break;
            case "03":
                mes = "March";
                break;
            case "04":
                mes = "April";
                break;
            case "05":
                mes = "May";
                break;
            case "06":
                mes = "June";
                break;
            case "07":
                mes = "July";
                break;
            case "08":
                mes = "August";
                break;
            case "09":
                mes = "September";
                break;
            case "10":
                mes = "October";
                break;
            case "11":
                mes = "November";
                break;
            case "12":
                mes = "December";
                break;
        }
        wait.until(ExpectedConditions.visibilityOf(lbl_month));
        if (lbl_month.getText().equals(mes)){
            driver.findElement(By.xpath("//*[text()='"+date[0]+"']")).click();
        }else{
            while (!lbl_month.getText().equals(mes)){
                btn_nextMonth.click();
            }
            driver.findElement(By.xpath("//*[text()='"+date[0]+"']")).click();
        }
    }

    public void datepicker2(String fecha){
        String[] date = fecha.split("-");
        wait.until(ExpectedConditions.visibilityOf(lbl_month));
        new Select(lbl_month).selectByValue(date[1].replace("0",""));
        new Select(lbl_year).selectByVisibleText(date[2]);
        driver.findElement(By.xpath("//*[text()='"+date[0]+"']")).click();
    }

    public void datepicker3(String fecha){
        String[] date = fecha.split("-");
        wait.until(ExpectedConditions.visibilityOf(cmb_month));
        new Select(cmb_month).selectByValue(date[1].replace("0",""));
        new Select(cmb_year).selectByVisibleText(date[2]);
        driver.findElement(By.xpath("//a[text()='"+date[0]+"']")).click();
    }

    public void evidencia() throws IOException {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_HHmmssSSS");

        String path="E:\\Evidencias\\";
        String nombre=formato.format(fecha)+"_screenshot.jpg";

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(path+nombre));
    }
}
