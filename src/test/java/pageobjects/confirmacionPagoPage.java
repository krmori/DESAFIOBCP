package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class confirmacionPagoPage extends util {
    @FindBy(className = "title-pasajero") protected WebElement lbl_titulo;
    @FindBy(id = "visa") protected WebElement rdb_visa;
    @FindBy(id = "chk_tercon") protected WebElement rdb_term;
    @FindBy(id = "ingresar_tarjeta") protected WebElement btn_numeroTarjeta;

    public confirmacionPagoPage() {
        PageFactory.initElements(driver, this);
    }

    public void validarTitulo(){
        wait.until(ExpectedConditions.visibilityOf(lbl_titulo));
        lbl_titulo.isDisplayed();
    }

    public void seleccionarMedioPago(String pago){
        if (pago.toLowerCase().equals("visa")){
            rdb_visa.click();
            rdb_visa.isSelected();
        }
    }

    public void aceptarTerminos(){
        rdb_term.click();
        rdb_term.isSelected();
    }

    public void clickIngresarNroTarjeta(){
        btn_numeroTarjeta.click();
    }
}
