package fr.thulj.corpogames.domain

import javax.persistence.*

@Entity
@Table(name = "SURVEY")
class Survey(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id:Int,
        var name:String ){
    constructor() : this(0,"")
}

