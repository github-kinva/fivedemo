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
        var option = {
            title : {
                text : 'ECharts饼状图：新闻数据访问量'
            },
            series : [ {
                name : '访问量',
                type : 'pie',
                itemStyle : {
                    normal : {
                        label : {
                            show : true,
//格式器
                            formatter : '{b} : {c} ({d}%)'
                        },
                        labelLine : {
                            show : true
                        }
                    }
                },
                //设定图表的缩放比例
                radius : '60%',
//data中使用name代表圆饼中各小块的名称,value为对应的数值
                data : []
            } ]
        };


        /*加载数据*/
        myChart.setOption(option);
        /*读取并显示*/
        myChart.showLoading();


        /*修改的是这部分数据*/
        $.ajax({
            url:"pie.action",
            type:"get",
            dataTypt:"json",
            success:function (data) {
                alert("data");
                /*取消动画*/
                myChart.hideLoading();
                /*动态赋值*/
                myChart.setOption({
                    series:[{
                        data:data
                    }]
                })

            },
            error:function () {
                alert("加载失败");
            }





        })

    </script>
</body>
</html>
