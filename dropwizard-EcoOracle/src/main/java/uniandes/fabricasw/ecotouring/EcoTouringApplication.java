package uniandes.fabricasw.ecotouring;

import java.util.EnumSet;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;
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
import uniandes.fabricasw.ecotouring.auth.*;
import uniandes.fabricasw.ecotouring.cli.*;
import uniandes.fabricasw.ecotouring.core.*;
import uniandes.fabricasw.ecotouring.db.*;
import uniandes.fabricasw.ecotouring.filter.DateRequiredFeature;
import uniandes.fabricasw.ecotouring.health.TemplateHealthCheck;
import uniandes.fabricasw.ecotouring.resources.*;

public class EcoTouringApplication extends Application<EcoTouringConfiguration> {
	public static void main(String[] args) throws Exception {
		new EcoTouringApplication().run(args);
	}


	private final HibernateBundle<EcoTouringConfiguration> hibernateBundle = 
			//Incluir todas las clases usadas por hibernate
			new HibernateBundle<EcoTouringConfiguration>(
					Person.class,
					Item.class,
					ItemComment.class,
					ItemContent.class,
					Conversation.class,
					Type.class,
					Transaction.class,
					TransactionDetail.class) {
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
		
		// Cross-Origin Resource Sharing (CORS)
		// Enable CORS headers
	    final FilterRegistration.Dynamic cors =
	        environment.servlets().addFilter("CORS", CrossOriginFilter.class);

	    // Configure CORS parameters
	    cors.setInitParameter("allowedOrigins", "*");
	    cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
	    cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

	    // Add URL mapping CORS
	    cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");		
		
		
		// Registrar recursos
	    final CategoryDAO categoryDao                 = new CategoryDAO(hibernateBundle.getSessionFactory());
		final ItemCommentDAO itemCommentDao          = new ItemCommentDAO(hibernateBundle.getSessionFactory());
		final ItemContentDAO itemContentDao           = new ItemContentDAO(hibernateBundle.getSessionFactory());
		final ItemConversationDAO itemConversationDao = new ItemConversationDAO(hibernateBundle.getSessionFactory());
		final ItemDAO itemDao                         = new ItemDAO(hibernateBundle.getSessionFactory());
		final PersonDAO personDao                     = new PersonDAO(hibernateBundle.getSessionFactory());
		final ShoppingCartDAO suppliersDao            = new ShoppingCartDAO(hibernateBundle.getSessionFactory());
		
		final Template template = configuration.buildTemplate();
		
		//demo
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

		//fabricasw
		environment.jersey().register(new CategoriesResource(categoryDao));
		environment.jersey().register(new ItemResource(itemDao,itemContentDao,itemCommentDao,itemConversationDao));
		environment.jersey().register(new ItemsResource(itemDao));
		environment.jersey().register(new PersonResource(personDao));
		environment.jersey().register(new PeopleResource(personDao));
		//environment.jersey().register(new SuppliersResource(suppliersDao));
		
	}
}