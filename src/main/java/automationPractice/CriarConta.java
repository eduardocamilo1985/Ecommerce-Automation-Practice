package automationPractice;

import estrutura.EvidenciaWord;
import estrutura.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.AutenticacaoPage;
import page.CriarContaPage;
import page.HomePage;
import page.MyAccountPage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriarConta {
    Util utilidades = new Util();
    String email = utilidades.email();
    String firstName = utilidades.name();
    String lastName = utilidades.lastName();
    EvidenciaWord gerarEvidencia = new EvidenciaWord();
    HomePage home = new HomePage();
    AutenticacaoPage autenticacao = new AutenticacaoPage();
    CriarContaPage criarConta = new CriarContaPage();
    MyAccountPage myAcconunt = new MyAccountPage();

    @BeforeEach  //
    public void coisasComunsTeste() throws IOException {
        home.acessarSite();
        home.btnSigIn();
        autenticacao.emailParaNovaConta(email);
        autenticacao.btnCreateAnAccount();
    }

    @AfterEach
    public void finalizaDriver() {
        home.finalizar();
    }

    @Test
    public void criarContaEmailJaCadastrado() throws InterruptedException {
        assertEquals(autenticacao.mensagemContaExistente, autenticacao.verificarMensagemContaExistente());
    }

    @Test
    public void criarContaSemCamposObrigatorios() throws Exception {

        criarConta.radioMr();
        criarConta.dia("1  ");
        criarConta.mes("October ");
        criarConta.ano("1985  ");
        criarConta.company(utilidades.company());
        criarConta.address2(utilidades.address());
        criarConta.additionalInf(utilidades.inf());
        criarConta.homePhone(utilidades.phone());
        criarConta.btnRegister();
        assertEquals(criarConta.mensagemFirstNameRequired, criarConta.firstNameRequired());
        assertEquals(criarConta.mensagemLastNameRequired, criarConta.lastNameRequired());
        assertEquals(criarConta.mensagemPasswdRequired, criarConta.passwdRequired());
        assertEquals(criarConta.mensagemAddress1Required, criarConta.address1Required());
        assertEquals(criarConta.mensagemcityRequired, criarConta.cityRequired());
        assertEquals(criarConta.mensagemStateRequired, criarConta.stateRequired());
        assertEquals(criarConta.mensagemZipInvalid, criarConta.zipCodeRequired());
        assertEquals(criarConta.mensagemMobilePhoneRequired, criarConta.mobilePhoneRequired());
        gerarEvidencia.geraEvidenciaContaSemCamposObrigatorios("Não cadastra sem preencher campos obrigatórios");

    }

    @Test
    public void criarContaCamposObrigatorios() throws Exception {
        //cria conta somente com os campos obrigatorios.

        criarConta.firstName(firstName);
        criarConta.lastName(lastName);
        assertEquals(email, criarConta.email());
        criarConta.emailTab(); // serve para habilitar o visto no campo
        criarConta.password("123456");
        assertEquals(firstName, criarConta.firstName2());
        assertEquals(lastName, criarConta.lastName2());
        criarConta.address(utilidades.address());
        criarConta.city(utilidades.city());
        criarConta.state("Florida");
        criarConta.zipCode(utilidades.zipCode());
        criarConta.country("United States");
        criarConta.mobilePhone(utilidades.phone());
        criarConta.btnRegister();
        assertEquals(myAcconunt.mensagemDeSucessoCriacaoConta, myAcconunt.verificaMensagemSucesso());
        gerarEvidencia.geraEvidenciaContaSoCamposObrigatorios("Realiza o cadastro preenchendo somente os campos obrigatórios");
    }

    @Test
    public void criarContaVerificacaoCompleta() throws Exception {
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
        criarConta.company(utilidades.company());

        criarConta.btnRegister();
        assertEquals(criarConta.mensagemAddress1Required, criarConta.address1Required());
        criarConta.address(utilidades.address());
        //criarConta.address2(utilidades.address());

        criarConta.btnRegister();
        assertEquals(criarConta.mensagemcityRequired, criarConta.cityRequired());
        criarConta.city(utilidades.city());
        criarConta.country("-");

        criarConta.btnRegister();
        assertEquals(criarConta.mensagemCountryInvalid, criarConta.countryInvalid());
        criarConta.country("United States");
        criarConta.additionalInf(utilidades.inf());
        criarConta.homePhone(utilidades.phone());

        criarConta.btnRegister();
        assertEquals(criarConta.mensagemZipInvalid, criarConta.zipCodeRequired());
        criarConta.zipCode(utilidades.zipCode());

        criarConta.btnRegister();
        assertEquals(criarConta.mensagemStateRequired, criarConta.stateRequired());
        criarConta.state("Florida");

        criarConta.btnRegister();
        assertEquals(criarConta.mensagemPasswdRequired, criarConta.passwdRequired());
        assertEquals(criarConta.mensagemMobilePhoneRequired, criarConta.mobilePhoneRequired());
        criarConta.mobilePhone(utilidades.phone());
        criarConta.password("123456");
        criarConta.futureReference(utilidades.address());
        criarConta.btnRegister();
        assertEquals(myAcconunt.mensagemDeSucessoCriacaoConta, myAcconunt.verificaMensagemSucesso());
        gerarEvidencia.geraEvidenciaContaCompleta("Realiza o cadastro completo do usuário");

    }
}

