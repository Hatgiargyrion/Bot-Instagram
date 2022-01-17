package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Matheus Santos Hatgiargyrion
 */
public class MasterWebPO {

    public WebDriver driver;
    public WebDriverWait wait;

    /**
     * Metodo que define parametros padrões da aplicação.
     * 
     * @param driver 
     */
    public MasterWebPO (WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
    }
    
    /**
     * Metodo que seta o time do Thread Sleep.
     * 
     * @param x time a ser definido no Thread Sleep
     * @return 
     */
    public MasterWebPO theadSleepGenerico(Integer x) {
        try {
            Thread.sleep(x);
        } catch (InterruptedException y) {
            System.out.println("Time setado falhou.");
        }
        return this;
    }

    /**
     * Metodo usado para inicializar a url
     * 
     * @param url 
     */
    public void setUpUrl(String url){
        driver.get(url);
    }
}