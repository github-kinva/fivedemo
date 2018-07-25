<%--
  Created by IntelliJ IDEA.
  User: oujh
  Date: 2018/7/24
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <script src="js/echarts.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.1.js"></script>

</head>
<body>
    <div id="main" style="width: 600px; height: 400px;"></div>
    <script>
        var myChart = echarts.init(document.getElementById('main'));
/*-------------------------------------------*/
        var option = {
            //图表标题
            title : {
                text : 'ECharts折线图2：java班的就业率'
            },

            //X轴数据
            xAxis : {
                type: 'category',
                boundaryGap: false,
                data : [] //必须
            },
            yAxis : {type: 'value'},

            //系列列表
            series : [ {
                name : '访问量', //显示用
                type : 'line',//折线类型（必须项）
                data : [], //每一列的数据（必须）--ajax获取
                areaStyle: {}
            } ]
        };

/*----------------------------------------------------*/
        /*加载数据*/
        myChart.setOption(option);
        /*读取并显示*/
        myChart.showLoading();

/*-----------------------------------------------------*/
        /*修改的是这部分数据*/
        $.ajax({
            url:"line2.action",
            type:"get",
            dataType:"json",   //默认是文本类型,同时需要有json包
            success:function(data){
                alert(data)
                /*把json数据解析成数组*/
                var x=[];
                var y=[];
                for(var i=0;i<data.length;i++){
                    var j=data[i];
                    x.push(j.name);
                    y.push(j.value)
                }
                /*取消之前的动画*/
                myChart.hideLoading();
                /*动态赋值*/
                /*将获取的数据放置在指定的位置*/
                myChart.setOption({
                    xAxis : {
                        data : x
                    },
                    series : [ {
                        name : '数量',
                        data : y
                    } ]
                });

            },
            errot:function(){
                alert("加载数据失败")
            }

        });

    </script>
</body>
</html>
