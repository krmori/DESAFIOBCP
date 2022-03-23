package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

import java.util.List;


public class elegirCabinaPage extends util
{
    @FindBy(className = "btn-container") protected List<WebElement> lbl_cabina;
    @FindBy(name = "selectRooms[suite]") protected WebElement cmb_roomSuite;
    @FindBy(name = "selectRooms[twin]") protected WebElement cmb_roomTwin;
    @FindBy(name = "selectRooms[bunk]") protected WebElement cmb_roomBunk;
    @FindBy(xpath = "//span[text()='ADULTS']/following-sibling::select") protected List<WebElement> cmb_adults;
    @FindBy(xpath = "//span[text()='CHILDREN']/following-sibling::select") protected List<WebElement> cmb_children;
    @FindBy(xpath = "//div[@class='col2']/span[text()='USD ']/child::span") protected WebElement lbl_subtotal;
    @FindBy(id = "continuar_bae") protected WebElement btn_continue;
    public static String subTotal;

    public elegirCabinaPage()
    {
        PageFactory.initElements(driver, this);
    }

    public void validarMensajeCabinaDisponible(String mensaje)
    {
        if (!mensaje.equals("")){
            for (int i=0; i<lbl_cabina.size();i++){
                wait.until(ExpectedConditions.visibilityOf(lbl_cabina.get(i)));
                Assert.assertEquals("No cabins available for the selected date", lbl_cabina.get(i).getText());
            }
        }
    }

    public void seleccionarCabinas(String tipo_cabina, String cabina)
    {
        if (tipo_cabina.toLowerCase().equals("suite cabins")){
            new Select(cmb_roomSuite).selectByValue(cabina);
        }else if (tipo_cabina.toLowerCase().equals("twin bed cabins")){
            new Select(cmb_roomTwin).selectByValue(cabina);
        }else if (tipo_cabina.toLowerCase().equals("bunk bed cabins")){
            new Select(cmb_roomBunk).selectByValue(cabina);
        }
    }

    public void seleccionarCantidadPasajerosAdultos(String cantidad)
    {
        String[] pasajeros = cantidad.split(",");
        wait.until(ExpectedConditions.visibilityOf(cmb_adults.get(0)));
        for (int i=0; i<cmb_adults.size();i++){
            new Select(cmb_adults.get(i)).selectByVisibleText(pasajeros[i]);
        }
    }

    public void seleccionarCantidadPasajerosNinos(String cantidad)
    {
        String[] pasajeros = cantidad.split(",");
        wait.until(ExpectedConditions.visibilityOf(cmb_children.get(0)));
        for (int i=0; i<cmb_children.size();i++){
            if (!pasajeros[i].equals("0")){
                new Select(cmb_children.get(i)).selectByVisibleText(pasajeros[i]);
            }
        }
    }

    public void obtenerSubTotal()
    {
        subTotal=lbl_subtotal.getText();
    }

    public void clickContinuar()
    {
        wait.until(ExpectedConditions.elementToBeClickable(btn_continue));
        btn_continue.click();
    }
}
