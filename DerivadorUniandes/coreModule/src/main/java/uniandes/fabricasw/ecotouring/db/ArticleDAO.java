package uniandes.fabricasw.ecotouring.db;

import java.util.List;
import org.hibernate.SessionFactory;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import uniandes.fabricasw.ecotouring.core.Article;

public class ArticleDAO extends AbstractDAO<Article> {

	public ArticleDAO(SessionFactory factory) {
		super(factory);
	}

	public Optional<Article> findById(Long id) {
		return Optional.fromNullable(get(id));
	}

	public Article create(Article article) {
		return persist(article);
	}

	public List<Article> findAll() {
		return list(namedQuery("uniandes.fabricasw.ecotouring.core.Article.findAll"));
	}
}
