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
					Accommodation.class,
					AccommodationType.class,
					Alimentation.class,
					AlimentationType.class,
					Article.class,
					Category.class,
					City.class,
					ContentType.class,
					Conversation.class,
					Country.class,
					EcoTour.class,					
					Item.class,
					ItemComment.class,
					ItemContent.class,
					ItemType.class,
					Person.class,
					Role.class,
					Tag.class,					
					Transaction.class,
					TransactionDetail.class,
					TransactionStatus.class,
					TransactionType.class,
					Transport.class,
					TransportType.class) {
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
	    final AlimentationDAO alimentationDao             = new AlimentationDAO(hibernateBundle.getSessionFactory());
	    final AccommodationDAO accommodationDao           = new AccommodationDAO(hibernateBundle.getSessionFactory());
	    final TransportDAO transportDao                   = new TransportDAO(hibernateBundle.getSessionFactory());
		final ItemDAO itemDao                             = new ItemDAO(hibernateBundle.getSessionFactory());
		final ConversationDAO conversationDao             = new ConversationDAO(hibernateBundle.getSessionFactory());
		final ItemCommentDAO itemCommentDao               = new ItemCommentDAO(hibernateBundle.getSessionFactory());
		final ItemContentDAO itemContentDao               = new ItemContentDAO(hibernateBundle.getSessionFactory());		
		final PersonDAO personDao                         = new PersonDAO(hibernateBundle.getSessionFactory());
		final PersonDAO suppliersDao                      = new PersonDAO(hibernateBundle.getSessionFactory());
		final EcoTourDAO ecoTourDao                       = new EcoTourDAO(hibernateBundle.getSessionFactory());		
		final ShoppingCartDAO shoppingCartDao             = new ShoppingCartDAO(hibernateBundle.getSessionFactory());
		final ShoppingCartDetailDAO shoppingCartDetailDao = new ShoppingCartDetailDAO(hibernateBundle.getSessionFactory());
		
		final Template template = configuration.buildTemplate();
		
		//demo
		environment.healthChecks().register("template", new TemplateHealthCheck(template));
		environment.jersey().register(DateRequiredFeature.class);
		
		//auth
		ExampleAuthenticator authenticator = new ExampleAuthenticator();
		/*cachedAuthenticator = new CachingAuthenticator<BasicCredentials, User>(
			      new MetricRegistry(), authenticator, config.getAuthenticationCachePolicy());*/
		environment.jersey().register(
			  new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<User>()
						.setAuthenticator(authenticator).setAuthorizer(new ExampleAuthorizer())
						.setRealm("SUPER SECRET STUFF").buildAuthFilter()));
		environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
		environment.jersey().register(RolesAllowedDynamicFeature.class);
		
		//demo
		environment.jersey().register(new HelloWorldResource(template));
		environment.jersey().register(new ViewResource());
		environment.jersey().register(new ProtectedResource());
		environment.jersey().register(new FilteredResource());

		//fabricasw
		environment.jersey().register(new AlimentationResource(alimentationDao));
		environment.jersey().register(new AccommodationResource(accommodationDao));
		environment.jersey().register(new TransportResource(transportDao));
		environment.jersey().register(new ItemResource(itemDao,conversationDao,itemCommentDao,itemContentDao));
		environment.jersey().register(new ItemsResource(itemDao));
		environment.jersey().register(new PersonResource(personDao));
		environment.jersey().register(new PeopleResource(personDao));
		environment.jersey().register(new SuppliersResource(suppliersDao));
		environment.jersey().register(new EcoTourResource(ecoTourDao));
		environment.jersey().register(new ShoppingCartResource(shoppingCartDao));
		environment.jersey().register(new ShoppongCartDetailResource(shoppingCartDao,shoppingCartDetailDao));
	}
}