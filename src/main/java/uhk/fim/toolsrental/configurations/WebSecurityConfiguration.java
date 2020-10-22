package uhk.fim.toolsrental.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /* Nastavuje, ktere URL cesty budou zabezpeceny a ktere ne */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test").authenticated()
                .anyRequest().permitAll() //vsechny url jsou dostupne bez prihlaseni
                .and()
                //nastavi kde se nachazi login page
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll().logoutSuccessUrl("/");
    }

}
