package com.yodo1.app;


import com.yodo1.formatlog.Yodo1Logger;
import com.yodo1.formatlog.Yodo1Logger.*;
import com.yodo1.formatlog.Yodo1LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadFactory;


/**
 * Created by liuwenpeng on 2017/11/1.
 */
@Component
@Order(value = 1)
public class AppRunner implements ApplicationRunner {

    private Yodo1Logger logger = Yodo1LoggerFactory.getLogger(AppRunner.class);

   // @Autowired
   // private WorkThreadDirector director;
    @Override
    public void run(ApplicationArguments params) throws Exception
    {
        logger.AddParam("Start","AppRunner");
        logger.StartFunctionLog(LogLevel.ERROR,"params:"+params.toString());
        List<String> s = params.getOptionValues("action");
        if(null != s && s.size() > 0)
        {
            switch (s.get(0))
            {
                case "launch":{
                 //   director.StartRuntimeLoop();
                }break;
                case "schedule":{
                   // director.StartScheduleLoop();
                }break;
                    default:logger.EndFunctionLog(LogLevel.ERROR,ResultDefine.FAILURE,"命令错误");
            }
        }
        else
        {
            //todo
            logger.EndFunctionLog(LogLevel.ERROR,ResultDefine.FAILURE,"命令错误");
           // director.StartScheduleLoop();

        }

    }

}
