package pages;

import java.io.FileWriter;
import java.io.IOException;

public class WriteUsernamePassword {
	public static void main(String[] args)
	{
		try {
			FileWriter writeUsername = new FileWriter("C:\\\\Users\\\\Samet\\\\Desktop\\\\Network\\\\Network.com\\\\src\\\\main\\\\resources\\\\username.csv");
			
			writeUsername.append("asameterkok@gmail.com");
			writeUsername.flush();
			writeUsername.close();
			
			FileWriter writer = new FileWriter("C:\\\\Users\\\\Samet\\\\Desktop\\\\Network\\\\Network.com\\\\src\\\\main\\\\resources\\\\password.csv");
			
			writeUsername.append("12345678.");
			writeUsername.flush();
			writeUsername.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
