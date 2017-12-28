package com.yodo1;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by YanFeng on 2017/11/13.
 */
@Configuration
@PropertySource(value = "classpath:application.properties")
@ComponentScan({"com.yodo1.app"})
public class TestContextConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
