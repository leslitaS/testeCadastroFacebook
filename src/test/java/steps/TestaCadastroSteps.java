package steps;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestaCadastroSteps {

    // Variáveis globais
    WebDriver driver;
    WebDriverWait wait;

    String nome ="leslie ";
    String sobrenome ="cespedes";
    String email ="testeu479@gmail.com";
    String confirmarEmail ="testeu479@gmail.com";
    String senha ="passWorld";
    String tipoSexo = "F";

    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "E:\\LESLIE\\QE Gama Academy\\web driver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver,30);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Dado("que o usuario está na tela de cadastro")
    public void que_o_usuario_está_na_tela_de_cadastro() {
        driver.get("https://www.facebook.com/r.php?locale=pt_BR");

    }

    @Quando("preenche os campos de forma correta")
    public void preenche_os_campos_de_forma_correta() {
        // Preenche campos de cadastro
        driver.findElement(By.name("firstname")).sendKeys(nome);
        driver.findElement(By.name("lastname")).sendKeys(sobrenome);
        driver.findElement(By.name("reg_email__")).sendKeys(email);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(confirmarEmail);
        driver.findElement(By.name("reg_passwd__")).sendKeys(senha);

        // Preenche os select de data
        WebElement comboDia	=	driver.findElement(By.id("day"));
        Select select	=	new	Select(comboDia);
        select.selectByVisibleText("14");

        WebElement	comboMes	=	driver.findElement(By.id("month"));
        select	=	new	Select(comboMes);
        select.selectByVisibleText("Mai");

        WebElement	comboAno	=	driver.findElement(By.id("year"));
        select	=	new	Select(comboAno);
        select.selectByVisibleText("1986");
    }

    @Quando("escolhe o genero feminino")
    public void escolhe_o_genero_feminino() {
        driver.findElement(By.xpath("//input[@value='1']")).click();
    }

    @Quando("clica no botão cadastrar")
    public void clica_no_botão_cadastrar() {
        driver.findElement(By.name("websubmit")).click();
    }

    @Então("deve ser criada uma conta com o genero escolhido")
    public void deve_ser_criada_uma_conta_com_o_genero_escolhido() {
        /*
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("uiHeaderTitle")));
        String msgDeValidacao = driver.findElement(By.className("uiHeaderTitle")).getText();
        Assert.assertEquals("Insira o código de segurança", msgDeValidacao);
         */
    }

}
