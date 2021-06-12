import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestaCadastroFacebook {
    WebDriver driver;
    WebDriverWait wait;

    String nome ="leslie ";
    String sobrenome ="cespedes";
    String email ="testeu479@gmail.com";
    String confirmarEmail ="testeu479@gmail.com";
    String senha ="passWorld";
    String tipoSexo = "F";

    @Before
    public void setup (){
        System.setProperty("webdriver.chrome.driver", "E:\\LESLIE\\QE Gama Academy\\web driver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void iniciaMetodo(){

        driver.get("https://pt-br.facebook.com/r.php?locale=pt_BR");

        driver.findElement(By.name("firstname")).sendKeys(nome);
        driver.findElement(By.name("lastname")).sendKeys(sobrenome);
        driver.findElement(By.name("reg_email__")).sendKeys(email);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(confirmarEmail);
        driver.findElement(By.name("reg_passwd__")).sendKeys(senha);

        WebElement comboDia = driver.findElement(By.id("day"));
        Select select = new Select(comboDia);
        select.selectByVisibleText("14");

        WebElement comboMes = driver.findElement(By.id("month"));
        select = new Select(comboMes);
        select.selectByVisibleText("Mai");

        WebElement comboAno = driver.findElement(By.id("year"));
        select = new Select(comboAno);
        select.selectByVisibleText("1986");

        if (tipoSexo.equals("F")){
            driver.findElement(By.xpath("//input[@value='1']")).click();
        }if (tipoSexo.equals("M")){
            driver.findElement(By.xpath("//input[@value='2']")).click();
        }
        driver.findElement(By.name("websubmit")).click();


    }
}
