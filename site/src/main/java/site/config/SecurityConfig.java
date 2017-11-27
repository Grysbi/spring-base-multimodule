package site.config;

import model.service.AppUsersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Config Spring security
 *
 * @author gandrieu
 * @version 1.0
 */

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"site", "model", "config"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUsersDetailService appUsersDetailService;

    /**
     * Configure
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Auth make by the bean [appUserDetailsService]
        // Password is crypted by BCrypt
        auth.userDetailsService(appUsersDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * Configure
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // CSRF
        http.csrf().disable();

        // The password are send by header Authorization: Basic xxxx
        //http.httpBasic();
        // Permit all for root website "/"
        http.authorizeRequests() //
            .antMatchers(HttpMethod.POST, "/", "/**").permitAll();
        // For only ADMIN_ROLE
        http.authorizeRequests() //
                .antMatchers("/admin", "/admin/**")
                .hasRole("ADMIN");
        // Login page
        http.authorizeRequests()
                .antMatchers("/login*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .usernameParameter("login")
                .passwordParameter("password")
                .failureUrl("/login?error=true")
                .and()
                .logout().logoutSuccessUrl("/login?logout=true");
        // No session
        //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * Configure
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/bootstrap/**");
    }
}
