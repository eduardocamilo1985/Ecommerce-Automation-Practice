package estrutura;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static estrutura.DriverFactory.getDriver;
import static estrutura.DriverFactory.killDriver;

public class Basic {

    public void acessar(String url){

        getDriver().get(url);
    }
    public void fecharNavegador(){
        killDriver();
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
        getDriver().findElement(by).clear();

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
    public void esperaExplicita(By by){
        WebDriverWait espera = new WebDriverWait(getDriver(),30);
        espera.until(ExpectedConditions.elementToBeClickable(by));
    }
    public void esperaExplicitaClasse(By by){
        WebDriverWait espera = new WebDriverWait(getDriver(),30);
        espera.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void printarTela(String nomeArquivo) throws IOException {

        TakesScreenshot print =(TakesScreenshot) getDriver();
        File arquivo = print.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File( nomeArquivo + ".jpg"));
    }

}
