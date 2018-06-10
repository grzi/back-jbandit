package fr.thulj.corpogames.repository

import fr.thulj.corpogames.domain.Page
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PageRepository : CrudRepository<Page,Int> {
    fun findByName(name : String):Page
}