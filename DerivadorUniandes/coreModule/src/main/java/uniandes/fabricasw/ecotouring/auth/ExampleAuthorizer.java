package uniandes.fabricasw.ecotouring.auth;

import io.dropwizard.auth.Authorizer;
import uniandes.fabricasw.ecotouring.core.User;

public class ExampleAuthorizer implements Authorizer<User> {

	@Override
	public boolean authorize(User user, String role) {
		if (user.getRoles() != null && user.getRoles().contains(role)) {
			return true;
		}

		return false;
	}
}
