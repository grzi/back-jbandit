package fr.thulj.corpogames.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.Date
import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

@Entity
@Table(name = "users")
class User (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        private var id : Int,
        @Column(nullable = false, unique = true)
        private var username : String,
        private var email : String,
        @Column(nullable = false)
        private var password : String,
        private var enabled: Boolean,
        private var locked:Boolean,
        private var lastcredentialchange : Date,
        @ManyToMany (fetch = FetchType.EAGER)
        @JoinTable(
                name = "user_roles",
                joinColumns = [JoinColumn(name = "id_users")],
                inverseJoinColumns = [JoinColumn(name = "id_role")]
        )
        private var roles : Set<Role>
) : UserDetails{
    constructor() : this(0,"","","",false,false, Calendar.getInstance().time, HashSet<Role>())

    override fun getAuthorities() = roles

    override fun isEnabled() = enabled;

    override fun getUsername() = username

    override fun isCredentialsNonExpired() = true

    override fun getPassword() = password

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = !locked
}

@Entity
@Table(name = "ref_roles")
class Role(
        @Id
        private var id: Int,
        private var name: String
) : GrantedAuthority{
    constructor() : this(1,"");
    override fun getAuthority() = name
}

