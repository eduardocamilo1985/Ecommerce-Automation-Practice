package page;

import estrutura.Basic;
import org.openqa.selenium.By;

public class CriarContaPage extends Basic {

    public void radioMr() {
        esperaImplicita(By.id("id_gender1"));
        clicar(By.id("id_gender1"));
    }

    public void radioMrs() {
        clicar(By.id("id_gender2"));
    }

    public void firstName(String nome) {
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

    public void mobilePhone(String cel) {

        escrever(By.id("phone_mobile"), cel);
    }

    public void futureReference(String texto){
        escrever(By.id("alias"),"");
    }

    public void btnRegister() {
        clicar(By.id("submitAccount"));
    }

}
