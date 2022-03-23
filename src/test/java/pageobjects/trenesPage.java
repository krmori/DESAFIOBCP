package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class trenesPage extends util {
    @FindBy(id = "text_btn_search") protected WebElement btn_search;
    @FindBy(name = "one_way_departure_station_name") protected WebElement lbl_salida;
    @FindBy(xpath = "//*[@value='Continue']") protected WebElement btn_continue;

    public trenesPage() {
        PageFactory.initElements(driver, this);
    }

    public void buscartickets(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_search));
        btn_search.click();
    }

    public void seleccionarTickets(String ticketIda, String ticketRegreso){
        wait.until(ExpectedConditions.visibilityOf(lbl_salida));
        if (!ticketIda.equals("")){
            driver.findElement(By.xpath("//*[contains(text(),'"+ticketIda+"')]")).click();
        }
        if (!ticketRegreso.equals("")){
            driver.findElement(By.xpath("//*[contains(text(),'"+ticketRegreso+"')]")).click();
        }
    }

    public void clickContinuar(){
        btn_continue.click();
    }
}
