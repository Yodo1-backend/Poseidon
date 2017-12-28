package com.yodo1.poseidon.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by Yanfeng on 2017/12/27.
 */
@Service
public class RPCManager {

    @Bean
    public RPCManager init()
    {
        return this;
    }
}
