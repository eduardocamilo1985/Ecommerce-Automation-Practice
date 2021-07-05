package page;

import estrutura.Basic;
import org.openqa.selenium.By;

public class MyAccountPage extends Basic {
    public String mensagemDeSucessoCriacaoConta = "Welcome to your account. Here you can manage all of your personal information and orders.";

    public String verificaMensagemSucesso() {
        return obterTextoNaTela(By.xpath("//*[contains(text(),'Welcome to your account.')]"));

    }
    public void btnOrderHistory(){
        clicar(By.linkText("Order history and details"));
    }
    public void btnMyCreditSlips(){
        clicar(By.linkText("My credit slips"));
    }
    public void btnMyAddresses(){
        clicar(By.linkText("My addresses"));
    }
    public void btnMyPersonalInformation(){
        clicar(By.linkText("My personal information"));
    }
    public void btnMyWishlists(){
        clicar(By.linkText("My wishlists"));
    }
    public void btnHome(){
        clicar(By.linkText("Home"));
    }

}
