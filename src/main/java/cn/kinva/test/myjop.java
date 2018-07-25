package cn.kinva.test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;


public class myjop implements Job {

     //添加定时任务依赖后，实现execute方法
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date());
    }
}
