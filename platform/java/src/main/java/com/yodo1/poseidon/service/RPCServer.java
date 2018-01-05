package com.yodo1.poseidon.service;

import com.yodo1.formatlog.Yodo1LoggerFactory;
import com.yodo1.formatlog.Yodo1ServiceLogger;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by Yanfeng on 2017/12/27.
 */
public class RPCServer {

    private Yodo1ServiceLogger logger = Yodo1LoggerFactory.getServiceLogger(RPCServer.class);

    private final static int DEFAULT_PORT = 30001;
    private int port = 0;
    public ServiceCallerImp callerImp = null;
    private ListenThread listenThread;

    public void SetServiceBridge(IServiceBridge bridge)
    {
        this.callerImp = new ServiceCallerImp();
        this.callerImp.SetBridge(bridge);
    }
    public void SetServicePort(int port)
    {
        this.port = port;
    }
    public void Init()
    {
        if(port <= 0)
        {
            port = DEFAULT_PORT;
        }
        listenThread = new ListenThread(this.callerImp,DEFAULT_PORT);
        listenThread.start();
    }
}
