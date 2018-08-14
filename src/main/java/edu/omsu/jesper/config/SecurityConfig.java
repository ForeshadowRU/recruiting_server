package edu.omsu.jesper.config;

import edu.omsu.jesper.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    private OrRequestMatcher PUBLIC_URLS;
    private NegatedRequestMatcher PROTECTED_URLS;
    private final TokenAuthenticationProvider provider;
    private final JwtAuthenticationEntryPoint point;

    @Autowired
    protected SecurityConfig(TokenAuthenticationProvider provider,
                             JwtAuthenticationEntryPoint point) {
        super();
        this.point = point;
        PUBLIC_URLS = new OrRequestMatcher(
                new AntPathRequestMatcher("/public/**")
        );
        PROTECTED_URLS = new NegatedRequestMatcher(PUBLIC_URLS);
        this.provider = provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.authenticationProvider(provider);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.debug(true);
        web.ignoring().requestMatchers(PUBLIC_URLS);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(STATELESS)
                .and()
                .exceptionHandling()
                .defaultAuthenticationEntryPointFor(point, PROTECTED_URLS)
                .accessDeniedHandler(new JwtAccessDeniedHandler())
                .and()
                .addFilterBefore(getJwtFilter(), AnonymousAuthenticationFilter.class)
                .httpBasic().disable()
                .csrf().disable()
                .logout().disable()
                .authorizeRequests().antMatchers("/public/**", "/error").permitAll();
    }

    protected TokenAuthenticationFilter getJwtFilter() throws Exception {
        TokenAuthenticationFilter filter = new TokenAuthenticationFilter(PROTECTED_URLS);
        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
        filter.setAuthenticationManager(authenticationManagerBean());
        handler.setRedirectStrategy(new NoRedirectStrategy());
        filter.setAuthenticationSuccessHandler(handler);
        return filter;

    }
}