package estrutura;

import org.docx4j.dml.wordprocessingDrawing.Inline;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPartAbstractImage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.Drawing;
import org.docx4j.wml.P;
import org.docx4j.wml.R;

import java.io.File;
import java.nio.file.Files;

public class EvidenciaWord {

    public File arquivo;
    public File imagem;
    public WordprocessingMLPackage wordPackage;
    public MainDocumentPart mainDocumentPart;

    public void geraEvidenciaContaSemCamposObrigatorios(String nomeArquivo) throws Docx4JException, Exception {
        wordPackage = WordprocessingMLPackage.createPackage();
        mainDocumentPart = wordPackage.getMainDocumentPart();
        arquivo = new File(nomeArquivo + ".docx");
        mainDocumentPart.addStyledParagraphOfText("Title", nomeArquivo);
        mainDocumentPart.addStyledParagraphOfText("Heading2", "Autor: Eduardo Camilo da Silva");
        mainDocumentPart.addStyledParagraphOfText("Heading2", "Passos realizados:");
        mainDocumentPart.addStyledParagraphOfText("Heading3", "1 - Acessar o sistema");
        mainDocumentPart.addStyledParagraphOfText("Heading3", "2 - Clicar em Sig In");
        inserirImagem("cliqueEmSignin");
        mainDocumentPart.addStyledParagraphOfText("Heading3", "3 - Inserir E-mail e clicar em Create an account");
        inserirImagem("PrintInserirEmail");
        mainDocumentPart.addStyledParagraphOfText("Heading3", "4 - Não preencher os campos obrigatórios e clicar em Register");
        inserirImagem("PrintAntesSalvarCadastro");
        mainDocumentPart.addStyledParagraphOfText("Heading3", "Resultado esperado: Não concluir o cadastro e exibir as mensagens de alertas");
        inserirImagem("PrintSalvarCadastro");
        wordPackage.save(arquivo);
    }

    private void inserirImagem(String nomeImagem) throws Exception {
        File imagem = new File(nomeImagem + ".jpg");
        byte[] fileContent = Files.readAllBytes(imagem.toPath());
        BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wordPackage, fileContent);
        Inline inline = imagePart.createImageInline("Baeldung Image (filename hint)", "Alt Text", 1, 2, false);
        P Imageparagraph = addImagem(inline);
        mainDocumentPart.getContent().add(Imageparagraph);
    }

    private static P addImagem(Inline inline) {
        ObjectFactory factory = new ObjectFactory();
        P p = factory.createP();
        R r = factory.createR();
        p.getContent().add(r);
        Drawing drawing = factory.createDrawing();
        r.getContent().add(drawing);
        drawing.getAnchorOrInline().add(inline);
        return p;
    }
}
