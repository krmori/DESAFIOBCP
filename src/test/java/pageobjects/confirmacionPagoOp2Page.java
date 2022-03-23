package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class confirmacionPagoOp2Page extends util {
    @FindBy(className = "title-confirmacion") protected WebElement lbl_titulo;
    @FindBy(id = "visa") protected WebElement rdb_visa;
    @FindBy(id = "terms") protected WebElement chk_term;
    @FindBy(id = "text_form_submit_payment") protected WebElement btn_pay;

    public confirmacionPagoOp2Page() {
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
        chk_term.click();
        chk_term.isSelected();
    }

    public void clickPagar(){
        btn_pay.click();
    }
}
