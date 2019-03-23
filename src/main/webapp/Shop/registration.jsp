<%@ page import="java.util.ArrayList, shop.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>

<html class="no-js">
<head>
    <meta charset="utf-8">
    <title>Guitar Store - products</title>

    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet">

    <link rel="stylesheet" href="Shop/css/bootstrap.css">
    <link rel="stylesheet" href="Shop/css/normalize.min.css">
    <link rel="stylesheet" href="Shop/css/font-awesome.min.css">
    <link rel="stylesheet" href="Shop/css/animate.css">
    <link rel="stylesheet" href="Shop/css/templatemo-misc.css">
    <link rel="stylesheet" href="Shop/css/templatemo-style.css">
    <link href="Shop/css/style.css" rel="stylesheet" />

</head>

<body>

    <header class="site-header">
        <div class="top-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-sm-6">
                        <div class="top-header-left">
						    <a href="login">Log In</a>
                            <a href="registration">Sign Up</a>
							<c:if test="${not empty sessionScope['user']}">
							<a href="profileEdit">Profile Edit</a>
							</c:if>
                        </div> <!-- /.top-header-left -->
                    </div> <!-- /.col-md-6 -->
                    <div class="col-md-6 col-sm-6">
                        <div class="social-icons">
                            <ul>
                                <li><a href="#" class="fa fa-facebook"></a></li>
                                <li><a href="#" class="fa fa-dribbble"></a></li>
                                <li><a href="#" class="fa fa-twitter"></a></li>
                                <li><a href="#" class="fa fa-linkedin"></a></li>
                            </ul>
                            <div class="clearfix"></div>
                        </div> <!-- /.social-icons -->
                    </div> <!-- /.col-md-6 -->
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </div> <!-- /.top-header -->
        <div class="main-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 col-sm-6 col-xs-8">
                        <div class="logo">
                            <h1><a href="products">Guitar ¯\_(ツ)_/¯ Store</a></h1>
                        </div> <!-- /.logo -->
                    </div> <!-- /.col-md-4 -->
                    <div class="col-md-8 col-sm-6 col-xs-4">
                        <div class="main-menu">
                            <a href="#" class="toggle-menu">
                                <i class="fa fa-bars"></i>
                            </a>
                            <ul class="menu">
                                <li><a href="products">Home</a></li>
                                <li><a href="products">Products</a></li>
                                <li><a href="projectsOpen">Additional projects</a></li>
                                <li><a href="contacts">Contacts</a></li>
                            </ul>
                        </div> <!-- /.main-menu -->
                    </div> <!-- /.col-md-8 -->
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </div> <!-- /.main-header -->
    </div>
	<hr/>


<div class="content-section">
<div class="container">

<form id="loginForm" action="" method="post">



<c:choose>
	<c:when test="${not empty sessionScope['user']}">
		<h1>Already registred</h1>
	</c:when>
	<c:otherwise>
			<c:if test="${not empty requestScope['error']}" >
				${requestScope['error']}
			</c:if>
			
		<c:choose>	
			<c:when test="${not empty requestScope['reg']}">
				<div class='field'><label style='color:green'><h1>REGISTRED!!!!!</h1></label></div>
				<div class='field'><label style='color:green'><a href='login'>Return to login page</a></label></div>
			</c:when>
			<c:otherwise>
				<div class="field">
					<label>Enter your login ( login must be an email ):</label>
					<div class="input"><input type="text" name="login" value="" required="required" id="login" /></div>
				</div>

				<div class="field">
					<label>Enter your password:</label>
					<div class="input"><input type="password" name="pas1" value="" required="required"  id="pass" /></div>
				</div>
				
				<div class="field">
					<label>Enter your password:</label>
					<div class="input"><input type="password" name="pas2" value="" required="required"  id="pass"  /></div>
				</div>
				
				<div class="field">
					<label>Enter your Name:</label>
					<div class="input"><input type="text" name="name" value="" required="required" id="login"  /></div>
				</div>
				
				<div class="field">
					<label>Enter your Name:</label>
					<div class="input">
					<input type="radio" name="gender" value="Male"   id="login" />M
					<input type="radio" name="gender" value="Female"   id="login" />F
					</div>
				</div>
				
				<div class="field">
					<label>Choose a gender:</label>
					<div class="input">
					<select name="area" id="login">
						<option value="LNR">LNR</option>
						<option value="DNR">DNR</option>
						<option value="Other">Other</option>
					</select>
					</div>
				</div>
				
				<div class="field">
					<label>Leave your comment:</label>
					<div class="input"><textarea name='comment' rows='4'  cols='8'></textarea></div>
				</div>
				
				<div class="field">
					<label>I agree to recieve your spam... :</label>
					<div class="input"><input type="checkbox" name="spam" value="" id="login" /></div>
				</div>

				<div class="submit">
					<button type="submit">Enter</button>
				</div>
				
				<div class="submit">
					<a href="login"><button type="submit">Return to Autorization page</button></a>
				</div>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>
</div>
</div>

    <footer class="site-footer">
        <div class="bottom-footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <span>Guitar Store &copy; 2018 <a href="#">Andrii Andrusiv</a></span>
                        <p>Guitar store is a Ecommerce project made while studying at ITEA Java Web course.</p>
                    </div> <!-- /.col-md-12 -->
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </div> <!-- /.bottom-footer -->
    </footer> <!-- /.site-footer -->


    <script src="Shop/js/vendor/modernizr-2.6.2.min.js"></script>
    <script src="Shop/js/vendor/jquery-1.10.1.min.js"></script>
    <script>window.jQuery || document.write('<script src="Shop/js/vendor/jquery-1.10.1.min.js"><\/script>')</script>
    <script src="Shop/js/jquery.easing-1.3.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="Shop/js/bootstrap.js"></script>
    <script src="Shop/js/plugins.js"></script>
    <script src="Shop/js/main.js"></script>

</form>

</body>
</html>