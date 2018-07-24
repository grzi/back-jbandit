package fr.thulj.jbandit.dto

data class ArticleHeadDTO(
        var title: String,
        var link: String,
        var img: String?,
        var descr: String,
        var date: String,
        var theme: String,
        var type: String
)

data class ArticleDTO(
        var head: ArticleHeadDTO,
        var content: String
) {
    fun test(): String = "yo"
}

