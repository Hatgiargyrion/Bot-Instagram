package po;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author Matheus Santos Hatgiargyrion
 */
public class PerfilPO extends MasterWebPO {

    public PerfilPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "v1Nh3")
    List<WebElement> elemmentTargetPhoto;

    @FindBy(css = "textarea[placeholder=\"Adicione um comentário...\"]")
    WebElement fieldComment;

    @FindBy(xpath = "//button[text()='Publicar']")
    WebElement btnPublish;

    @FindBy(className = "tA2fc")
    WebElement lblTryAgain;

    List<String> emojis = Arrays.asList("😀", "😃", "😄", "😁", "😆", "😅", "😂", "🤣", "😇", "😉",
            "😊", "🙂", "🙃", "☺", "😋", "😌", "😍", "🥰", "😘", "😗", "😙", "😚", "🥲", "🤪", "😜", "😝", "😛",
            "🤑", "😎", "🤓", "🥸", "🧐", "🤠", "🥳", "🤗", "🤡", "😏", "😶", "😐", "😑", "😒", "🙄", "🤨", "🤔",
            "🤫", "🤭", "🤥", "😳", "😞", "😟", "😠", "😡", "🤬", "😔", "😕", "🙁", "☹", "😬", "🥺", "😣", "😖",
            "😫", "😩", "🥱", "😤", "😮", "‍💨", "😮", "😱", "😨", "😰", "😯", "😦", "😧", "😢", "😥", "😪", "🤤");

    /**
     * Metodo usado para comentar na foto escolhida.
     * 
     * @param phrase frase desejada pelo usuario.
     * @param qntCommentHours quantidade de comentarios por hora.
     * @param numberTargetPhoto numero da foto alvo.
     * @param qntHours quantidade de horas que vai rodar o robo.
     * @param objective tipo de comentario que o usuario deseja fazer. 
     * @param qntEmojis quantidade de emoji desejada pelo usuario.
     * 
     * @return PerfilPO
     */
    public PerfilPO comment(String phrase, Integer qntCommentHours, Integer numberTargetPhoto, Integer qntHours, String objective, Integer qntEmojis) {
        wait.until(ExpectedConditions.visibilityOf(elemmentTargetPhoto.get(numberTargetPhoto))).click();
        
        Random emojiRandom = new Random();
        
        Integer qntTotal = qntCommentHours * qntHours;
        Integer timeSleep = ((qntHours * 3600) / qntTotal * 1000);
        System.out.println(timeSleep);
        for (int i = 0; i < qntTotal; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(fieldComment)).click();
            String txtComment = fieldComment.getText();
            if (txtComment.equals("")) {
                if (objective.equals("Comment")) {
                    fieldComment.sendKeys(phrase);
                } else if (objective.equals("Emoji")) {
                    for (int p = 0; p < qntEmojis; p++) {
                        fieldComment.sendKeys(emojis.get(emojiRandom.nextInt(emojis.size())));
                    }
                }
                theadSleepGenerico(timeSleep);
                wait.until(ExpectedConditions.elementToBeClickable(btnPublish)).click();
            }
            if (lblTryAgain.isDisplayed()) {
                negotiationTryAgain();
            }
        }
        return this;
    }
    
    /**
     * Metodo trata da mensagem de retorno do Intagram ao comentar muitas vezes.
     * 
     * @return PerfilPO
     */
    public PerfilPO negotiationTryAgain(){
        for (int e = 0; e < 100; e++) {
                    if (e <= 6) {
                        theadSleepGenerico(1000);
                    } else {
                        theadSleepGenerico(52000);
                    }
                    wait.until(ExpectedConditions.elementToBeClickable(btnPublish)).click();
                    if (!lblTryAgain.isDisplayed()) {
                        break;
                    }
                }
        return this;
    }
}
