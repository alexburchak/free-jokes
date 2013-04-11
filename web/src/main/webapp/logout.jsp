<%
    if (request.getSession(false) != null) {
        session.invalidate();
    }
%>
