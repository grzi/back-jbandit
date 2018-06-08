package fr.thulj.corpogames.model

data class ArticleHead(
        var title : String,
        var link : String,
        var img : String,
        var descr : String,
        var date : String,
        var theme : String,
        var type : String
)

data class Article(
        var head : ArticleHead,
        var content : String
)

