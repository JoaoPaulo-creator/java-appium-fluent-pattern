package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.BasePage;

public class CadastroFormulario extends BasePage{

    public CadastroFormulario(AndroidDriver<MobileElement> driver) {
        super(driver);             
    }

    @AndroidFindBy(className = "android.widget.EditText")
    MobileElement campoNome;

    public void escreverNome(String nome){
        try {
            aguardarElementoAparecer(campoNome);
            escrever(campoNome, nome);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    
}
