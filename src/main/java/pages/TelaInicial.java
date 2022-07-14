package pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.BasePage;

public class TelaInicial extends BasePage{

    public TelaInicial(AndroidDriver<MobileElement> driver) {
        super(driver);     
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Formulário']")
    MobileElement formulario;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SeuBarriga Nativo']")
    MobileElement seuBarrigaNativo;

    public CadastroFormulario clicarFormulario()    {
      try {
        aguardarElementoAparecer(formulario);
        clicar(formulario);
      } catch (Exception e) {
        System.out.println("Erro: " +e.getMessage());
      } 

      return new CadastroFormulario(driver);
    }

    public SeuBarrigaNativo clicarEmSeuBarrigaNativo(){
      try {
        aguardarElementoAparecer(seuBarrigaNativo);
        clicar(seuBarrigaNativo);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return new SeuBarrigaNativo(driver);
    }

    
}
