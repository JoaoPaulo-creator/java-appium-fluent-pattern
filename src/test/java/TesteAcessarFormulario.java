
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TelaInicialPage;
import setupTeste.ConfiguracoesDoTeste;

public class TesteAcessarFormulario extends ConfiguracoesDoTeste{

    @Test(dataProvider = "nomeUsuarioCadastro")
    public void deveAcessarFormulario(String nomeUsuario){
        TelaInicialPage telaInicial = new TelaInicialPage(driver);
        telaInicial.clicarFormulario()
                .escreverNome(nomeUsuario)
                .clicarBtnSalvar();
    }

    @DataProvider
    private Object[][] nomeUsuarioCadastro(){
        return new Object[][]{
            {"Joao"}
        };
    }

    
}
