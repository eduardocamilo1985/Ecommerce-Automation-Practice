package page;

import estrutura.Basic;
import org.openqa.selenium.By;

public class AutenticacaoPage extends Basic {
    public String mensagemContaExistente= "An account using this email address has already been registered. Please enter a valid password or request a new one.";

    public void emailParaNovaConta(String texto) {
        esperaImplicita(By.id("email_create"));
        escrever(By.id("email_create"), texto);
    }

    public void emailParaContaExistente(String texto) {

        escrever(By.id("email"), texto);
    }

    public void senha(String senha) {

        escrever(By.id("passwd"), senha);
    }

    public void btnSigIn() {

        clicar(By.id("SubmitLogin"));
    }

    public void btnCreateAnAccount() {

        clicar(By.id("SubmitCreate"));
    }

    public String verificarMensagemContaExistente() throws InterruptedException {
        esperaImplicitaClasse(By.xpath("//div[@class='alert alert-danger']"));
        Thread.sleep(2000); // TEM QUE REMOVER ISSO
        return obterTextoNaTela(By.xpath("//*[contains(text(),'An account using this email address')]"));
    }
}
