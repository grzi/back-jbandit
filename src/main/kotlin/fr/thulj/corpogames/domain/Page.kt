package fr.thulj.corpogames.domain

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "pages")
data class Page(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        private var id : Int,
        var name: String,
        var title : String,
        var description : String,
        @ManyToMany (fetch = FetchType.EAGER)
        @JoinTable(
                name = "page_properties",
                joinColumns = [JoinColumn(name = "id_page")],
                inverseJoinColumns = [JoinColumn(name = "id_property")]
        )
        var properties : Collection<Property>
){
        constructor() : this(0,"","","", Collections.emptyList())
}