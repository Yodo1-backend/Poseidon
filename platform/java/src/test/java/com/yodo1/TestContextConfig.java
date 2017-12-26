package com.yodo1;

import com.yodo1.config.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by YanFeng on 2017/11/13.
 */
@Configuration
@Import({RedisConfig.class, MysqlConfig.class})
@PropertySource(value = "classpath:application.properties")
@ComponentScan({"com.yodo1.app", "com.yodo1.service", "com.yodo1.entity", "com.yodo1.dao"})
public class TestContextConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
