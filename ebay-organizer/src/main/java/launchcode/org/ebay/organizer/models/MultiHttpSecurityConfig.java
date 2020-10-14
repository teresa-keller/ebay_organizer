package launchcode.org.ebay.organizer.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@EnableWebSecurity
public class MultiHttpSecurityConfig {
    @Bean
    public UserDetailsService multiUserDetailsService() throws Exception {
        //ensure the passwords are encoded properly
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("password").roles("USER").build());
        manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build());
        return manager;
    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .antMatcher("/api/**")
                    .authorizeRequests(authorize -> authorize
                    .anyRequest().hasRole("ADMIN")
                    )
                    .httpBasic(Customizer.withDefaults());
        }
    }

    @Configuration
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .authorizeRequests(authorize -> authorize
                    .anyRequest().authenticated()
                    )
                    .formLogin(Customizer.withDefaults());
        }
    }
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests(authorize -> authorize
                        .anyRequest().authenticated()
                        .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                            public <O extends FilterSecurityInterceptor> O postProcess(
                                    O fsi) {
                                fsi.setPublishAuthorizationSuccess(true);
                                return fsi;
                            }
                        })
                );
    }

}
