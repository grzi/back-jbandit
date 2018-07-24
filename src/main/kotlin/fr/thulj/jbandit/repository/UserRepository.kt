package fr.thulj.jbandit.repository

import fr.thulj.jbandit.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Int>{
    fun findByUsername(username: String): User
}