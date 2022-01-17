package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author Matheus Santos Hatgiargyrion
 */
public class LoginPO extends MasterWebPO{

    public LoginPO(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(name = "username")
    WebElement fieldUser;

    @FindBy(name = "password")
    WebElement fieldPass;

    @FindBy(css = "button[type=\"submit\"]")
    WebElement btnLogin;

    @FindBy(css = "img[data-testid=\"user-avatar\"]")
    WebElement photoProfile;
    
    public HomePO login(String user, String pass){
        
        setUpUrl("https://www.instagram.com");
        wait.until(ExpectedConditions.elementToBeClickable(fieldUser)).click();
        fieldUser.sendKeys(user);
        wait.until(ExpectedConditions.elementToBeClickable(fieldPass)).click();
        fieldPass.sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
        wait.until(ExpectedConditions.visibilityOf(photoProfile));
        
        return new HomePO(driver);
    }
}
