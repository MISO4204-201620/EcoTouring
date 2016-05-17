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
import uniandes.fabricasw.ecotouring.auth.EcoTouringAuthenticator;
//import uniandes.fabricasw.ecotouring.auth.EcoTouringAuthorizer;
import uniandes.fabricasw.ecotouring.cli.RenderCommand;
import uniandes.fabricasw.ecotouring.core.Accommodation;
import uniandes.fabricasw.ecotouring.core.AccommodationType;
import uniandes.fabricasw.ecotouring.core.Alimentation;
import uniandes.fabricasw.ecotouring.core.AlimentationType;
import uniandes.fabricasw.ecotouring.core.Article;
import uniandes.fabricasw.ecotouring.core.Categories;
import uniandes.fabricasw.ecotouring.core.Category;
import uniandes.fabricasw.ecotouring.core.City;
import uniandes.fabricasw.ecotouring.core.ContentType;
import uniandes.fabricasw.ecotouring.core.Conversation;
import uniandes.fabricasw.ecotouring.core.ConversationType;
import uniandes.fabricasw.ecotouring.core.Country;
import uniandes.fabricasw.ecotouring.core.EcoTour;
import uniandes.fabricasw.ecotouring.core.EcoTourType;
import uniandes.fabricasw.ecotouring.core.Item;
import uniandes.fabricasw.ecotouring.core.ItemComment;
import uniandes.fabricasw.ecotouring.core.ItemContent;
import uniandes.fabricasw.ecotouring.core.ItemType;
import uniandes.fabricasw.ecotouring.core.Message;
import uniandes.fabricasw.ecotouring.core.MessageStatus;
import uniandes.fabricasw.ecotouring.core.Person;
import uniandes.fabricasw.ecotouring.core.Role;
import uniandes.fabricasw.ecotouring.core.Tag;
import uniandes.fabricasw.ecotouring.core.Template;
import uniandes.fabricasw.ecotouring.core.Transaction;
import uniandes.fabricasw.ecotouring.core.TransactionDetail;
import uniandes.fabricasw.ecotouring.core.TransactionStatus;
import uniandes.fabricasw.ecotouring.core.TransactionType;
import uniandes.fabricasw.ecotouring.core.Transport;
import uniandes.fabricasw.ecotouring.core.TransportType;
import uniandes.fabricasw.ecotouring.core.User;
import uniandes.fabricasw.ecotouring.db.AccommodationDAO;
import uniandes.fabricasw.ecotouring.db.AlimentationDAO;
import uniandes.fabricasw.ecotouring.db.ArticleDAO;
import uniandes.fabricasw.ecotouring.db.ConversationDAO;
import uniandes.fabricasw.ecotouring.db.EcoTourDAO;
import uniandes.fabricasw.ecotouring.db.ItemCommentDAO;
import uniandes.fabricasw.ecotouring.db.ItemContentDAO;
import uniandes.fabricasw.ecotouring.db.ItemDAO;
import uniandes.fabricasw.ecotouring.db.MessageDAO;
import uniandes.fabricasw.ecotouring.db.PersonDAO;
import uniandes.fabricasw.ecotouring.db.ShoppingCartDAO;
import uniandes.fabricasw.ecotouring.db.ShoppingCartDetailDAO;
import uniandes.fabricasw.ecotouring.db.TransportDAO;
import uniandes.fabricasw.ecotouring.filter.DateRequiredFeature;
import uniandes.fabricasw.ecotouring.health.TemplateHealthCheck;
import uniandes.fabricasw.ecotouring.resources.AccommodationResource;
import uniandes.fabricasw.ecotouring.resources.AlimentationResource;
import uniandes.fabricasw.ecotouring.resources.ArticleResource;
import uniandes.fabricasw.ecotouring.resources.ArticlesResource;
import uniandes.fabricasw.ecotouring.resources.CategoriesResource;
import uniandes.fabricasw.ecotouring.resources.EcoTourResource;
import uniandes.fabricasw.ecotouring.resources.FilteredResource;
import uniandes.fabricasw.ecotouring.resources.HelloWorldResource;
import uniandes.fabricasw.ecotouring.resources.ItemResource;
import uniandes.fabricasw.ecotouring.resources.ItemsResource;
import uniandes.fabricasw.ecotouring.resources.LoginResource;
import uniandes.fabricasw.ecotouring.resources.MessageResource;
import uniandes.fabricasw.ecotouring.resources.MessagesResource;
import uniandes.fabricasw.ecotouring.resources.PeopleResource;
import uniandes.fabricasw.ecotouring.resources.PersonResource;
import uniandes.fabricasw.ecotouring.resources.ProtectedResource;
import uniandes.fabricasw.ecotouring.resources.SearchResource;
import uniandes.fabricasw.ecotouring.resources.ShoppingCartResource;
import uniandes.fabricasw.ecotouring.resources.ShoppongCartDetailResource;
import uniandes.fabricasw.ecotouring.resources.SupplierCSVResource;
import uniandes.fabricasw.ecotouring.resources.SupplierResource;
import uniandes.fabricasw.ecotouring.resources.SuppliersResource;
import uniandes.fabricasw.ecotouring.resources.TransportResource;
import uniandes.fabricasw.ecotouring.resources.ViewResource;

public class EcoTouringApplication extends Application<EcoTouringConfiguration> {
	public static void main(String[] args) throws Exception {
		new EcoTouringApplication().run(args);
	}

	private final HibernateBundle<EcoTouringConfiguration> hibernateBundle =
			// Incluir todas las clases usadas por hibernate
			new HibernateBundle<EcoTouringConfiguration>(Accommodation.class, AccommodationType.class,
					Alimentation.class, AlimentationType.class, Article.class, Categories.class, Category.class,
					City.class, ContentType.class, Conversation.class, ConversationType.class, Country.class,
					EcoTour.class, EcoTourType.class, Item.class, ItemComment.class, ItemContent.class, ItemType.class,
					Message.class, MessageStatus.class, Person.class, Role.class, Tag.class, Transaction.class,
					TransactionDetail.class, TransactionStatus.class, TransactionType.class, Transport.class,
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
		final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

		// Configure CORS parameters
		cors.setInitParameter("allowedOrigins", "*");
		cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
		cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

		// Add URL mapping CORS
		cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

		// Registrar recursos
		final AccommodationDAO accommodationDao = new AccommodationDAO(hibernateBundle.getSessionFactory());
		final AlimentationDAO alimentationDao = new AlimentationDAO(hibernateBundle.getSessionFactory());
		final ConversationDAO conversationDao = new ConversationDAO(hibernateBundle.getSessionFactory());
		final EcoTourDAO ecoTourDao = new EcoTourDAO(hibernateBundle.getSessionFactory());
		final ItemContentDAO itemContentDao = new ItemContentDAO(hibernateBundle.getSessionFactory());
		final ItemDAO itemDao = new ItemDAO(hibernateBundle.getSessionFactory());
		final MessageDAO messageDao = new MessageDAO(hibernateBundle.getSessionFactory());
		final PersonDAO personDao = new PersonDAO(hibernateBundle.getSessionFactory());
		final PersonDAO suppliersDao = new PersonDAO(hibernateBundle.getSessionFactory());
		final ShoppingCartDAO shoppingCartDao = new ShoppingCartDAO(hibernateBundle.getSessionFactory());
		final ShoppingCartDetailDAO shoppingCartDetailDao = new ShoppingCartDetailDAO(
				hibernateBundle.getSessionFactory());
		final TransportDAO transportDao = new TransportDAO(hibernateBundle.getSessionFactory());

		// Derivación sobre constante de módulos variables

		Boolean conditionCalificacion = Boolean.valueOf(new EcoTouringProperties().LoadProperties("calificacion"));
		if (conditionCalificacion) {
			final ItemCommentDAO itemCommentDao = new ItemCommentDAO(hibernateBundle.getSessionFactory());
			environment.jersey()
					.register(new ItemResource(itemDao, conversationDao, itemCommentDao, itemContentDao, messageDao));
		}

		Boolean conditionMensajes = Boolean.valueOf(new EcoTouringProperties().LoadProperties("mensajes"));
		if (conditionMensajes) {
			environment.jersey().register(new MessageResource(messageDao));
			environment.jersey().register(new MessagesResource(messageDao));
		}

		Boolean conditionReportes = Boolean.valueOf(new EcoTouringProperties().LoadProperties("reportes"));
		if (conditionReportes) {
			environment.jersey().register(new SupplierCSVResource(suppliersDao));
		}

		Boolean conditionBlog = Boolean.valueOf(new EcoTouringProperties().LoadProperties("blog"));
		if (conditionBlog) {
			final ArticleDAO articleDao = new ArticleDAO(hibernateBundle.getSessionFactory());
			environment.jersey().register(new ArticleResource(articleDao));
			environment.jersey().register(new ArticlesResource(articleDao));
		}

		final Template template = configuration.buildTemplate();

		// demo
		environment.healthChecks().register("template", new TemplateHealthCheck(template));
		environment.jersey().register(DateRequiredFeature.class);

		// auth
		EcoTouringAuthenticator authenticator = new EcoTouringAuthenticator();
		/*
		 * cachedAuthenticator = new CachingAuthenticator<BasicCredentials,
		 * User>( new MetricRegistry(), authenticator,
		 * config.getAuthenticationCachePolicy());
		 */
		/*
		 * environment.jersey() .register(new AuthDynamicFeature(new
		 * BasicCredentialAuthFilter.Builder<User>()
		 * .setAuthenticator(authenticator).setAuthorizer(new
		 * EcoTouringAuthorizer()) .setRealm("SUPER SECRET STUFF"
		 * ).buildAuthFilter())); environment.jersey().register(new
		 * AuthValueFactoryProvider.Binder<>(User.class));
		 * environment.jersey().register(RolesAllowedDynamicFeature.class);
		 */

		// demo
		environment.jersey().register(new HelloWorldResource(template));
		environment.jersey().register(new ViewResource());
		environment.jersey().register(new ProtectedResource());
		environment.jersey().register(new FilteredResource());

		// fabricasw
		environment.jersey().register(new AlimentationResource(alimentationDao));
		environment.jersey().register(new AccommodationResource(accommodationDao));
		environment.jersey().register(new TransportResource(transportDao));
		environment.jersey().register(new ItemsResource(itemDao));
		environment.jersey().register(new PersonResource(personDao));
		environment.jersey().register(new PeopleResource(personDao));
		environment.jersey().register(new SuppliersResource(suppliersDao));
		environment.jersey().register(new SupplierResource(suppliersDao));
		environment.jersey().register(new EcoTourResource(ecoTourDao));
		environment.jersey().register(new ShoppingCartResource(shoppingCartDao));
		environment.jersey()
				.register(new ShoppongCartDetailResource(itemDao, messageDao, shoppingCartDao, shoppingCartDetailDao));
		environment.jersey().register(new LoginResource(personDao));
		environment.jersey().register(new SearchResource(personDao, itemDao));
		environment.jersey()
				.register(new CategoriesResource(accommodationDao, alimentationDao, ecoTourDao, transportDao));
	}
}