package automationPractice;

import org.junit.jupiter.api.Test;
import page.AutenticacaoPage;
import page.CriarContaPage;
import page.HomePage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriarConta {
   HomePage home = new HomePage();
   AutenticacaoPage autenticacao = new AutenticacaoPage();
   CriarContaPage criarConta = new CriarContaPage();

   @Test
public void novaConta(){
       var email="emailTexte@teste.com.br";
       var firstName="Fulano de tal";
       var lastName="da Silva";
    home.acessarSite();
    home.btnSigIn();
    autenticacao.emailParaNovaConta(email);
    autenticacao.btnCreateAnAccount();
    criarConta.radioMr();
    criarConta.firstName(firstName);
    criarConta.lastName(lastName);
    assertEquals(email,criarConta.email());
    criarConta.emailTab(); // serve para habilitar o vist no campo
    criarConta.password("123456");
    criarConta.dia("1  ");
    criarConta.mes("October ");
    criarConta.ano("1985  ");
    assertEquals(firstName,criarConta.firstName2());// tem que ver o que será comparado
    assertEquals(lastName,criarConta.lastName2());// tem que ver o que será comparado
    criarConta.company("Tabajara");
    criarConta.address("Rua abcd 123456");
    criarConta.address2("Endereço 2");
    criarConta.city("Rio de Janeiro");
    criarConta.state("Florida");
    criarConta.zipCode("12345");
    criarConta.country("United States");
    criarConta.additionalInf("Preenchendo campo informações adicionais");
    criarConta.mobilePhone("221212121");
    criarConta.futureReference("Avenida abcd 1234567");



   }
}
