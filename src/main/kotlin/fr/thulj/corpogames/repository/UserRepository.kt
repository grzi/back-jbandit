package fr.thulj.corpogames.repository

import fr.thulj.corpogames.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, Int>{
    fun findByUsername(username: String): User
}