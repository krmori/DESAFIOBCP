package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

public class busquedaTicketsPage extends util {
    @FindBy(xpath = "//*[text()='Round trip']") protected WebElement rdb_roundTrip;
    @FindBy(xpath = "//*[text()='One Way']") protected WebElement rdb_oneWay;
    @FindBy(id = "destinoSelect") protected WebElement cmb_destination;
    @FindBy(id = "rutaSelect") protected WebElement cmb_route;
    @FindBy(id = "cbTrenSelect") protected WebElement cmb_train;
    @FindBy(id = "salida") protected WebElement date_salida;
    @FindBy(id = "regreso") protected WebElement date_regreso;
    @FindBy(id = "countParentsChildren") protected WebElement txt_countPassenger;
    @FindBy(id = "adultsSelect") protected WebElement txt_adults;
    @FindBy(id = "adultsDism") protected WebElement btn_adultsDism;
    @FindBy(id = "adultsAume") protected WebElement btn_adultsAume;
    @FindBy(id = "childrenSelect") protected WebElement txt_children;
    @FindBy(id = "childrenDism") protected WebElement btn_childrenDism;
    @FindBy(id = "childrenAume") protected WebElement btn_childrenAume;
    @FindBy(className = "cerrar-passanger") protected WebElement btn_cerrar;
    @FindBy(id = "error-inputs") protected WebElement lbl_errorMensaje;
    @FindBy(id = "btn_search") protected WebElement btn_search;

    public busquedaTicketsPage() {
        PageFactory.initElements(driver, this);
    }

    public void elegirTipoViaje(String tipo){
        if (tipo.toLowerCase().equals("one way")){
            wait.until(ExpectedConditions.visibilityOf(rdb_oneWay));
            rdb_oneWay.click();
            rdb_oneWay.isSelected();
        }else if (tipo.toLowerCase().equals("round trip")){
            wait.until(ExpectedConditions.visibilityOf(rdb_roundTrip));
            rdb_roundTrip.click();
            rdb_roundTrip.isSelected();
        }else{
            System.out.println("Debe elegir un tipo de viaje - one way o round trip");
        }
    }

    public void seleccionarDestino(String destino){
        wait.until(ExpectedConditions.visibilityOf(cmb_destination));
        new Select(cmb_destination).selectByVisibleText(destino);
    }

    public void seleccionarRuta(String ruta){
        wait.until(ExpectedConditions.visibilityOf(cmb_route));
        new Select(cmb_route).selectByVisibleText(ruta);
    }

    public void seleccionarTren(String tren){
        wait.until(ExpectedConditions.visibilityOf(cmb_train));
        new Select(cmb_train).selectByVisibleText(tren);
    }

    public void ingresarFechaSalida(){
        wait.until(ExpectedConditions.visibilityOf(date_salida));
        date_salida.sendKeys("");
    }

    public void ingresarFechaRegreso(String fecha){
            wait.until(ExpectedConditions.visibilityOf(date_regreso));
            date_regreso.sendKeys("");
    }

    public void ingresarPasajeros(){
        wait.until(ExpectedConditions.visibilityOf(txt_countPassenger));
        txt_countPassenger.click();
    }

    public void ingresarCantidadAdultos(String cantidad){
        wait.until(ExpectedConditions.visibilityOf(txt_adults));
        txt_adults.clear();
        txt_adults.sendKeys(cantidad);
    }

    public void ingresarCantidadNiños(String cantidad){
        if (!cantidad.equals("")){
            wait.until(ExpectedConditions.visibilityOf(txt_children));
            txt_children.clear();
            txt_children.sendKeys(cantidad);
        }
    }

    public void cerrarVentanaPasajeros(){
        wait.until(ExpectedConditions.visibilityOf(btn_cerrar));
        btn_cerrar.click();
    }

    public void clickBuscarTickets(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_search));
        btn_search.click();
    }

    public void validarMensajeError(){
        wait.until(ExpectedConditions.visibilityOf(lbl_errorMensaje));
        lbl_errorMensaje.isDisplayed();
    }
}
