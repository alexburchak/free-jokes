<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>Login page</title>
</head>
<body>

<form method="post" action="/j_security_check"/>
    <input type="text" name="j_username" class="input-block-level"/>
    <input type="password" name="j_password"/>

    <button type="submit">Login</button>
</form>
</body>
