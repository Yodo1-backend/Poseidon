package com.yodo1.app;

import com.yodo1.poseidon.service.RPCClient;
import com.yodo1.poseidon.service.RPCServer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by YanFeng on 2018/1/4.
 */
@Service
public class RPCHelper {
/*
    private int port = 30001;

    private RPCServer innerServer;
    private RPCClient innerClient;
    @Bean("server")
    public RPCHelper initAsServer()
    {
        innerServer = new RPCServer();
        innerServer.SetServiceBridge(new ServiceBridger());
        innerServer.SetServicePort(port);
        innerServer.Init();
        return this;
    }
    @Bean("client")
    public RPCHelper initAsClient()
    {
        innerClient = new RPCClient();
        innerClient.SetServerIP("127.0.0.1");
        innerClient.SetServerPort(30001);
        innerClient.SetTimeout(5000);
        if(innerClient.Init())
        {
            return this;
        }
        else
        {
            return null;
        }
    }
*/
}
