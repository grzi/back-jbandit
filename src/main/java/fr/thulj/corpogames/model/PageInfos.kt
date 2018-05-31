package fr.thulj.corpogames.model

import fr.thulj.corpogames.domain.Survey

abstract class Data()

data class ListData<C>(val c : List<C>) : Data()

data class PageInfos(val title: String,
                     val subtitle: String,
                     val url: String,
                     val datas: ListData<Survey>)

