package com.yodo1.poseidon.service;

import com.yodo1.formatlog.Yodo1LoggerFactory;
import com.yodo1.formatlog.Yodo1ServiceLogger;
import org.apache.thrift.TException;

import java.util.Map;

/**
 * Created by YanFeng on 2017/12/28.
 *
 * 协议中status的约定：
 * 1:正常
 * -2:服务端bridge未设置；
 * -3:服务端不包含methodName对应的处理
 * -4:服务端未知异常
 * -10:客户端的ReqParams不合法
 */
public class ServiceCallerImp implements ServiceCaller.Iface{

    private Yodo1ServiceLogger logger = Yodo1LoggerFactory.getServiceLogger(ServiceCallerImp.class);

    private IServiceBridge serviceBridge;

    public static final int STATUS_GOOD             = 1;
    public static final int STATUS_NO_BRIDGE        = -2;
    public static final int STATUS_NO_MAPPING_FUNC  = -3;
    public static final int STATUS_UNKNOWN_ERROR    = -4;
    public static final int STATUS_REQPARAMS_ILLEGAL= -10;

    public void SetBridge(IServiceBridge serviceBridge)
    {
        this.serviceBridge = serviceBridge;
    }

    public ResParams commonReturn(long startStamp,ResParams res)
    {
        res.serverTicks = System.currentTimeMillis() - startStamp;
        return res;
    }

    @Override
    public ResParams INVOKE(String methodName,ReqParams params) throws TException
    {

        ResParams result = new ResParams();
        long _startstamp = System.currentTimeMillis();
        /*
        Param tempParam = new Param();
        tempParam.type = ParamType.STRING;
        tempParam.body = "MIIEpAIBAAKCAQEAlE/0UqMfPbz9iBugrecugPSwrHzCX5ceRbCFFYSSCAw4A5rr" +
                "/z8mJ7D6Dw9W4ebzNSIfphVA9rKxqzmkN1JFwzJmcDk+bnCjWKBMqOdkOoLEY9eC" +
                "ZppQoyc92s/BFIPJiIF4zMvk7Syq2XevT9gHJ9MGTuDbzIUwPgdrNQidpfg3G/vk"+
                "2mNPYUyDJbJjRDqPBK8BSDpKiKM9fvKbss+KGqZhNwV46T4uniitrMZGTOR3pz+v"+
                "2YN4SOXhtE0hL1MqaaQ6T4Oz/uug+PNFaUM4wR54Z3STn3I2fVhBhnjxR1ZUMQMr"+
                "+DMq963O/fllJWL9Cm9LixvFMfe+AFlMaVYDUwIDAQABAoIBACmS/BcKGODSkHNN"+
                "4028R0Ho1XmUg1wOXXMFl1i/z7unyS/hhpQHXKe1qXL9RsqOVdCoHx0MSiidUMaB"+
                "ovHLAzlDcIm20jRdKLzYOoUCUAtCytB+AdTHHyGNB37FzAb3JlA4kuc9pI+DfOT2"+
                "8tK76M2WDuefip2bHDnXFItKPf7e1z0ZJY/WGMILtopTunNf9TPfDX3rceVCeLQV"+
                "VqCIElOfD6hfIxnDDDIw4NMiLVY0N9Ha5kGZO3nQ8PX1XxWc+BgsRbFZGr5UogND"+
                "pm5QgIjZJpbEc73bINMQXsjxR3aQN+EmiIotJ94+sP5fH9bh4xLehRzmuxViKcz/"+
                "qmLWDnECgYEAxER4WA67eqPWlmzpC5rptE/BEQ0nbK1E89xgA2iBrSMCq234GyDt"+
                "ZP0cv9gnxMmhlCzipitfAOQIuFy6W6tnL20Zd/O8+axRn2q/+Q6C1mbBZ9FHCbjX"+
                "TislmTPd2azQqcR2DUIuQyHzbnKO5dyaXgKMkFQ/tKnBMlIAHLOIaokCgYEAwXM3"+
                "36rQxxiBYpHSCnzmNzIeNEaZTNp1GYmg3k0xYclCJbD9Q8uL4vWorwZ6hOhWjPDJ"+
                "en25tZJCIz1tN1KedswLCGawsf9VrY6C+52VsH7grMHkNKDSBmBPsz5NN71recWT"+
                "hTwiR6ycqhQomHqMpUNdrhwJc3uj56196ecZV/sCgYARPB4BRZHrDBYc8YVpcnoR"+
                "TmuazrfmkDSc4X5A7l1s0cU7PpXp8/NEygFLS3T6j+Yzd9mTU/2su1mUrvficuPF"+
                "w2PYJ7wxhJNKV3pyKXcN0sorDrKZRPULNTjBAk/5/HX6YnknYudjF8kjqsWno76e"+
                "gMTNK8jIWZvQimjeHFnfWQKBgQCSe0VOtxB6AcNPOS27xVGpb+jRGrhQKodK/Bz0"+
                "16zR58yPr9JG+KUHCY9eYOB7LVcER/u4JeVuaL5t4sCFiKj3OZANH30iez6MOgJS"+
                "tsO3LovAJN1BQJloPJt9FWrxDxyHy6Tl2V/3t+u1GaiXtQw0w6r3AMHjUTcOYh+a"+
                "8uQM6wKBgQCD28AQWAYFDPTrhI0lAZ4bkUQqcMao1Q27DhSvKdVNdofNexJrvNP0"+
                "qsBcLfghMQAzOtoEzxeHEtMtP6n5P29reA9U9eczkfVXU7VQeHqDM44mjieWF7YY"+
                "WaqgVRyNkyTWgHRmXaZsHVWmgAQW7OdN1KBjSL5cAClxfsjRDpvZTA==";
        result.num = 88;
        result.paramsBody = new HashMap<String,Param>();
        result.paramsBody.put("testKey", tempParam);
        System.out.println("receive INVOKE:"+methodName+",params Num:"+params.num);
        return result;
        */
        if(null != serviceBridge)
        {
            try {
                Map<String,Param> resultFromBridge = this.serviceBridge.CallService(methodName,params.paramsBody);
                result.paramsBody = resultFromBridge;
                result.status = STATUS_GOOD;
            }
            catch (Exception e)
            {
                result.status = STATUS_UNKNOWN_ERROR;
            }
            finally
            {
                return commonReturn(_startstamp,result);
            }
        }
        else
        {
            result.status = STATUS_NO_BRIDGE;
            return commonReturn(_startstamp,result);
        }
    }
    @Override
    public void INVOKEOneWay(String methodName, ReqParams params) throws TException
    {
        ResParams result = new ResParams();
        long _startstamp = System.currentTimeMillis();
        if(null != serviceBridge)
        {
            try
            {
                this.serviceBridge.CallServiceOneWay(methodName,params.paramsBody);
            }
            catch (Exception e)
            {
                //todo log
            }
            finally
            {
                return ;
            }
        }
        else
        {
            //todo log
        }
    }
    @Override
    public int getConnectionsNum()
    {
        return 0;
    }
    @Override
    public String ping()
    {
        logger.ServiceFunctionLog("receive PING");
        return "Pong!";
    }
}
