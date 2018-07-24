package fr.thulj.jbandit.api

import fr.thulj.jbandit.dto.ArticleDTO
import fr.thulj.jbandit.dto.HomeDataDTO
import fr.thulj.jbandit.service.ArticleService
import fr.thulj.jbandit.service.PageService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class NavigationController(
        private var pageService : PageService,
        private var articleService: ArticleService

){
    @CrossOrigin(origins = arrayOf("*"))
    @RequestMapping("/public/navigation/home")
    fun toHome() : HomeDataDTO{
        return pageService.getHomePage()
    }

    @RequestMapping("/public/navigation/article/{link}")
    fun toArticle(@PathVariable("link") link :String) : ArticleDTO?{
        return articleService.getArticle(link)
    }
}