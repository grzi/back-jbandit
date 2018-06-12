package fr.thulj.corpogames.service

import fr.thulj.corpogames.domain.ArticleHead
import fr.thulj.corpogames.dto.ArticleDTO
import fr.thulj.corpogames.dto.ArticleHeadDTO
import fr.thulj.corpogames.dto.HomeDataDTO
import fr.thulj.corpogames.dto.MenuDTO
import fr.thulj.corpogames.repository.ArticleHeadRepository
import fr.thulj.corpogames.repository.ArticleRepository
import fr.thulj.corpogames.repository.PageRepository
import org.apache.commons.lang3.time.FastDateFormat
import org.apache.logging.log4j.util.Strings
import org.springframework.stereotype.Service
import java.util.*

interface PageService{
    fun getHomePage() : HomeDataDTO
    fun getArticle(articleLink : String) : ArticleDTO?
}

@Service("pageService")
class PageServiceImpl(
        private var pageRepository : PageRepository,
        private var articleHeadRepository : ArticleHeadRepository,
        private var articleRepository: ArticleRepository
) : PageService{

    val dateFormat : FastDateFormat? = FastDateFormat.getInstance("dd/MM/yyyy")

    override fun getHomePage(): HomeDataDTO {
        val page = pageRepository.findByName("home")
        var articles = articleHeadRepository.findAll();

        return HomeDataDTO(
                page.title, page.description,
                getSections(articles), getLastArticle(articles),
                Collections.emptyList(),Collections.emptyList(),
                Collections.emptyList())
    }

    override fun getArticle(articleLink: String): ArticleDTO? {
        var article = articleRepository.findByLink(articleLink)
        return ArticleDTO(articleHeadDTOFromArticleHead(article.articleHead), "");
    }

    private fun getSections(articles: Iterable<ArticleHead>): Collection<MenuDTO> =
        articles.map { e -> e.theme }.toSet().map { e -> MenuDTO(e, e, Strings.EMPTY) }


    private fun getLastArticle(articles: Iterable<ArticleHead>): ArticleHeadDTO {
        var articleHead = articles.sortedByDescending { e -> e.create_date }.first()
        return articleHeadDTOFromArticleHead(articleHead);
    }

    private fun articleHeadDTOFromArticleHead(articleHead : ArticleHead) : ArticleHeadDTO{
        return ArticleHeadDTO(
                articleHead.title,
                articleHead.link,
                articleHead.image,
                articleHead.description,
                dateFormat!!.format(articleHead.create_date),
                articleHead.theme,
                articleHead.type
        )
    }
}