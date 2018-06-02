package me.horo.milkyway.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.sql.DataSource


@Configuration
class SecurityBeansConfig(
        @Qualifier("dataSource")
        private val dataSource: DataSource
) {
    @Bean
    fun tokenStore(): TokenStore = JdbcTokenStore(dataSource)

    @Bean
    fun authorizationCodeServices(): AuthorizationCodeServices = JdbcAuthorizationCodeServices(dataSource)

    @Bean
    fun passwordEncoder(): PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

    @Bean
    fun oauth2TokenFilterRegistrationBean(): FilterRegistrationBean<OAuth2TokenFilter> {
        val registry = FilterRegistrationBean<OAuth2TokenFilter>()
        registry.filter = OAuth2TokenFilter()
        registry.order = Ordered.HIGHEST_PRECEDENCE
        registry.urlPatterns = listOf("/oauth/token")
        return registry
    }

}

@Configuration
class MethodSecurityConfiguration : GlobalMethodSecurityConfiguration() {
    override fun createExpressionHandler(): MethodSecurityExpressionHandler {
        return OAuth2MethodSecurityExpressionHandler()
    }
}

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration(
        @Qualifier("userDetailsServiceImpl")
        private val userDetailsService: UserDetailsService
) : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
    }

    override fun configure(http: HttpSecurity) {
      http.cors().and().authorizeRequests().anyRequest().authenticated()
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager = super.authenticationManagerBean()


}

@Configuration
@EnableResourceServer
class OAuth2ResourceServerConfiguration(
        private val tokenStore: TokenStore
) : ResourceServerConfigurerAdapter() {

    val RESOURCE_ID = "my_api"

    override fun configure(resources: ResourceServerSecurityConfigurer) {
        resources.tokenStore(tokenStore).resourceId(RESOURCE_ID)
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests().anyRequest().authenticated()
    }
}

@Configuration
@EnableAuthorizationServer
class OAuth2AuthorizationServerConfiguration(
        @Qualifier("authenticationManagerBean")
        private val authenticationManager: AuthenticationManager,
        @Qualifier("dataSource")
        private val dataSource: DataSource,
        private val tokenStore: TokenStore,
        private val passwordEncoder: PasswordEncoder,
        private val authorizationCodeServices: AuthorizationCodeServices,
        @Qualifier("userDetailsServiceImpl")
        private val userDetailsService: UserDetailsService
) : AuthorizationServerConfigurerAdapter() {

    override fun configure(clients: ClientDetailsServiceConfigurer) {
        clients.jdbc(dataSource).passwordEncoder(passwordEncoder)
                .withClient("my-client")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
                .scopes("read", "write", "trust")
                .secret("secret")
                .accessTokenValiditySeconds(120)
                .refreshTokenValiditySeconds(600);
    }

    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        endpoints.authorizationCodeServices(authorizationCodeServices)
                .authenticationManager(authenticationManager)
                .tokenStore(tokenStore)
                .userDetailsService(userDetailsService)
    }

    override fun configure(security: AuthorizationServerSecurityConfigurer) {
        security.realm("myclient").checkTokenAccess("isAuthenticated()")
    }
}


/* Filtre des request pour ajouter des header aux retours */
class OAuth2TokenFilter : GenericFilterBean() {
    override fun doFilter(servletRequest: ServletRequest?, servletResponse: ServletResponse?, chain: FilterChain) {
        val response = servletResponse as HttpServletResponse
        val request = servletRequest as HttpServletRequest

        response.setHeader("Access-Control-Allow-Origin", "*")
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS")
        response.setHeader("Access-Control-Allow-Headers", "Authorization,Content-Type")
        response.setHeader("Access-Control-Allow-Credentials", true.toString())

        if ("OPTIONS".equals(request.method, ignoreCase = true)) {
            response.status = HttpServletResponse.SC_OK
        } else {
            chain.doFilter(servletRequest, servletResponse)
        }
    }
}