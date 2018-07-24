package fr.thulj.jbandit.service

import fr.thulj.jbandit.dto.HomeDataDTO
import fr.thulj.jbandit.repository.PageRepository
import org.springframework.stereotype.Service
import java.util.*

interface PageService {
    fun getHomePage(): HomeDataDTO
}

@Service("pageService")
class PageServiceImpl(
        private var pageRepository: PageRepository,
        private var articleService: ArticleService
) : PageService {


    override fun getHomePage(): HomeDataDTO {
        val page = pageRepository.findByName("home")


        return HomeDataDTO(
                page.title, page.description,
                articleService.getSections(), articleService.getLastArticles(1)!![0],
                articleService.getLastArticles(5)!!, articleService.getLastArticles(2)!!,
                articleService.getLastArticles(5)!!)
    }

}