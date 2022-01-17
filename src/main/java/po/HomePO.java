package po;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 *
 * @author Matheus Santos Hatgiargyrion
 */
public class HomePO extends MasterWebPO{
    
    public HomePO(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(css = "input[placeholder=\"Pesquisar\"]")
    WebElement searchBarSend;

    @FindBy(xpath = "//span[text()='Pesquisar']")
    WebElement searchBarClick;
    
    @FindBy(className = "piCib")
    WebElement popUpHome;
    
    @FindBy(className = "yWX7d")
    WebElement btnNotNowHome;
    
    @FindBy(className = "aOOlW")
    WebElement btnNotNow;    
    
    /**
     * Metodo usado para fazer a pesquisa da conta alvo
     * 
     * @param target conta alvo a ser acessada
     * 
     * @return PerfilPO
     */
    public PerfilPO search(String target){
        
        wait.until(ExpectedConditions.elementToBeClickable(btnNotNowHome)).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnNotNow)).click();
        wait.until(ExpectedConditions.elementToBeClickable(searchBarClick)).click();
        searchBarSend.sendKeys(target);
        WebElement contaAlvo = driver.findElement(By.xpath("//div[contains(@class,'_7UhW9')][text()='"+target+"']"));
        wait.until(ExpectedConditions.elementToBeClickable(contaAlvo)).click();
        WebElement validacaoAlvo = driver.findElement(By.xpath("//h2[contains(.,'"+target+"')]"));
        wait.until(ExpectedConditions.visibilityOf(validacaoAlvo));
        
        return new PerfilPO(driver);
    }
}
