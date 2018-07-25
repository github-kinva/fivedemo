package cn.kinva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.log.LogInputStream;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EcharsController {
    /*一般都是先进行简单的测试先，在进行下一部的代码编写，这样容易发现每步是否出现错误*/
    /*@RequestMapping("/bar.action")
    @ResponseBody
    public String bar(){
        System.out.println("===");
        return "ok";
    }*/

    /*柱形图*/
/*将每个数据进行封装，成一个list集合，在显示成json数据*/
    @RequestMapping("/bar.action")
    @ResponseBody
    public List<ResultBean> bar() {
        ResultBean bean1 = new ResultBean();
        bean1.setName("a");
        bean1.setValue(200 + " ");

        ResultBean bean2 = new ResultBean();
        bean2.setName("b");
        bean2.setValue(300 + " ");

        ResultBean bean3 = new ResultBean();
        bean3.setName("c");
        bean3.setValue(500 + " ");

        ResultBean bean4 = new ResultBean();
        bean4.setName("d");
        bean4.setValue(100 + " ");

        List<ResultBean> list = new ArrayList<ResultBean>();
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);

        return list;
    }


    /*饼状图*/
    @RequestMapping("/pie.action")
    @ResponseBody
    public List<ResultBean> pie(){
        ResultBean bean1 = new ResultBean();
        bean1.setName("a");
        bean1.setValue(50 + " ");

        ResultBean bean2 = new ResultBean();
        bean2.setName("b");
        bean2.setValue(80 + " ");

        ResultBean bean3 = new ResultBean();
        bean3.setName("c");
        bean3.setValue(150 + " ");

        ResultBean bean4 = new ResultBean();
        bean4.setName("d");
        bean4.setValue(200 + " ");

        List<ResultBean> list2=new ArrayList<ResultBean>();
        list2.add(bean1);
        list2.add(bean2);
        list2.add(bean3);
        list2.add(bean4);

        return list2;


    }



    /*折线图*/

    @RequestMapping("/line.action")
    @ResponseBody
    public List<ResultBean> line(){
        ResultBean bean1 = new ResultBean();
        bean1.setName("a");
        bean1.setValue("50");

        ResultBean bean2 = new ResultBean();
        bean2.setName("b");
        bean2.setValue("90");

        ResultBean bean3 = new ResultBean();
        bean3.setName("c");
        bean3.setValue("40");

        ResultBean bean4 = new ResultBean();
        bean4.setName("d");
        bean4.setValue("80");

        List<ResultBean> listline=new ArrayList<ResultBean>();
        listline.add(bean1);
        listline.add(bean2);
        listline.add(bean3);
        listline.add(bean4);

        return listline;

    }
    /*折线图2*/

    @RequestMapping("/line2.action")
    @ResponseBody
    public List<ResultBean> line2(){
        ResultBean bean1 = new ResultBean();
        bean1.setName("小强");
        bean1.setValue("50");

        ResultBean bean2 = new ResultBean();
        bean2.setName("小米");
        bean2.setValue("90");

        ResultBean bean3 = new ResultBean();
        bean3.setName("小马");
        bean3.setValue("40");

        ResultBean bean4 = new ResultBean();
        bean4.setName("小单");
        bean4.setValue("80");

        List<ResultBean> listline2=new ArrayList<ResultBean>();
        listline2.add(bean1);
        listline2.add(bean2);
        listline2.add(bean3);
        listline2.add(bean4);

        return listline2;

    }

}


