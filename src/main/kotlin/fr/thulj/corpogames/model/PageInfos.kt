package fr.thulj.corpogames.model

abstract class Data()

data class ListData<C>(val c : List<C>) : Data()

data class PageInfos<C>(val title: String,
                     val subtitle: String,
                     val url: String,
                     val datas: ListData<C>?)

