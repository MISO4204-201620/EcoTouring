package uniandes.fabricasw.ecotouring.auth;

import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.db.PersonDAO;

public interface IAuthenticatorStrategy {

	public Person authenticate(PersonDAO userDAO, String userName, String identifier);
}
