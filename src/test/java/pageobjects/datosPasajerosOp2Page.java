package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

public class datosPasajerosOp2Page extends util {

    public datosPasajerosOp2Page() {
        PageFactory.initElements(driver, this);
    }

    public void ingresarNombre(int i, String valor){
        i++;
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("formPasajero"+i+"-nomPasajero"))));
        driver.findElement(By.id("formPasajero"+i+"-nomPasajero")).sendKeys(valor);
    }

    public void ingresarApellido(int i, String valor){
        i++;
        driver.findElement(By.id("formPasajero"+i+"-apePasajero")).sendKeys(valor);
    }

    public void ingresarFecha(int i, String valor){
        i++;
        driver.findElement(By.id("formPasajero"+i+"-fecNacimiento")).click();
        datepicker3(valor);
    }

    public void seleccionarNacionalidad(int i, String valor){
        i++;
        new Select(driver.findElement(By.id("formPasajero"+i+"-idPais"))).selectByVisibleText(valor);
    }

    public void seleccionarTipoDocumento(int i, String valor){
        i++;
        new Select(driver.findElement(By.id("formPasajero"+i+"-idDocumentoIdentidad"))).selectByVisibleText(valor);
    }

    public void ingresarDocumento(int i, String valor){
        i++;
        driver.findElement(By.id("formPasajero"+i+"-numDocumentoIdentidad")).sendKeys(valor);
    }

    public void seleccionarGenero(int i, String valor){
        i++;
        new Select(driver.findElement(By.id("formPasajero"+i+"-idSexo"))).selectByVisibleText(valor);
    }

    public void ingresarTelefono(int i, String valor){
        i++;
        driver.findElement(By.id("formPasajero"+i+"-numTelefono")).sendKeys(valor);
    }

    public void ingresarEmail(int i, String valor){
        i++;
        driver.findElement(By.id("formPasajero"+i+"-desEmail")).sendKeys(valor);
    }

    public void ingresarConfirmarEmail(int i, String valor){
        i++;
        driver.findElement(By.id("formPasajero"+i+"-desEmailConfirmacion")).sendKeys(valor);
    }

    public void aceptarPromociones(int i, String valor){
        i++;
        driver.findElement(By.id("formPasajero"+i+"-recibirNovedades")).click();
    }
}
