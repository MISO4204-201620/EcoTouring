package uniandes.fabricasw.ecotouring;

import java.io.IOException;
import java.util.Properties;

public class EcoTouringProperties {

	public static void main(String[] args) {
		System.out.println(new EcoTouringProperties().LoadProperties());
	}

	public String LoadProperties() {
		java.io.InputStream is = this.getClass().getResourceAsStream("app.properties");
		java.util.Properties p = new Properties();
		try {
			p.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p.getProperty("calificacion");
	}

}
