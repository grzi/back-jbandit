package fr.thulj.corpogames.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service("userDetailsServiceImpl")
class UserDetailServiceImpl : UserDetailsService{
    override fun loadUserByUsername(username: String?): UserDetails {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}