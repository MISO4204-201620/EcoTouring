package uniandes.fabricasw.ecotouring;

import java.util.Map;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import uniandes.fabricasw.ecotouring.auth.ExampleAuthenticator;
import uniandes.fabricasw.ecotouring.auth.ExampleAuthorizer;
import uniandes.fabricasw.ecotouring.cli.RenderCommand;
import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.core.Template;
import uniandes.fabricasw.ecotouring.core.User;
import uniandes.fabricasw.ecotouring.db.ItemDAO;
import uniandes.fabricasw.ecotouring.db.PersonDAO;
import uniandes.fabricasw.ecotouring.filter.DateRequiredFeature;
import uniandes.fabricasw.ecotouring.health.TemplateHealthCheck;
import uniandes.fabricasw.ecotouring.resources.FilteredResource;
import uniandes.fabricasw.ecotouring.resources.HelloWorldResource;
import uniandes.fabricasw.ecotouring.resources.ItemResource;
import uniandes.fabricasw.ecotouring.resources.PeopleResource;
import uniandes.fabricasw.ecotouring.resources.PersonResource;
import uniandes.fabricasw.ecotouring.resources.ProtectedResource;
import uniandes.fabricasw.ecotouring.resources.ViewResource;

public class EcoTouringApplication extends Application<EcoTouringConfiguration> {
	public static void main(String[] args) throws Exception {
		new EcoTouringApplication().run(args);
	}

	private final HibernateBundle<EcoTouringConfiguration> hibernateBundle = new HibernateBundle<EcoTouringConfiguration>(
			Person.class) {
		@Override
		public DataSourceFactory getDataSourceFactory(EcoTouringConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}
	};

	@Override
	public String getName() {
		return "hello-world";
	}

	@Override
	public void initialize(Bootstrap<EcoTouringConfiguration> bootstrap) {
		// Enable variable substitution with environment variables
		bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(
				bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)));

		bootstrap.addCommand(new RenderCommand());
		bootstrap.addBundle(new AssetsBundle());
		bootstrap.addBundle(new MigrationsBundle<EcoTouringConfiguration>() {
			@Override
			public DataSourceFactory getDataSourceFactory(EcoTouringConfiguration configuration) {
				return configuration.getDataSourceFactory();
			}
		});
		bootstrap.addBundle(hibernateBundle);
		bootstrap.addBundle(new ViewBundle<EcoTouringConfiguration>() {
			@Override
			public Map<String, Map<String, String>> getViewConfiguration(EcoTouringConfiguration configuration) {
				return configuration.getViewRendererConfiguration();
			}
		});
	}

	@Override
	public void run(EcoTouringConfiguration configuration, Environment environment) {
		
		// Registrar recursos
		final PersonDAO personDao = new PersonDAO(hibernateBundle.getSessionFactory());
		final ItemDAO itemDao     = new ItemDAO(hibernateBundle.getSessionFactory());		
		final Template template = configuration.buildTemplate();

		environment.healthChecks().register("template", new TemplateHealthCheck(template));
		environment.jersey().register(DateRequiredFeature.class);
		environment.jersey()
				.register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<User>()
						.setAuthenticator(new ExampleAuthenticator()).setAuthorizer(new ExampleAuthorizer())
						.setRealm("SUPER SECRET STUFF").buildAuthFilter()));
		environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
		environment.jersey().register(RolesAllowedDynamicFeature.class);
		environment.jersey().register(new HelloWorldResource(template));
		environment.jersey().register(new ViewResource());
		environment.jersey().register(new ProtectedResource());
		environment.jersey().register(new FilteredResource());
		
		environment.jersey().register(new PeopleResource(personDao));
		environment.jersey().register(new PersonResource(personDao));
		
		environment.jersey().register(new ItemResource(itemDao));

	}
}
