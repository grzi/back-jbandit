package fr.thulj.corpogames.repository

import fr.thulj.corpogames.domain.Article
import fr.thulj.corpogames.domain.ArticleHead
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository : CrudRepository<Article, Int>{
    fun findByLink(link:String) : Article
}

@Repository interface ArticleHeadRepository : CrudRepository<ArticleHead,Int>{
    fun findByLink(link:String) : ArticleHead
}