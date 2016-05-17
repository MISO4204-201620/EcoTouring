package uniandes.fabricasw.ecotouring.auth;

import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.db.PersonDAO;

public class FacebookAuthenticator implements IAuthenticatorStrategy {

	@Override
	public Person authenticate(PersonDAO userDAO, String userName, String identifierFacebook) {

		return userDAO.authenticateUserByFacebook(userName, identifierFacebook);
	}
}
