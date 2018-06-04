package fr.thulj.corpogames.api

import fr.thulj.corpogames.model.ListData
import fr.thulj.corpogames.model.PageInfos
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/navigation")
class NavigationController {

    @GetMapping("/home")
    fun homePage()= PageInfos<String>("homePage", "Welcome to the website", "/", null)



}