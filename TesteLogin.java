package br.senai.testemania;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
	private WebDriver driver;
	
	@Before
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@Test
	public void TestarLogin() {
		driver.get("http://localhost:4200/");
		driver.findElement(By.id("link_entrar")).click();
		
		WebElement inputEmail =driver.findElement(By.id("email"));
		WebElement inputPassword =driver.findElement(By.id("password"));
		WebElement botao_enviar =driver.findElement(By.id("botao_enviar"));
		
		String [] senhas = {"1234","6578","12345678"};

		for (int tentativa = 0; tentativa < 3; tentativa++) {
			try {
				
			inputEmail.clear();
			inputPassword.clear();
			
			inputEmail.sendKeys("maria@gmail.com");
			inputPassword.sendKeys(senhas[tentativa]);
			botao_enviar.click();
				
			Thread.sleep(3000);
	
			}catch(InterruptedException e ){
				e.printStackTrace();
				
			}finally {
				
			}
		}
		WebElement mensagem = driver.findElement(By.id("mensagem"));
		
		System.out.println(mensagem.getText());	
		
	}
	

}
