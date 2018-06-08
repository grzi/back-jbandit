package fr.thulj.corpogames.model

data class Menu(
        var name : String,
        var link : String,
        var iconImage : String
)

data class HomeData(
        var title : String,
        var description : String,
        var menu : Collection<Menu>,
        var lastArticle : ArticleHead,
        var trendingArticles : Collection<ArticleHead>,
        var tutorials : Collection<ArticleHead>,
        var billets : Collection<ArticleHead>
)