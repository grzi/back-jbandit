package fr.thulj.jbandit.service

import fr.thulj.jbandit.repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service("userDetailsServiceImpl")
class UserDetailServiceImpl(
        val userRepository: UserRepository
) : UserDetailsService{

    override fun loadUserByUsername(username: String?): UserDetails? {
        return userRepository.findByUsername(username!!)
    }
}
