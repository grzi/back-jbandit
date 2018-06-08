package fr.thulj.corpogames.api

import fr.thulj.corpogames.model.HomeData
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/public")
class HomeController{

    @RequestMapping("/navigation/home")
    fun data() : HomeData?{
        return null ;
    }

}