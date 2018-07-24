package fr.thulj.jbandit.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity

@SpringBootApplication
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(*arrayOf("fr.thulj.jbandit"))
@EnableJpaRepositories(*arrayOf("fr.thulj.jbandit.repository"))
@EntityScan("fr.thulj.jbandit.domain")
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}