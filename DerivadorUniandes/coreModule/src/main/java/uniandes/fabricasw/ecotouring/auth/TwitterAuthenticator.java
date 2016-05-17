package uniandes.fabricasw.ecotouring.auth;

import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.db.PersonDAO;

public class TwitterAuthenticator implements IAuthenticatorStrategy {

	@Override
	public Person authenticate(PersonDAO userDAO, String userName, String identifierTwitter) {

		return userDAO.authenticateUserByTwitter(userName, identifierTwitter);
	}
}
