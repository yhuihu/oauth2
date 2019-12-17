package com.demo.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .and()
                //管理session的创建策略永远不会创建HttpSession，它不会使用HttpSession来获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //ALWAYS总是创建HttpSession
                //IF_REQUIREDSpring Security只会在需要时创建一个HttpSession
                //NEVERSpring Security不会创建HttpSession，但如果它已经存在，将可以使用HttpSession
                .and()
                .authorizeRequests()
                .anyRequest().access("@permission.hasPermission(request,authentication)");
        // 以下为配置所需保护的资源路径及权限，需要与认证服务器配置的授权部分对应
//                .antMatchers("/**").hasAuthority("SystemContent");
    }

    @Autowired
    private OAuth2WebSecurityExpressionHandler expressionHandler;

    @Bean
    public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
        OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
        expressionHandler.setApplicationContext(applicationContext);
        return expressionHandler;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.expressionHandler(expressionHandler);
    }
}
