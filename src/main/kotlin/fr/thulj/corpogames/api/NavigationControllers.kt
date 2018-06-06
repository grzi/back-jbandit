package fr.thulj.corpogames.api

import fr.thulj.corpogames.model.ListData
import fr.thulj.corpogames.model.PageInfos
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/navigation")
class HomePageController : PublicApi() {
    @GetMapping("/home")
    fun homePage()= PageInfos<String>("Page d'accueil", "Bienvenue sur le site web", "/", null)
}

@RestController
@RequestMapping("/navigation")
class UserPageController : SecuredApi(){
    @GetMapping("/user")
    fun userPage() = PageInfos<String>("Page de gestion de compte", "Gérez votre compte ici", "/userSettings", null)
}