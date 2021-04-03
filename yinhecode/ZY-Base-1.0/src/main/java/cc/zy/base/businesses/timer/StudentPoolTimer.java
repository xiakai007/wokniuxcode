package cc.zy.base.businesses.timer;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;
/**
 *
 * @author zhangkai
 * @date 2021-02-01 10:55:03
 */
@Component
public class StudentPoolTimer implements SchedulingConfigurer {
    private static  String cron = "0 0/5 * * * ? ";
    private static  boolean  switchStudentPool;


    public static void update(String NewCron,boolean  NewswitchStudentPool ){
        cron=NewCron;
        switchStudentPool=NewswitchStudentPool;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                try {
                    if(switchStudentPool){
                         ThreadPoolExecutor poolExecutor = StudentPollExecutor.getStudentPollExecutor().getThreadPoolExecutor();
                         poolExecutor.execute(new Thread(new Runnable() {
                            @Override
                            public void run() {
                                //执行任务
                                System.out.println(Thread.currentThread().getName()+"  ");
                            }
                        }));
                    }else {
//                        System.out.println("关闭定时任务");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                System.out.println("cron="+cron);
                return new CronTrigger(cron).nextExecutionTime(triggerContext);
            }
        });
    }
}
