import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pages.TelaInicialPage;
import setupTeste.ConfiguracoesDoTeste;

public class TesteCadastroSeuBarrigaNativo extends ConfiguracoesDoTeste{

    @Test(dataProvider = "informarDadosCadastro")
    public void deveCadastrarEmSeuBarrigaNativo(String nome, String senha){
        TelaInicialPage telaInicial = new TelaInicialPage(driver);
        
        String validarLogin = telaInicial.clicarEmSeuBarrigaNativo()
            .escreverNomeUsuario(nome)
            .escreverSenhaUsuario(senha)
            .clicarBtnEntrar()
            .capturarMensagemErro();


        assertEquals(validarLogin, "Problemas com o login");

    }

    
    @DataProvider
    public Object[][] informarDadosCadastro(){
        return new Object[][]{
            {"Ze da Silva", "123abc"}
        };
    }

    
}
