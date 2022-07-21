package pages;

import java.util.NoSuchElementException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.BasePage;

public class SeuBarrigaNativoPage extends BasePage{

    public SeuBarrigaNativoPage(AndroidDriver<MobileElement> driver2) {
        super(driver2);     
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Nome']")
    MobileElement campoNome;
    
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Senha']")
    MobileElement campoSenha;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Problemas com o login']")
    MobileElement mensagemProblemasComLogin;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ENTRAR']")
    MobileElement btnEntrar;

    public SeuBarrigaNativoPage escreverNomeUsuario(String nome){
        try {
            aguardarElementoAparecer(campoNome);
            escrever(campoNome, nome);    
        } catch (Exception e) {
            throw new NoSuchElementException("Elemento " + campoNome + " não encontrado");
        }
        return this;
    }

    public SeuBarrigaNativoPage escreverSenhaUsuario(String senha){
        escrever(campoSenha, senha);
        return this;
    }

    public SeuBarrigaNativoPage clicarBtnEntrar(){
        clicar(btnEntrar);
        return this;
    }

    public String capturarMensagemErro(){
        return mensagemProblemasComLogin.getText().trim();
    }
}
