package com.yodo1.poseidon.service;

import java.util.Map;

/**
 * Created by Yanfeng on 2017/12/28.
 */
public interface IServiceBridge {

  //  public java.lang.String ping() throws org.apache.thrift.TException;

   // public int getConnectionsNum() throws org.apache.thrift.TException;

    public Map<java.lang.String,Param> CallService(java.lang.String targetService, Map<java.lang.String,Param> params);

    public void CallServiceOneWay(java.lang.String targetService, Map<java.lang.String,Param> params);

}