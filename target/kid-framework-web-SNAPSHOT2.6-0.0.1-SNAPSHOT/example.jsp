<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Example页面</title>

<script type="text/javascript" src="static/js/jquery-1.4.4.min.js"></script>
</head>

<body>

<h1 id="showResponseName">返回响应数据=><span id="showData"></span></h1>

<script type="text/javascript">
$(document).ready(function(){
	
	$.ajax({
		url:"/kid-framework-web-SNAPSHOT2.6/show.do",
	    type:"GET",
	    data:{
	    	"message":"***前台传递消息***"
	    },
	    dataType:"json",
	    success:function(data){
	    	
	    	$("#showData").html(data.name);
	    	
	    }
	});
	
});
</script>

</body>

</html>