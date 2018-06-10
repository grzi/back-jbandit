package fr.thulj.corpogames.dto

data class MenuDTO(
        var name : String,
        var link : String,
        var iconImage : String
)

data class HomeDataDTO(
        var title : String,
        var description : String,
        var menu : Collection<MenuDTO>,
        var lastArticle : ArticleHeadDTO,
        var trendingArticles : Collection<ArticleHeadDTO>,
        var tutorials : Collection<ArticleHeadDTO>,
        var billets : Collection<ArticleHeadDTO>
)