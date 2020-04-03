<%@ page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" contentType="text/html; ISO-8859-1" %>
<!doctype html>
    <head>
        <jsp:include page="../section/head.jsp"/>
    </head>
    <body>
        <header>
            <jsp:include page="../section/header.jsp"/>
        </header>
        <nav>
            <jsp:include page="../section/nav.jsp"/>
        </nav>
        <section class="main">
            <sitemesh:write property='body'/>
        </section>
        <footer>
            <jsp:include page="../section/footer.jsp"/>
        </footer>
        <jsp:include page="../section/external-scripts.jsp"/>
    </body>
</html>