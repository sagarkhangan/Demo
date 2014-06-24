<html>
    <head>
      
        <title>mypage</title>
    </head>
    <body>
               <jsp:useBean id="mybean" scope="session" class="Model.NameModel" />
              Hello  <jsp:getProperty name="mybean" property="name" />
    </body>
</html>
