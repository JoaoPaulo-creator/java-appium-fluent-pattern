package utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class BasePage {

    protected AndroidDriver<MobileElement> driver;

    public BasePage(AndroidDriver<MobileElement> driver2){
        this.driver = driver2;
        PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
    }

    protected boolean aguardarElementoAparecer(MobileElement element){
        boolean isElementVisible = false;
        
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));        
        if(element.isDisplayed()){
            isElementVisible = true;
        }
        return isElementVisible;
    }

    private void aguardarElementoSerClicavel(MobileElement element){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void clicar(MobileElement botao){
        try {
            aguardarElementoSerClicavel(botao);
            if(botao.isDisplayed() && botao.isEnabled()){
                botao.click();
            }
        } catch (Exception e) {
            throw new NoSuchElementException("Elemento não encontrado!!!");
        }
    }

    protected void escrever(MobileElement element, String assunto){
        element.sendKeys(assunto);
    }
}
