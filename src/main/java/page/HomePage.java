package page;

import estrutura.Basic;
import org.openqa.selenium.By;

import java.io.IOException;

public class HomePage extends Basic {
    public void acessarSite (){
        acessar("http://automationpractice.com");
    }
    public void btnSigIn() throws IOException {
        printarTela("cliqueEmSignin");
        clicar(By.linkText("Sign in"));
    }
    public void finalizar(){
        fecharNavegador();
    }


}
