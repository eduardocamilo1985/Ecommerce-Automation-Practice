package estrutura;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static estrutura.DriverFactory.getDriver;

public class Basic {

    public void acessar(String url){

        getDriver().get(url);
    }
    public void finalizarDriver(){
        getDriver().quit();
    }


    //####### manipulação de texto
    public void escrever(By by, String texto ){

        getDriver().findElement(by).sendKeys(texto);
    }

    public void teclarTab(By by){

        getDriver().findElement(by).sendKeys(Keys.TAB);
    }
    public String obterTexto(By by){

        return getDriver().findElement(by).getAttribute("value");
    }

    public String obterTextoNaTela(By by){
        return getDriver().findElement(by).getText();
    }

    public void limparCampo(By by){
        getDriver().findElement(by).clear();  // novo para subir no git

    }

    //####### combos
    public void selecionarTexto(By by,String texto){
        Select selecionar = new Select(getDriver().findElement(by));
        selecionar.selectByVisibleText(texto);
    }

       //####### clica em alguma coisa
    public void clicar(By by){
        getDriver().findElement(by).click();
    }

    //####### espera
    public void esperaImplicita(By by){
        WebDriverWait espera = new WebDriverWait(getDriver(),30);
        espera.until(ExpectedConditions.elementToBeClickable(by));
    }
    public void esperaImplicitaClasse(By by){
        WebDriverWait espera = new WebDriverWait(getDriver(),30);
        espera.until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
