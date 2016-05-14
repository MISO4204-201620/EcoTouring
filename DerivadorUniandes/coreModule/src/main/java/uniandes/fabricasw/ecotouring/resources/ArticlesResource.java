package uniandes.fabricasw.ecotouring.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;
import uniandes.fabricasw.ecotouring.core.Article;
import uniandes.fabricasw.ecotouring.db.ArticleDAO;

@Path("/articles")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + "; charset=utf-8")

public class ArticlesResource {

	private final ArticleDAO articleDAO;

	public ArticlesResource(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@POST
	@UnitOfWork
	public Article createArticle(Article article) {
		return articleDAO.create(article);
	}

	@GET
	@UnitOfWork
	public List<Article> listArticles() {
		List<Article> l = articleDAO.findAll();
		if (l.isEmpty()) {
			throw new NotFoundException("No data found.");
		}
		return l;
	}

}
