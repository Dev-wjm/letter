<%--
  User: WM  Date: 2018/1/3  Time: 9:50
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>登陆</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <style>
        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 15% auto;
        }
        .form-signin input {
            margin: 1rem 0;
        }
    </style>
</head>
<body>
    <nav class="nav navbar navbar-expand-md navbar-dark fixed-top bg-light justify-content-md-end">
        <p>登陆 | 注册</p>
    </nav>

    <div class="container">
        <form class="form-signin" action="">
            <h2>登陆界面</h2>
            <input type="email" id="inputEmail" class="form-control" placeholder="用户名" required="" autofocus="">
            <input type="password" id="inputPassword" class="form-control" placeholder="密码" required="">

            <button class="btn btn-lg btn-primary btn-block" type="submit">登入</button>
        </form>
    </div>

    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

</body>
</html>
