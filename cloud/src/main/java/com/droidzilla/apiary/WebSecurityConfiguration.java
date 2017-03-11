package com.droidzilla.apiary;

import com.droidzilla.apiary.model.Beekeeper;
import com.droidzilla.apiary.repository.BeekeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

/**
 * Created by ac on 16/10/16.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    BeekeeperRepository beekeeperRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("WebSecurityConfiguration.init CALLED");
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                System.out.println("UserDetailsService.loadUserByUsername " + username);
                Beekeeper beekeeper = beekeeperRepository.findByEmail(username);
                System.out.println("Beekeeper " + beekeeper);
                if (beekeeper != null) {
                    System.out.println("found beekeeper " + beekeeper.getPassword());
                    return new User(beekeeper.getEmail(), beekeeper.getPassword(), true, true, true, true,
                            getGrantedAuthorities(beekeeper.getEmail()));
                } else {
                    throw new UsernameNotFoundException("could not find the user '"
                            + username + "'");
                }
            }

            private Collection<? extends GrantedAuthority> getGrantedAuthorities(String email) {
                System.out.println("Logged email:" + email);
                if (email.equals("andrei@y.com")) {
                    System.out.println("ROLE_ADMIN");
                    return AuthorityUtils.createAuthorityList("ROLE_ADMIN");
                }
                System.out.println("ROLE_USER");
                return AuthorityUtils.createAuthorityList("ROLE_USER");
            }

        };
    }


}