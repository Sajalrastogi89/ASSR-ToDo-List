<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="asl.css">
</head>
<body>
    <div class="login-box">
        <h2>Login</h2>
        <form action="login" method="post">
          <div class="user-box">
            <input type="text" name="name" required="">
            <label>Username</label>
          </div>
           <div class="user-box">
            <input type="text" name="mobile" required="">
            <label>Mobile</label>
          </div>
          <div class="user-box">
            <input type="password" name="password" required="">
            <label>Password</label>
          </div>
          <a href="#">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
         <input type="submit">
          </a>
                    <a href="sign up.jsp">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            Sign up
          </a>
        
        </form>
      </div>
</body>
</html>