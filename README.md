# Projeto de teste automático :robot:. E-commerce Automation Practice

<!--ts-->
* [Objetivo](#objetivo)
* [Tecnologias utilizadas](#tecnologia)
* [Utilização/estrutura](#utilizacao)
* [Casos de teste](#casos)
  * [Funcionalidade: Cadastro de usuários](#cadastroUsuarios)
* [Links para consulta](#link)
<!--te-->

# <a name="objetivo"></a>Objetivo

Este projeto tem como objetivo demonstrar os meus conhecimentos sobre testes automatizados 
utilizando Selenium WebDriver e Junit. O projeto também utiliza a biblioteca docx4j para a criação também automatizada de 
evidências de teste (sim, isso é possível :open_mouth:). Nesse projeto fiz o meu primeiro contato com a IDE IntelliJ. 
Antes eu utilizada o Eclipse. 

O sistema a ser testado é um _e-commerce_ fictício chamado “Automation Practice”. O site pode ser acessado em [http://automationpractice.com/]().
Conforme informações retiradas no próprio site, ele serve “para ajudar a praticar exercícios em um site de comércio eletrônico em tempo real.”

## <a name="tecnologia"></a>Tecnologias utilizadas
![IntelliJ](icon/IntelliJ.png)
![java](icon/java.png) 
![Junit](icon/Junit.png)
![Maven](icon/Maven.png)
![Selenium](icon/SeleniumWebDriver.png)


**Linguagem:** Java

**Frameworks:** JUnit5, Selenium WebDriver 3.14

**Integrador/Compilador:** Maven

**Criação de arquivo docx:** Biblioteca docx4j

**IDE:** IntelliJ

## <a name="utilizacao"></a>Utilização/estrutura

Realizar o download do projeto (via git clone ou arquivo zip)
Importar o projeto na sua IDE de desenvolvimento favorita

**Estrutura do projeto**

A estrutura principal do projeto está localizada no diretório srd/main/java. Existem três packages:
* automationPractice — Contém os casos de testes.
* estrutura — Contém as classes estruturais do projeto (base para outras classes).
* page — Contém o mapeamento dos elementos das páginas.

O projeto utiliza os conceitos de DSL e Page Object

**Explicando algumas classes**

  A classe **Basic** contém (quase) toda a parte Selenium utilizada. Digo quase toda, porque o 
ideal seria ter uma única classe que representasse a parte selenium. Não fiz dessa forma, 
por achar mais simples que a própria Page insira o localizador do elemento.  

  A classe **EvidenciaWord** é responsável por criar o arquivo docx (arquivo Word) que servirá para evidenciar 
os testes realizados. 
 
  A **package Page** contém todo o mapeamento de elementos do site. Para cada página do site, 
existe uma classe chamada NomePaginaPage que extende a classe Basic. Exemplo página da criação da conta = CriarcontaPage.  
Como dito acima, idealmente apenas uma classe deveria ser responsável por toda a parte Selenium, 
vulgarmente falando, apenas uma classe deveria ter os imports do Selenium, mas nesse projeto as classes 
Pages possuem o ```import org.openqa.selenium.By``` - É nas classes pages que defino o Seletor

## <a name="casos"></a>Casos de teste

Nesse primeiro momento criei somente testes para realizar o cadastro de contas de usuários no site.
Para a primeira demonstração do uso de evidências automatizadas de testes, 
somente o método criarContaSemCamposObrigatorios gera evidência automática em Word. 

### <a name="cadastroUsuarios"></a>Funcionalidade: Cadastro de usuários

### Caso de teste: criarContaSemCamposObrigatorios
**Pré-requisitos:** E-mail não cadastrado no site

**Passos realizados:** 
- Acessar o site http://automationpractice.com

- Clicar em Sign In

- Em "Create An Account" preencher o campo de e-mail e clicar no botão "Create an Account"

- No formulário de cadastro de usuário, preencher somente os campos 
não obrigatórios (campos que estão sem o asterisco)

- Para cada campo obrigatório em branco criar um assertEquals verificando se as mensagens estão conforme o esperado

- Clicar no botão "Register"

**Resultado esperado:** Não permitir que o cadastro seja realizado e exibir todas as 
mensagens informativas sobre campos obrigatórios não preenchidos 

### Caso de teste: criarContaCamposObrigatorios
**Pré-requisitos:** E-mail não cadastrado no site

**Passos realizados:**
- Acessar o site http://automationpractice.com/

- Clicar em Sign In

- Em "Create An Account" preencher o campo de e-mail e clicar no botão "Create an Account"

- No formulário de cadastro de usuário, preencher somente os campos
obrigatórios (campos que estão com o asterisco)

- Clicar no botão  "Register"

- Verificar se o usuário é redirecionado para tela de boas vindas (criar um assert)

**Resultado esperado:** Deve realizar o cadastro da conta do usuário. O Usuário visualiza tela de boas vindas

### Caso de teste: criarContaVerificacaoCompleta
**Pré-requisitos:** E-mail não cadastrado no site
**Passos realizados:**
- Acessar o site http://automationpractice.com/

- Clicar em Sign In

- Em "Create An Account" preencher o campo de e-mail e clicar no botão "Create an Account"

- No formulário de cadastro de usuário, preencher todos os campos 

- Clicar no botão  "Register"

- Verificar se o usuário é redirecionado para tela de boas vindas

**Resultado esperado:** Realizar o cadastro da conta de usuário. Usuário visualiza tela de boas vindas

### Caso de teste: criarContaEmailJaCadastrado
**Pré-requisitos:** E-mail já cadastrado no site

**Passos realizados:**
- Acessar o site http://automationpractice.com/

- Clicar em Sign In

- Em "Create An Account" preencher o campo de e-mail e clicar no botão "Create an Account"

**Resultado esperado:** O sistema deve exibir mensagem informando que o e-mail já está cadastrado

## <a name="link"></a>Links para consulta

[http://automationpractice.com/index.php](http://automationpractice.com/index.php)

[https://www.selenium.dev/documentation/webdriver/](https://www.selenium.dev/documentation/webdriver/)

[https://junit.org/junit5/](https://junit.org/junit5)

[https://www.docx4java.org/trac/docx4j](https://www.docx4java.org/trac/docx4j)


  

