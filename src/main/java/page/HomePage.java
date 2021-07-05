package page;

import estrutura.Basic;
import org.openqa.selenium.By;

public class HomePage extends Basic {
    public void acessarSite (){
        acessar("http://automationpractice.com");
    }
    public void btnSigIn(){
        clicar(By.linkText("Sign in"));
    }
    public void finalizar(){
        finalizarDriver();
    }


}
