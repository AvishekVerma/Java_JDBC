import java.io.FileInputStream;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.IOException;

class PropertiesApp 
{
	public static void main(String[] args) throws FileNotFoundException,IOException
	{
		FileInputStream fis = new FileInputStream("application.properties");
		Properties properties = new Properties();
		properties.load(fis);

		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");

		System.out.println("URL is :: "+url);
		System.out.println("USER is :: "+user);
		System.out.println("Password is :: "+password);
	}
}
