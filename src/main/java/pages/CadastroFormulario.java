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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SALVAR']")
    MobileElement btnSalvar;

    public CadastroFormulario escreverNome(String nome){
        try {
            aguardarElementoAparecer(campoNome);
            escrever(campoNome, nome);            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public void clicarBtnSalvar(){
        try {
            clicar(btnSalvar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
