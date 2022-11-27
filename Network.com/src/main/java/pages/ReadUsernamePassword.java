package pages;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

	public class ReadUsernamePassword extends BasePage {

		public ReadUsernamePassword(WebDriver driver)
			super(driver);
	}

	public  String username() throws IOException{
		Path filePathUsername=Path.of("C:\\Users\\Samet\\Desktop\\Network\\Network.com\\src\\main\\resources\\username.csv");
		return Files.readString(filePathUsername);
	}
	public  String password() throws IOException{
		Path filePathPassword=Path.of("C:\\Users\\Samet\\Desktop\\Network\\Network.com\\src\\main\\resources\\password.csv");
		return Files.readString(filePathPassword);
	}
}