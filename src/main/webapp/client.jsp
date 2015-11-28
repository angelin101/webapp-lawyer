
<%--
  Created by IntelliJ IDEA.
  UserDAO: Ангелин
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
 <h1 class="userH1"><strong>${client.name} ${client.surname}</strong></h1>
 <div class="arrow_box">
     <table>
         <caption>Личные данные</caption>
         <tr>
             <th>Паспорт</th>
             <th>${client.passport}</th>
         </tr>
         <tr>
             <th>ИНН</th>
             <th>${client.inn}</th>
         </tr>
         <tr>
             <th>Адрес</th>
             <th>${client.address}</th>
         </tr>
         <tr>
             <th>Телефон</th>
             <th>${client.telephoneNumber}</th>
         </tr>
         <tr>
             <th>E-mail</th>
             <th>${client.email}</th>
         </tr>
     </table>
 </div>
 <div class="arrow_box2">
     <table>
         <caption>Дела</caption>
         <tr>
             <th>№ п/п</th>
             <th>№ дела</th>
             <th>Предмет спора</th>
             <th>Другая сторона</th>
             <th>Состояние</th>
         </tr>
         <tr>
             <td>1</td>
             <td><a href="page/baton.html" title="Нажать для перехода к Делу">902/1102/15</a></td>
             <td>Конокрадство</td>
             <td>ЧП "Рога и копыта"</td>
             <td>В производстве</td>
         </tr>
         <tr>
             <td>2</td>
             <td><a href="page/baton.html" title="Нажать для перехода к Делу">Дело -- 2</a></td>
             <td>Изнасилование</td>
             <td>ЧП "Сосулька"</td>
             <td>Закрыто</td>
         </tr>
         <tr>
             <td>3</td>
             <td><a href="page/baton.html" title="Нажать для перехода к Делу">Дело -- 3</a></td>
             <td>Хищение гос. средств</td>
             <td>ЧП "Фемида"</td>
             <td>В производстве</td>
         </tr>
     </table>
 </div>
 <div class="containerBut"> <%--Распологаем кнопки в контейнер и "тусуем" сам контейнер--%>
     <a href="#" class="button">Планы работ</a>
     <a href="#" class="button">Робочие документы</a>
     <a href="#" class="button">Расходы</a>
 </div>
<%--
 <table border="1">
     <c:forEach items="${client}" var="client"> &lt;%&ndash; Делаем цикл с помошью библиотеки JSTL &ndash;%&gt;
         <tr>
             <td>${client.ID}</td>
             <td>${client.name}</td>
             <td>${client.surname}</td> &lt;%&ndash; Для предотвращения взлома HTMLя (Экранирует теги)&ndash;%&gt;
         </tr>
     </c:forEach>
 </table>
--%>

</body>
</html>
