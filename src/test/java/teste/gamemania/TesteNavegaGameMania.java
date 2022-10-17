package teste.gamemania;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteNavegaGameMania {
	
	ChromeDriver driver; //Declara variável driver
	
	
	@Before
	public void PreTeste() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Aline\\Documents\\chromedriver.exe"); //Configura o caminho do Chrome Driver
		
		this.driver = new ChromeDriver(); //Variável driver é instanciada para abrir o navegador
		this.driver.manage().window().maximize(); //Maximiza o navegador
		this.driver.get("http://localhost:4200/"); //Acessa o endereço local da aplicação
		this.driver.findElement(By.xpath("//*[@id=\"nav\"]/a[8]")).click(); //seleciona o elemento pelo xpath e clica
	}
	
	@Test
	public void TesteNavegabilidade() {
		//criar os web elements
		WebElement inputEmail = this.driver.findElement(By.id("email")); 
		WebElement inputSenha = this.driver.findElement(By.id("password"));
		WebElement inputSubmit = this.driver.findElement(By.xpath("//*[@id=\"login-container\"]/form/input[3]")); 
		String[] listaEmails = {"joao.silva", "paulo@email", "maria.aparecida@email.com"};
		String[] listaSenhas = {"senhaErrada", "123", "12345678"};
		
		for(int tentativas = 0; tentativas < listaSenhas.length; tentativas++) {
			
			try {
				//limpa os campos antes de inserir novos dados
				inputEmail.clear();
				inputSenha.clear();
				
				//preencher os campos e submeter o formulário
				inputEmail.sendKeys(listaEmails[tentativas]);
				inputSenha.sendKeys(listaSenhas[tentativas]);
				inputSubmit.click();
				
				
				//interrompe o teste em 3 segundos
				Thread.sleep(3000);
				
			} catch(InterruptedException error) {
				//se ouver erro, printa o erro
				error.printStackTrace();
			}
			
			
			
		}
		
		
	}
	
	@After
	public void TesteNavegacao() {
		this.driver.quit(); //Fecha o navegador com todas as abas que estão abertas
	}
}
