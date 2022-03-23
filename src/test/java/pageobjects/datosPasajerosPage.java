package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

import java.util.List;

public class datosPasajerosPage extends util {
    @FindBy(xpath = "//div[contains(@id,'divcab')]") public static List<WebElement> div_cabina;
    @FindBy(id = "btnContinuarPas") protected WebElement btn_continue;

    public datosPasajerosPage() {
        PageFactory.initElements(driver, this);
    }

    public void ingresarNombre(int i, int j, String valor){
        j++;
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='divcab-"+i+"']/div[2]/div["+j+"]/div[2]/input[1]"))));
        driver.findElement(By.xpath("//*[@id='divcab-"+i+"']/div[2]/div["+j+"]/div[2]/input[1]")).sendKeys(valor);
    }

    public void ingresarApellido(int i, int j, String valor)
    {
        j++;
        driver.findElement(By.xpath("//*[@id='divcab-"+i+"']/div[2]/div["+j+"]/div[2]/input[2]")).sendKeys(valor);
    }

    public void ingresarFecha(int i, int j, String valor)
    {
        j++;
        driver.findElement(By.xpath("//*[@id='divcab-"+i+"']/div[2]/div["+j+"]/div[2]/input[3]")).sendKeys("");
        datepicker2(valor);
    }

    public void seleccionarNacionalidad(int i, int j, String valor)
    {
        j++;
        new Select(driver.findElement(By.xpath("//*[@id='divcab-"+i+"']/div[2]/div["+j+"]/div[2]/select[1]"))).selectByVisibleText(valor);
    }

    public void seleccionarTipoDocumento(int i, int j, String valor)
    {
        j++;
        new Select(driver.findElement(By.xpath("//*[@id='divcab-"+i+"']/div[2]/div["+j+"]/div[2]/select[2]"))).selectByVisibleText(valor);
    }

    public void ingresarDocumento(int i, int j, String valor)
    {
        j++;
        driver.findElement(By.xpath("//*[@id='divcab-"+i+"']/div[2]/div["+j+"]/div[2]/input[4]")).sendKeys(valor);
    }

    public void seleccionarGenero(int i, int j, String valor){
        j++;
        new Select(driver.findElement(By.xpath("//*[@id='divcab-"+i+"']/div[2]/div["+j+"]/div[2]/select[3]"))).selectByVisibleText(valor);
    }

    public void ingresarTelefono(int i, int j, String valor){
        j++;
        driver.findElement(By.xpath("//*[@id='divcab-"+i+"']/div[2]/div["+j+"]/div[2]/div/input")).sendKeys(valor);
    }

    public void ingresarEmail(int i, int j, String valor){
        j++;
        driver.findElement(By.xpath("//*[@id='divcab-"+i+"']/div[2]/div["+j+"]/div[2]/input[5]")).sendKeys(valor);
    }

    public void ingresarConfirmacionEmail(int i, int j, String valor){
        j++;
        driver.findElement(By.xpath("//*[@id='divcab-"+i+"']/div[2]/div["+j+"]/div[2]/input[6]")).sendKeys(valor);
    }

    public void aceptarPromociones(int i, int j, String valor){
        j++;
        if (valor.toLowerCase().equals("si")){
            driver.findElement(By.xpath("//*[@id='divcab-"+i+"']/div[2]/div["+j+"]/div[2]/label/input")).click();
        }
    }

    public void clickContinuar(){
        btn_continue.click();
    }
}
