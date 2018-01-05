package com.yodo1.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by Yanfeng on 2017/12/27.
 */
@SpringBootApplication
@EnableAsync
@ComponentScan({"com.yodo1.app","com.yodo1.poseidon.service"})
public class Application {


    public static void main(String[] args) throws Exception {

        System.out.println("hello");
        /*
        Map<String,String> sysEnv = System.getenv();
        Properties properties = System.getProperties();

        for (Map.Entry name:properties.entrySet()) {
            System.out.println(name.getKey().toString()+":"+name.getValue().toString());
        }
        System.out.println("Propertis:"+properties.size());
        */

        SpringApplication.run(Application.class,args);
    }
/*
    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(16);
        executor.setMaxPoolSize(48);
        executor.setQueueCapacity(50);
        executor.setKeepAliveSeconds(600);
        executor.setThreadNamePrefix("zeus-");
        executor.initialize();
        System.out.println("asyncExecutor");
        return executor;
    }
*/
}
