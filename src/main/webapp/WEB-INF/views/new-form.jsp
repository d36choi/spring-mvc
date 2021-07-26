<%--
  Created by IntelliJ IDEA.
  User: a1101490
  Date: 2021/07/26
  Time: 11:52 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--앞에 슬래시 없으면 상대경로 사용 [현재 주소 속한 계층경로 + /save] --%>
<%--WEB-INF 경로에 있다면 JSP 를 외부에서 직접 호출불가하고 온리 컨트롤러 통해서 호출가능 --%>
<form action="save" method="post">
    username: <input type="text" name="username">
    age:      <input type="text" name="age">
    <button type="submit">전송</button>
</form>
</body>
</html>
