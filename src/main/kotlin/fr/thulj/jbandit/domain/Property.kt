package fr.thulj.jbandit.domain

import javax.persistence.*

@Entity
@Table(name="properties")
class Property(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id : Int,
        var name : String,
        var value : String
){
    constructor() : this(0,"","")
}