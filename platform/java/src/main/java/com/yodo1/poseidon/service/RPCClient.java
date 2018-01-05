package com.yodo1.poseidon.service;

import com.yodo1.formatlog.Yodo1LoggerFactory;
import com.yodo1.formatlog.Yodo1ServiceLogger;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.*;


import java.util.Map;

import static com.yodo1.poseidon.service.ServiceCallerImp.STATUS_GOOD;

/**
 * Created by YanFeng on 2018/1/4.
 */
public class RPCClient {

    private Yodo1ServiceLogger logger = Yodo1LoggerFactory.getServiceLogger(RPCClient.class);

    private ServiceCaller.Client innerClient;
    private TTransport innerTransport;
    private String ipaddress;
    private int port;
    private int timeout;
    public void SetServerIP(String ip)
    {
        this.ipaddress = ip;
    }
    public void SetServerPort(int port)
    {
        this.port = port;
    }
    public void SetTimeout(int timeout)
    {
        this.timeout = timeout;
    }
    public boolean Init()
    {
        try
        {
            if(null == ipaddress || "".equals(ipaddress))
            {
                ipaddress = "127.0.0.1";
            }
            if(port == 0)
            {
                port = 30001;
            }
            if(timeout == 0)
            {
                timeout = 5000;
            }
            innerTransport = new TFastFramedTransport(new TSocket(ipaddress, port, timeout));
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(innerTransport);

            innerClient = new ServiceCaller.Client(protocol);

            innerTransport.open();

            String string = innerClient.ping();

            logger.ServiceFunctionLog("Receive:"+string);
            return "Pong!".equals(string);

        } catch (TException e)
        {
            logger.ServiceFunctionLog("Exc:"+e.getMessage());
            return false;
        }
    }
    public void Stop()
    {
        if(null != innerTransport)
        {
            try
            {
                innerTransport.flush();
                innerTransport.close();
            }
            catch (Exception e)
            {
                logger.ServiceFunctionLog("Exc:"+e.getMessage());
            }


        }
    }
    public Map<String,Param> CallService(String serviceName, Map<String,Param> paramMap)
    {
        ReqParams reqParams = new ReqParams();
        reqParams.paramsBody = paramMap;
        reqParams.num = null == paramMap?0:paramMap.size();
        long _startTime = System.currentTimeMillis();
        logger.ServiceFunctionLog("Calling:"+serviceName);
        try
        {
            ResParams resParams = this.innerClient.INVOKE(serviceName,reqParams);
            logger.ServiceFunctionLog("Get Res:"+resParams.status);
            logger.ServiceFunctionLog("Total Duration:"+(System.currentTimeMillis() - _startTime));
            logger.ServiceFunctionLog("Server Duration:"+resParams.serverTicks);
            if(resParams.status == STATUS_GOOD)
            {
                return resParams.paramsBody;
            }
            else
            {
                return null;
            }

        }
        catch (Exception e)
        {
            logger.ServiceFunctionLog("Exc:"+e.getMessage());
            return null;
        }

    }
}
