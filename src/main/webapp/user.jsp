
<%--
  Created by IntelliJ IDEA.
  User: Ангелин
  Date: 27.10.2015
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Адвокат</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="shortcut icon" href="images/icon.png" type="image/x-icon">
</head>
<body>
 <h1 class="userH1"><strong>Информационно - правовая система "Адвокат"</strong></h1>
 <h2>Test Start</h2>
 <h3>Test Start</h3>
 <h4>Test Start</h4>
 <table border="1">
     <c:forEach items="${client}" var="client"> <%-- Делаем цикл с помошью библиотеки JSTL --%>
         <tr>
             <td>${client.ID}</td>
             <td>${client.name}</td>
             <td>${client.surname}</td> <%-- Для предотвращения взлома HTMLя (Экранирует теги)--%>
         </tr>
     </c:forEach>
 </table>

</body>
</html>
