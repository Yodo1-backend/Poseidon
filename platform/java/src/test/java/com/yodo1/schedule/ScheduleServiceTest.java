package com.yodo1.schedule;


import com.yodo1.utils.CommonUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.InetAddress;

/**
 * Created by YanFeng on 2017/12/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =  com.yodo1.TestContextConfig.class)
public class ScheduleServiceTest {

    @Before
    public void PrepareData()
    {

        System.out.println("Start Test:"+this.getClass().getName());
    }

    @Test
    public void IsProcessable_Test()
    {
        System.out.println("=======================test method IsProcessable start======================");


        System.out.println("=======================test method IsProcessable end======================");

    }

    @After
    public void ClearData()
    {
        System.out.println("Finish Test:"+this.getClass().getName());
    }

}
