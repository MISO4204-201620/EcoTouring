package uniandes.fabricasw.ecotouring.auth;

// Clase fabrica de estrategias de autenticacion
public class AuthenticatorFactory {
	
	public IAuthenticatorStrategy create(String authenticatorType){
		
		switch (authenticatorType.toLowerCase()) {
	         case "facebook":
	        	 return new FacebookAuthenticator();
	         case "twitter":
	        	 return new TwitterAuthenticator();
	         case "ecotouring":
	        	 return new EcoTouringAuthenticator();
	         default: 
	             return null;
		}          
	}
	
}
