package fr.thulj.jbandit.service

import fr.thulj.jbandit.domain.ArticleHead
import fr.thulj.jbandit.dto.ArticleDTO
import fr.thulj.jbandit.dto.ArticleHeadDTO
import fr.thulj.jbandit.dto.MenuDTO
import fr.thulj.jbandit.repository.ArticleHeadRepository
import fr.thulj.jbandit.repository.ArticleRepository
import org.apache.commons.lang3.time.FastDateFormat
import org.apache.logging.log4j.util.Strings
import org.springframework.stereotype.Service

interface ArticleService{
    fun getArticle(link:String) : ArticleDTO
    fun getLastArticles(limit: Int): List<ArticleHeadDTO>?
    fun getSections(): Collection<MenuDTO>
}

@Service("articleService")
class ArticleServiceImpl(
        private var articleHeadRepository: ArticleHeadRepository,
        private var articleRepository: ArticleRepository
) : ArticleService {

    override fun getLastArticles(limit: Int): List<ArticleHeadDTO>? {
        var articles = articleHeadRepository.findAll()
        return articles.sortedByDescending { e -> e.create_date }.take(limit).map { e -> articleHeadDTOFromArticleHead(e) }
    }

    override fun getSections(): Collection<MenuDTO> {
        var articles = articleHeadRepository.findAll()
        return articles.map { e -> e.type }.toSet().map { e -> MenuDTO(e, e, Strings.EMPTY) }
    }

    override fun getArticle(link: String): ArticleDTO {
        val article = articleRepository.findByLink(link)
        val test = "{\n  \"myThing\" : \"thing\",\n  \"myOtherThing\" : \"thing\"\n}"
        return ArticleDTO(articleHeadDTOFromArticleHead(article.articleHead), "")
    }
}


/*
 * Helpers
 */

val dateFormat: FastDateFormat? = FastDateFormat.getInstance("dd/MM/yyyy")

private fun articleHeadDTOFromArticleHead(articleHead: ArticleHead): ArticleHeadDTO {
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