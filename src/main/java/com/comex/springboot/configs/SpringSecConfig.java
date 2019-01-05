package com.comex.springboot.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * © Copyright Corp 2018<br>
 *
 *
 * The <code>com.comex.springboot.configs.SpringSecConfig</code> class is about web security
 * configure adapter.
 *
 *
 * @author mfmerola@gmail.com
 * @version 1.0
 * @since JDK1.8
 *
 *
 * @see org.springframework.context.annotation.Configuration;
 * @see org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 */
@Configuration
public class SpringSecConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/", "/swagger-resources")
                .permitAll();
        httpSecurity
                .csrf()
                .disable();
        // Disabling frame options
        httpSecurity
                .headers()
                .frameOptions()
                .disable();
    }
}