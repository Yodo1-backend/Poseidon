package com.yodo1.poseidon.service;

/**
 * Created by Yanfeng on 2017/12/28.
 */
public interface IServiceBridge {

    public java.lang.String ping() throws org.apache.thrift.TException;

    public int getConnectionsNum() throws org.apache.thrift.TException;

    public Params CallService(java.lang.String targetService, Params params) throws org.apache.thrift.TException;

    public void INVOKEOneWay(java.lang.String targetService, Params params) throws org.apache.thrift.TException;

}