<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>채이커리</title>
         <!--jquery-->
         <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
        
         <!--bootstrap-->
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
         <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
         <!--내가 만든 스타일시트-->
         <link rel="stylesheet" type="text/css" href="/static/css/style.css">
    </head>

    <body>
        <header>
            <jsp:include page="../include/managerHeader.jsp" />
        </header>

        <div>
			<jsp:include page="../${viewName}.jsp" />
        </div>

        <footer class="">


        </footer>
    </body>
</html>