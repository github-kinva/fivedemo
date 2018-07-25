package cn.kinva.test;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class quartz {
    /*public static void main(String[] args) throws SchedulerException, InterruptedException {
        //1.job
       JobDetail Job= JobBuilder.newJob(myjop.class).withIdentity("job1","group1").build();

        //2.时间规则 5秒10次
        SimpleScheduleBuilder simpleScheduleBuilder=SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(10);

        //3.创建触发器
        SimpleTrigger trigger=TriggerBuilder.newTrigger().withIdentity("triger1","group1").withSchedule(simpleScheduleBuilder).startNow().build();

        //4.调度器
        Scheduler scheduler =new StdSchedulerFactory().getScheduler();

        scheduler.scheduleJob(Job,trigger);
        scheduler.start(); //调用start方法，开始执行

        Thread.sleep(120*1000); //线程停止

    }
    */

    /*cron*/
    public static void main(String[] args) {
        //1.job
        JobDetail Job= JobBuilder.newJob(myjop.class).withIdentity("job1","group1").build();

        //时间BUILDER
        CronScheduleBuilder cronScheduleBuilder=CronScheduleBuilder.cronSchedule("0/5 * * * * ?"); //从第0秒开始，等5秒增长

        //创建触发器
        CronTrigger trigger=TriggerBuilder.newTrigger().withIdentity("trigger2","group2").withSchedule(cronScheduleBuilder).startNow().build();

        //从工厂获取调度器
        Scheduler scheduler= null;
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.scheduleJob(Job,trigger);
            scheduler.start();

            try {
                Thread.sleep(120*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (SchedulerException e) {
            e.printStackTrace();
        }



    }
}
