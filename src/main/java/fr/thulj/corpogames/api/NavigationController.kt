package fr.thulj.corpogames.api

import fr.thulj.corpogames.dao.SurveyRepository
import fr.thulj.corpogames.model.ListData
import fr.thulj.corpogames.model.PageInfos
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/navigation")
class NavigationController {

    @Autowired
    lateinit var surveyRepository: SurveyRepository

    @GetMapping("/home")
    fun homePage() : PageInfos {
        return PageInfos("homePage", "Welcome to the website", "/", ListData(surveyRepository.findAll().toList()))
    }
}