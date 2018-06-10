package fr.thulj.corpogames.domain

import java.sql.Date
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "articles")
class Article(
    @Id
    var link : String,
    @OneToOne
    @JoinColumn(name = "link")
    var articleHead : ArticleHead
){
    constructor() : this("",ArticleHead())
}

@Entity
@Table(name = "articleshead")
class ArticleHead(
        @Id
        var link : String,
        var title : String,
        var description : String,
        var create_date : Date,
        var type : String,
        var theme : String,
        var image : String
){
    @OneToOne(mappedBy = "articleHead")
    lateinit var article : Article

    constructor() :  this("","","", Date(0),"","","")
}