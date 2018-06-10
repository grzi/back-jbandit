package fr.thulj.corpogames.api

import fr.thulj.corpogames.dto.ArticleDTO
import fr.thulj.corpogames.dto.HomeDataDTO
import fr.thulj.corpogames.service.PageService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class NavigationController(
        private var pageService : PageService
){
    @RequestMapping("/public/navigation/home")
    fun toHome() : HomeDataDTO{
        return pageService.getHomePage()
    }

    @RequestMapping("/public/navigation/article/{link}")
    fun toArticle(@PathVariable("link") link :String) : ArticleDTO?{
        return pageService.getArticle(link)
    }
}