package uniandes.fabricasw.ecotouring.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import uniandes.fabricasw.ecotouring.core.Article;
import uniandes.fabricasw.ecotouring.db.ArticleDAO;

@Path("/article/{articleId}")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class ArticleResource {

	private final ArticleDAO articleDAO;

	public ArticleResource(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@GET
	@UnitOfWork
	public Article getArticle(@PathParam("articleId") LongParam articleId) {
		return findSafely(articleId);
	}

	private Article findSafely(LongParam articleId) {
		final Optional<Article> article = articleDAO.findById(articleId.get());
		if (!article.isPresent()) {
			throw new NotFoundException("No data found.");
		}
		return article.get();
	}
}
