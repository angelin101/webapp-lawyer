<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>Адвокат</title>
	<link rel="stylesheet" href="css/style.css">
	<link rel="shortcut icon" href="images/icon.png" type="image/x-icon">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
</head>
<body>
<div class="hdr">
	<span>И</span><span>н</span><span>ф</span><span>о</span><span>р</span><span>м</span><span>а</span><span>ц</span><span>и</span><span>о</span><span>н</span><span>н</span><span>о</span><span> - </span><span>п</span><span>р</span><span>а</span><span>в</span><span>о</span><span>в</span><span>а</span><span>я </span><span>с</span><span>и</span><span>с</span><span>т</span><span>е</span><span>м</span><span>а</span>
	<div><span>"</span><span>А</span><span>д</span><span>в</span><span>о</span><span>к</span><span>а</span><span>т</span><span>"</span></div>
</div>
<div id="wrapper">
    <div class="user-icon"></div>
    <div class="pass-icon"></div>

<form name="login-form" class="login-form" action="/authorize" method="post">

    <div class="header">
		<h1>Авторизация</h1>
		<span>Введите ваши регистрационные данные для входа в ваш личный кабинет. </span>
		<%-- Отсуюда до </div> код на Java для отображения строки об ошибке ввода данных (ГОВНОКОД)
		И иконки поднимаються (логина и пароля)--%>
		<%	String er = "";
			if(!(request.getAttribute("error")==null)){
				er = request.getAttribute("error").toString();
			}%>
		<p><font color="red"><%=er%></font></p>
    </div>

    <div class="content">
		<input name="username" type="text" class="input username" value="Логин" onfocus="this.value=''" />
		<input name="password" type="password" class="input password" value="Пароль" onfocus="this.value=''" />
    </div>

    <div class="footer">
		<input type="submit" name="submit" value="ВОЙТИ" class="button"/>
		<input type="submit" name="submit" value="Регистрация" class="register" />
    </div>

</form>
</div>
<div class="gradient"></div>

<script type="text/javascript">
$(document).ready(function() {
	$(".username").focus(function() {
		$(".user-icon").css("left","-48px");
	});
	$(".username").blur(function() {
		$(".user-icon").css("left","0px");
	});

	$(".password").focus(function() {
		$(".pass-icon").css("left","-48px");
	});
	$(".password").blur(function() {
		$(".pass-icon").css("left","0px");
	});
});
</script>
</body>
</html>
