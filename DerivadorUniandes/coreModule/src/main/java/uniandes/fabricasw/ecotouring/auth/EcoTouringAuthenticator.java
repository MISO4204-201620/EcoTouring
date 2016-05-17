package uniandes.fabricasw.ecotouring.auth;

import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.db.PersonDAO;

public class EcoTouringAuthenticator implements IAuthenticatorStrategy {

	@Override
	public Person authenticate(PersonDAO userDAO, String userName, String password) {

		return userDAO.authenticateUserByEcoTouring(userName, password);
	}
}
