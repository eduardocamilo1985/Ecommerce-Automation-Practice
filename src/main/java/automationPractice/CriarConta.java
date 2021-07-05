package automationPractice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.AutenticacaoPage;
import page.CriarContaPage;
import page.HomePage;
import page.MyAccountPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriarConta {
    String email = "emailTeste@teste.com.br";
    String firstName = "Fulano de tal";
    String lastName = "da Silva";
    HomePage home = new HomePage();
    AutenticacaoPage autenticacao = new AutenticacaoPage();
    CriarContaPage criarConta = new CriarContaPage();
    MyAccountPage myAcconunt = new MyAccountPage();

    @BeforeEach  //
    public void coisasComunsTeste() {
        home.acessarSite();
        home.btnSigIn();
        autenticacao.emailParaNovaConta(email);
        autenticacao.btnCreateAnAccount();
    }
    @AfterEach
    public void finalizaDriver(){
        home.finalizar();
    }

    @Test
    public void criarContaEmailJaCadastrado() throws InterruptedException {
        assertEquals(autenticacao.mensagemContaExistente, autenticacao.verificarMensagemContaExistente());
    }

    @Test
    public void criarContaSemCamposObrigatorios() {

        criarConta.radioMr();
        criarConta.dia("1  ");
        criarConta.mes("October ");
        criarConta.ano("1985  ");
        criarConta.company("Tabajara");
        criarConta.address2("Endereço 2");
        criarConta.additionalInf("Preenchendo campo informações adicionais");
        criarConta.homePhone("12345678");
        criarConta.btnRegister();
        assertEquals(criarConta.mensagemFirstNameRequired, criarConta.firstNameRequired());
        assertEquals(criarConta.mensagemLastNameRequired, criarConta.lastNameRequired());
        assertEquals(criarConta.mensagemPasswdRequired, criarConta.passwdRequired());
        assertEquals(criarConta.mensagemAddress1Required, criarConta.address1Required());
        assertEquals(criarConta.mensagemcityRequired, criarConta.cityRequired());
        assertEquals(criarConta.mensagemStateRequired, criarConta.stateRequired());
        assertEquals(criarConta.mensagemZipInvalid, criarConta.zipCodeRequired());
        assertEquals(criarConta.mensagemMobilePhoneRequired, criarConta.mobilePhoneRequired());

    }

    @Test
    public void criarContaCamposObrigatorios() {
        //cria conta somente com os campos obrigatorios.

        criarConta.firstName(firstName);
        criarConta.lastName(lastName);
        assertEquals(email, criarConta.email());
        criarConta.emailTab(); // serve para habilitar o visto no campo
        criarConta.password("123456");
        assertEquals(firstName, criarConta.firstName2());
        assertEquals(lastName, criarConta.lastName2());
        criarConta.address("Rua abcd 123456");
        criarConta.city("Rio de Janeiro");
        criarConta.state("Florida");
        criarConta.zipCode("12345");
        criarConta.country("United States");
        criarConta.mobilePhone("221212121");
        criarConta.btnRegister();
        assertEquals(myAcconunt.mensagemDeSucessoCriacaoConta, myAcconunt.verificaMensagemSucesso());

    }

    @Test
    public void criarContaVerificacaoCompleta() {
        criarConta.radioMr();
        criarConta.btnRegister();
        assertEquals(criarConta.mensagemFirstNameRequired, criarConta.firstNameRequired());
        criarConta.firstName(firstName);

        criarConta.btnRegister();
        assertEquals(criarConta.mensagemLastNameRequired, criarConta.lastNameRequired());
        criarConta.lastName(lastName);

        assertEquals(email, criarConta.email());
        criarConta.emailTab(); // serve para habilitar o visto no campo

        criarConta.btnRegister();
        criarConta.dia("1  ");
        criarConta.mes("October ");
        criarConta.ano("1985  ");
        assertEquals(firstName, criarConta.firstName2());
        assertEquals(lastName, criarConta.lastName2());
        criarConta.company("Tabajara");

        criarConta.btnRegister();
        assertEquals(criarConta.mensagemAddress1Required, criarConta.address1Required());
        criarConta.address("Rua abcd 123456");
        // criarConta.address2("Endereço 2");

        criarConta.btnRegister();
        assertEquals(criarConta.mensagemcityRequired, criarConta.cityRequired());
        criarConta.city("Rio de Janeiro");
        criarConta.country("-");

        criarConta.btnRegister();
        assertEquals(criarConta.mensagemCountryInvalid, criarConta.countryInvalid());
        criarConta.country("United States");
        criarConta.additionalInf("Preenchendo campo informações adicionais");
        criarConta.homePhone("12345678");

        criarConta.btnRegister();
        assertEquals(criarConta.mensagemZipInvalid, criarConta.zipCodeRequired());
        criarConta.zipCode("12345");

        criarConta.btnRegister();
        assertEquals(criarConta.mensagemStateRequired, criarConta.stateRequired());
        criarConta.state("Florida");

        criarConta.btnRegister();
        assertEquals(criarConta.mensagemPasswdRequired, criarConta.passwdRequired());
        assertEquals(criarConta.mensagemMobilePhoneRequired, criarConta.mobilePhoneRequired());
        criarConta.mobilePhone("221212121");
        criarConta.password("123456");
        //criarConta.futureReference("Avenida abcd 1234567"); // verificar porque não tá alterando o texto
        criarConta.btnRegister();
        assertEquals(myAcconunt.mensagemDeSucessoCriacaoConta, myAcconunt.verificaMensagemSucesso());
    }
}

