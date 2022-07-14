
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TelaInicial;
import setupTeste.ConfiguracoesDoTeste;

public class TesteAcessarFormulario extends ConfiguracoesDoTeste{

    @Test(dataProvider = "nomeUsuarioCadastro")
    public void deveAcessarFormulario(String nomeUsuario){
        TelaInicial telaInicial = new TelaInicial(driver);
        telaInicial.clicarFormulario()
                .escreverNome(nomeUsuario);
    }

    @DataProvider
    private Object[][] nomeUsuarioCadastro(){
        return new Object[][]{
            {"Joao"}
        };
    }

    
}
