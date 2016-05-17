package uniandes.fabricasw.ecotouring.auth;

import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.db.PersonDAO;

public class Authenticator {

	private IAuthenticatorStrategy authenticatorMethod;

	public Authenticator(IAuthenticatorStrategy authenticatorMethod) {
		this.authenticatorMethod = authenticatorMethod;
	}

	public Person authenticate(PersonDAO userDAO, String userName, String identifier) {

		return authenticatorMethod.authenticate(userDAO, userName, identifier);
	}
}
