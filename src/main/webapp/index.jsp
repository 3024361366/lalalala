<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            // 发送ajax请求，加载所有省份数据
            $.get("provinceServlet",{},function (data) {
                //[{"id":1,"name":"北京"},{"id":2,"name":"上海"},{"id":3,"name":"广州"},{"id":4,"name":"陕西"}]
                //1.获取select
                var province = $("#province");
                //2.遍历json数组
                $(data).each(function () {
                    //3.创建<option>
                    var option = "<option value='" + this.id + "'>" + this.name + "</option>";
                    //4.调用select的append追加option
                    province.append(option);
                });
            });

       $("#province").change(function () {
           alert($(this).val());
           $.get("cityServlet",{id:$(this).val()},function (data) {
               //[{"id":1,"name":"北京"},{"id":2,"name":"上海"},{"id":3,"name":"广州"},{"id":4,"name":"陕西"}]
               //1.获取select
               var city = $("#city");
               //2.遍历json数组
               $(data).each(function () {
                   //3.创建<option>
                   var option = "<option value='" + this.id + "'>" + this.name + "</option>";
                   //4.调用select的append追加option
                   city.append(option);
               });
           });
       })
        $("#city").change(function () {
            alert($(this).val());
            $.get("countryServlet",{id:$(this).val()},function (data) {
                //[{"id":1,"name":"北京"},{"id":2,"name":"上海"},{"id":3,"name":"广州"},{"id":4,"name":"陕西"}]
                //1.获取select
                var country = $("#country");
                //2.遍历json数组
                $(data).each(function () {
                    //3.创建<option>
                    var option = "<option value='" + this.id + "'>" + this.name + "</option>";
                    //4.调用select的append追加option
                    country.append(option);
                });
            });
        })
        });
    </script>
</head>
<body>
<select id="province">
    <option>--请选择省份--</option>
</select>
<select id="city">
    <option>--请选择城市--</option>
</select>
<select id="country" >
    <option>--请选择县--</option>
</select>
</body>
</html>