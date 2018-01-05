package com.yodo1.app;


import com.yodo1.formatlog.Yodo1LoggerFactory;
import com.yodo1.formatlog.Yodo1ServiceLogger;
import com.yodo1.poseidon.service.RPCClient;
import com.yodo1.poseidon.service.RPCServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by liuwenpeng on 2017/11/1.
 */
@Component
@Order(value = 1)
public class AppRunner implements ApplicationRunner {

    private Yodo1ServiceLogger logger = Yodo1LoggerFactory.getServiceLogger(AppRunner.class);

    private RPCServer innerServer;
    private RPCClient innerClient;
    @Override
    public void run(ApplicationArguments params) throws Exception
    {
        System.out.println("Ruun");
        logger.AddParam("Start","AppRunner");
        logger.ServiceFunctionLog("params:"+params.toString());
        List<String> s = params.getOptionValues("action");
        if(null != s && s.size() > 0)
        {
            switch (s.get(0))
            {
                case "server":{
                    StartAsServer();
                }break;
                case "client":{
                    StartAsClient();
                }break;
                    default:logger.ServiceFunctionLog("命令错误");
            }
        }
        else
        {
            //todo
            logger.ServiceFunctionLog("命令错误");
            StartAsServer();

        }

    }
    public void StartAsServer()
    {
        innerServer = new RPCServer();
        innerServer.SetServiceBridge(new ServiceBridger());
        innerServer.SetServicePort(30001);
        innerServer.Init();
    }
    public void StartAsClient()
    {
        innerClient = new RPCClient();
        innerClient.SetServerIP("192.168.1.211");
        innerClient.SetServerPort(30001);
        innerClient.SetTimeout(5000);
        if(innerClient.Init())
        {
            logger.ServiceFunctionLog("Connect Success!");
        }
        else
        {
            logger.ServiceFunctionLog("Connect Failure!");
        }
        innerClient.Stop();
    }

}
