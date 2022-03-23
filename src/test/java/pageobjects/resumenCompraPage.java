package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

import static pageobjects.elegirCabinaPage.subTotal;

public class resumenCompraPage extends util
{
    @FindBy(xpath = "//*[@id='compra']/a/img") protected WebElement lnk_purchase;
    @FindBy(id = "priceUSDrc") protected WebElement lbl_price;

    public resumenCompraPage()
    {
        PageFactory.initElements(driver, this);
    }

    public void clickResumen()
    {
        wait.until(ExpectedConditions.visibilityOf(lnk_purchase));
        lnk_purchase.click();
    }

    public void validarPrecioCompra()
    {
        wait.until(ExpectedConditions.visibilityOf(lbl_price));
        Assert.assertEquals(subTotal, lbl_price.getText());
    }
}
