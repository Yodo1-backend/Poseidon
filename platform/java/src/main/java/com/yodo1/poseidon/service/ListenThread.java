package com.yodo1.poseidon.service;

import com.yodo1.formatlog.Yodo1LoggerFactory;
import com.yodo1.formatlog.Yodo1ServiceLogger;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by YanFeng on 2018/1/4.
 */
public class ListenThread extends Thread{

    private Yodo1ServiceLogger logger = Yodo1LoggerFactory.getServiceLogger(ListenThread.class);

    private TServer server = null;
    private int port;
    public ServiceCallerImp callerImp = null;
    public ListenThread(ServiceCallerImp caller, int port)
    {
        super("Listen-RPC-Thread");
        this.callerImp = caller;
        this.port = port;
    }
    @Override
    public void run()
    {
        try
        {
            TNonblockingServerSocket socket = new TNonblockingServerSocket(this.port);
            ServiceCaller.Processor processor = new ServiceCaller.Processor(this.callerImp);
            TThreadedSelectorServer.Args arg = new TThreadedSelectorServer.Args(socket);
            arg.protocolFactory(new TBinaryProtocol.Factory());
            arg.transportFactory(new TFramedTransport.Factory());
            arg.processorFactory(new TProcessorFactory(processor));

            arg.selectorThreads(2);
            // 工作线程池
            ExecutorService pool = Executors.newFixedThreadPool(3);
            arg.executorService(pool);

            this.server = new TThreadedSelectorServer(arg);
            logger.ServiceFunctionLog("Start Service:");
            this.server.serve();
            logger.ServiceFunctionLog("Started Service");
        } catch (Exception e) {
            logger.ServiceFunctionLog("Exc:"+e.getMessage());
        }
    }
}
