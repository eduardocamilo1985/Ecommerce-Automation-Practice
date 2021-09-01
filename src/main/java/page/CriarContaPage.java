package page;

import estrutura.Basic;
import org.openqa.selenium.By;

import java.io.IOException;

public class CriarContaPage extends Basic {
    //Mensagens que devem aparecer quando um campo obrigatório não for preenchido
    public String mensagemCountryInvalid="Country is invalid";
    public String mensagemFirstNameRequired="firstname";
    public String mensagemLastNameRequired="lastname";
    public String mensagemPasswdRequired="passwd";
    public String mensagemAddress1Required="address1";
    public String mensagemcityRequired="city";
    public String mensagemZipInvalid="The Zip/Postal code you've entered is invalid. It must follow this format: 00000";
    public String mensagemStateRequired="This country requires you to choose a State.";
    public String mensagemMobilePhoneRequired="You must register at least one phone number.";

    public void radioMr() {
        esperaExplicita(By.id("id_gender1"));
        clicar(By.id("id_gender1"));
    }

    public void radioMrs() {
        clicar(By.id("id_gender2"));
    }

    public void firstName(String nome) {
        esperaExplicita(By.id("customer_firstname"));
        escrever(By.id("customer_firstname"), nome);
    }

    public void lastName(String ultimoNome) {

        escrever(By.id("customer_lastname"), ultimoNome);
    }

    public void emailTab() {

        teclarTab(By.id("email"));
    }

    public String email() {

        return obterTexto(By.id("email"));
    }

    public void password(String senha) {

        escrever(By.id("passwd"), senha);
    }

    public void dia(String dia) {

        selecionarTexto(By.id("days"), dia);
    }

    public void mes(String mes) {
        selecionarTexto(By.id("months"), mes);

    }

    public void ano(String ano) {

        selecionarTexto(By.id("years"), ano);
    }

    public String firstName2() {

        return obterTexto(By.id("firstname"));
    }

    public String lastName2() {

        return obterTexto(By.id("lastname"));
    }

    public void company(String empresa) {

        escrever(By.id("company"), empresa);
    }

    public void address(String endereco) {

        escrever(By.id("address1"), endereco);
    }

    public void address2(String endereco) {

        escrever(By.id("address2"), endereco);
    }

    public void city(String cidade) {

        escrever(By.id("city"), cidade);
    }

    public void state(String estado) {

        selecionarTexto(By.id("id_state"), estado);
    }

    public void zipCode(String cep) {

        escrever(By.id("postcode"), cep);
    }

    public void country(String pais) {

        selecionarTexto(By.id("id_country"), pais);
    }

   public void additionalInf(String inf) {
        escrever(By.id("other"), inf);

    }

    public void homePhone(String phone) {
        escrever(By.id("phone"), phone);

    }

    public void mobilePhone(String cel) {

        escrever(By.id("phone_mobile"), cel);
    }

    public void futureReference(String texto) {
        limparCampo(By.id("alias"));
        escrever(By.id("alias"),texto);
    }

    public void btnRegister() throws IOException {
        printarTela("PrintAntesSalvarCadastro");
        clicar(By.id("submitAccount"));
        printarTela("PrintSalvarCadastro");
    }


    public String lastNameRequired() {
        esperaExplicitaClasse(By.xpath("//div[@class='alert alert-danger']"));
        return obterTextoNaTela(By.xpath("//*[contains(text(),'is required')]//ancestor::b[contains(text(),'lastname')]"));

    }

    public String firstNameRequired() {
        esperaExplicitaClasse(By.xpath("//div[@class='alert alert-danger']"));
        return obterTextoNaTela(By.xpath("//*[contains(text(),'is required')]//ancestor::b[contains(text(),'firstname')]"));

    }

    public String passwdRequired() {
        return obterTextoNaTela(By.xpath("//*[contains(text(),'is required')]//ancestor::b[contains(text(),'passwd')]"));

    }

    public String address1Required() {
        return obterTextoNaTela(By.xpath("//*[contains(text(),'is required')]//ancestor::b[contains(text(),'address1')]"));

    }

    public String cityRequired() {
         return obterTextoNaTela(By.xpath("//*[contains(text(),'is required')]//ancestor::b[contains(text(),'city')]"));

    }

    public String stateRequired() {
        return obterTextoNaTela(By.xpath("//*[contains(text(),'This country requires you to choose a State')]"));
    }

    public String zipCodeRequired() {
        esperaExplicitaClasse(By.xpath("//div[@class='alert alert-danger']"));
        return obterTextoNaTela(By.xpath("//*[contains(text(),'It must follow this format: 00000')]"));
    }

    public String mobilePhoneRequired() {
        return obterTextoNaTela(By.xpath("//*[contains(text(),'You must register at least one phone number.')]"));
    }
    public String countryInvalid() {
        return obterTextoNaTela(By.xpath("//*[contains(text(),'Country is invalid')]"));
    }




}
