//tag::securityConfigOuterClass[]

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests().antMatchers("/","/*").access("permitAll");
       // http.csrf().disable().authorizeRequests().antMatchers("/booksapi").access("permitAll").antMatchers("/users", "/users_books").access("authenticated")
        //         .antMatchers("/", "/**").access("permitAll").and().formLogin().loginPage("/login").and().logout().logoutSuccessUrl("/");
    }

    @Autowired
    private UserRepositoryUserDetailsService userRepositoryUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userRepositoryUserDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }


// LDAP Authentication example

    /**
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
                .userSearchBase("ou=people")
                .userSearchFilter("(uid={0})")
                .groupSearchBase("ou=groups")
                .groupSearchFilter("member={0}").passwordCompare()
            .passwordEncoder(NoOpPasswordEncoder.getInstance())
            .passwordAttribute("passcode").and()
            .contextSource()
                .root("dc=tacocloud,dc=com");
    }

  /*

  //JDBC
  @Autowired
  DataSource dataSource;
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username, plain_password, enabled from Users where username=?")
              .authoritiesByUsernameQuery("select username, authority from userauthorities where username=?")
              .passwordEncoder(NoOpPasswordEncoder.getInstance());
  }
  */

  /*
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     auth.jdbcAuthentication().dataSource(dataSource);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username, password, enabled from Users where username=?").authoritiesByUsernameQuery("select username, authority from UserAuthorities where username=?");
  }

*/

/*
  //IN MEMORY
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).
            withUser("buzz").password("infinity").authorities("ROLE_USER")
            .and().withUser("woody").password("bullseye").authorities("ROLE_USER");
  }
*/



  /*
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/design", "/orders").access("hasRole('ROLE_USER')")
            .antMatchers("/", "/**").access("permitAll").and().formLogin().loginPage("/login").and().logout().logoutSuccessUrl("/")
      .and().csrf().ignoringAntMatchers("/h2-console/**")
      .and().headers().frameOptions().sameOrigin();
  }
  */

/*
  @Bean
  public PasswordEncoder encoder() {
    return new StandardPasswordEncoder("53cr3t");
  }
  */



//
// IN MEMORY AUTHENTICATION EXAMPLE
//




//tag::configureAuthentication_jdbc[]




//
// LDAP Authentication example
//
/*
//tag::configureAuthentication_ldap[]
  @Override
  protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
    auth
      .ldapAuthentication()
        .userSearchFilter("(uid={0})")
        .groupSearchFilter("member={0}");
  }
//end::configureAuthentication_ldap[]
*/

//tag::securityConfigOuterClass[]

}
//end::securityConfigOuterClass[]
