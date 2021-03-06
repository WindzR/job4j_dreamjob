<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.job4j.dream.store.PsqlStore" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Работа мечты</title>
</head>
<body>
<div class="container pt-3">

    <div class="row">
        <%@ include file = "/header.jsp" %>
        <div class="card" style="width: 100%">
            <div class="card-header">
                Кандидаты
            </div>
            <div class="card-body">
                <table class="table table-striped table-bordered">
                    <thead class="table-dark">
                        <tr>
                            <th scope="col">Названия</th>
                            <th scope="col">Фото</th>
                            <th scope="col">Город</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${candidates}" var="candidate">
                            <tr>
                                <td>
                                    <a href='<c:url value="/candidate/edit.jsp?id=${candidate.id}"/>'>
                                        <i class="fa fa-edit mr-3"></i>
                                    </a>
                                    <c:out value="${candidate.name}"/>
                                    <div>
                                        <form action="<c:url value='/candidates.do?id=${candidate.id}&action=delete'/>" method="post">
                                            <button type="submit" class="btn btn-warning btn-sm">Удалить кандидата</button>
                                        </form>
                                    </div>
                                </td>
                                <td>
                                    <img src="image/${candidate.id}.jpg" alt="тестовая картинка" class="img-thumbnail mx-auto" width="150px" height="150px">
                                    <div>
                                        <a class="btn btn-primary btn-sm" href="<%=request.getContextPath()%>/upload.jsp" role="button">Загрузить фото</a>
                                    </div>
                                </td>
                                <td>
                                    <c:if test="${candidate.cityId == 4}">
                                        <label>Нижний Новгород</label>
                                    </c:if>
                                    <c:if test="${candidate.cityId == 6}">
                                        <label>Казань</label>
                                    </c:if>
                                    <c:if test="${candidate.cityId == 7}">
                                        <label>Уфа</label>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>