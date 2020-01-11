<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>您好Springboot</title>

<!-- 引入jquery 函数 -->
<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>
<script type="text/javascript">

	//利用jQuery加载页面 函数式编程
	$(function(){

		//发起ajax请求,获取用户页面数据
		/*
		url:待载入页面URl地址
		data:待发送Key/value参数
		callback:载入成功时回调函数
		type:返回内容格式,xml,html,script.json,text
		*/

		$.get("/findAjaxUser",function(result){

		//result返回的数据板式为JSON,被JS解析
		//1.获取状态码信息
		if(result.status == 200){
			debugger
			addTr(result.data);
		}else{
			alert(result.msg);
		} 
	})
	});
	function addTr(data){

		var trs = "";
		//遍历返回值结果
		$(data).each(function(index,user){
			//动态获取每一个user JS对象
			//var user = data[index];
			var id = user.id;
			var name = user.name;
			var age = user.age;
			var sex = user.sex;
			trs += "<tr align='center'><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td>"+sex+"</td></tr>";
			});

			//将标签追加到table中
			$("#tab1").append(trs);
		}

</script>
</head>
<body>
	<table id="tab1" border="1px" width="65%" align="center">
		<tr>
			<td colspan="6" align="center"><h3>学生信息</h3></td>
		</tr>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th></th>
		</tr>	
	</table>
</body>
</html>