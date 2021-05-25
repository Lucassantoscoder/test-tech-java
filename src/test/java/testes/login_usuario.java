package testes;
import org.apache.commons.io.FileUtils;
import java.io.File;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class login_usuario {
    @Test
    public void testFazerLoginNoTaskit() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lucas\\Desktop\\driver90\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        //maximize windows
        navegador.manage().window().maximize();
        // aguarda até carregar
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Entra na pagina
        navegador.get("http://automationpractice.com/index.php");
        navegador.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        // Inseri dados cadastrado
        navegador.findElement(By.id("email")).sendKeys("lucas12345@hotmail.com");
        navegador.findElement(By.id("passwd")).sendKeys("12345");
        navegador.findElement(By.id("SubmitLogin")).click();
        Thread.sleep(5000);
        //Print logado
        File scrFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("prints/25.05.21logado.png"));
        //Fecha login
        navegador.quit();
    }


}