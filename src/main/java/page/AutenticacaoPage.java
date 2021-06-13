package page;

import estrutura.Basic;
import org.openqa.selenium.By;

public class AutenticacaoPage extends Basic {
    public void emailParaNovaConta(String texto){
        esperaImplicita(By.id("email_create"));
        escrever(By.id("email_create"),texto);
    }

    public void emailParaContaExistente(String texto){
        escrever(By.id("email"),texto);
    }
    public void senha(String senha){
        escrever(By.id("passwd"),senha);
    }

    public void btnSigIn(){
        clicar(By.id("SubmitLogin"));
    }

    public void btnCreateAnAccount(){
        clicar(By.id("SubmitCreate"));
    }

    }
