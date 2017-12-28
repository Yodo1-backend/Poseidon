package com.yodo1.poseidon.service;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Yanfeng on 2017/12/27.
 */
@Service
public class RPCManager {

    private final static int DEFAULT_PORT = 30001;

    private static TServer server = null;

    public RPCManager(){
        System.out.println("AA");
    }
    @Bean(value = "server")
    public RPCManager initAsServer()
    {
        try
        {
            TNonblockingServerSocket socket = new TNonblockingServerSocket(DEFAULT_PORT);
            ServiceCaller.Processor processor = new ServiceCaller.Processor(new ServiceCallerImp());
            TNonblockingServer.Args arg = new TNonblockingServer.Args(socket);
            arg.protocolFactory(new TBinaryProtocol.Factory());
            arg.transportFactory(new TFramedTransport.Factory());
            arg.processorFactory(new TProcessorFactory(processor));
            server = new TNonblockingServer (arg);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
        return this;
    }
    @Bean(value = "client")
    public RPCManager initAsClient()
    {
        return this;
    }
}
