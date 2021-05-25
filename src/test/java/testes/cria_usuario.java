package testes;

import org.apache.commons.io.FileUtils;
import java.io.File;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class cria_usuario {
    @Test
    public void testFazerLoginNoTaskit() throws IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\lucas\\Desktop\\Drivers\\chromedriver.exe");
        // colocar caminho do seu webdriver acima
        WebDriver navegador = new ChromeDriver();
        //maximize windows
        navegador.manage().window().maximize();
        // aguarda até carregar
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        navegador.get("http://automationpractice.com/index.php");
        File scrFile = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("prints/25.05.21_home.png"));
        navegador.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]")).click();
        navegador.findElement(By.id("email_create")).sendKeys("lucas12345@hotmail.com");

        //print cadastro
        scrFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("prints/25.05.21_cadastro.png"));

        // Cadastra usuaruio
        navegador.findElement(By.id("SubmitCreate")).click();
        navegador.findElement(By.id("uniform-id_gender1")).click();
        navegador.findElement(By.id("customer_firstname")).sendKeys("lucas");
        navegador.findElement(By.id("customer_lastname")).sendKeys("santos");
        navegador.findElement(By.id("passwd")).sendKeys("12345");
        navegador.findElement(By.id("address1")).sendKeys("rua dois");
        navegador.findElement(By.id("city")).sendKeys("São Paulo");
        navegador.findElement(By.id("postcode")).sendKeys("00000");
        navegador.findElement(By.id("phone")).sendKeys("123456789");
        navegador.findElement(By.id("id_state")).click();
        navegador.findElement(By.xpath("//*[@id=\"id_state\"]/option[2]")).click();
        scrFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("prints/25.05.21_registrado.png"));
        navegador.findElement(By.id("submitAccount")).click();
        //closer
        navegador.quit();
    }
}
