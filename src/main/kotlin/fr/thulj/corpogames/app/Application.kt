package fr.thulj.corpogames.app

import fr.thulj.corpogames.domain.Survey
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(*arrayOf("fr.thulj.corpogames"))
@EnableJpaRepositories(*arrayOf("fr.thulj.corpogames.dao"))
@EntityScan("fr.thulj.corpogames.domain")
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}