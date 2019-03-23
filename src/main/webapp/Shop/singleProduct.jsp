<%@ page import="java.util.ArrayList, shop.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>

<html class="no-js">
<head>
    <meta charset="utf-8">
    <title>Product description</title>

    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet">

    <link rel="stylesheet" href="Shop/css/bootstrap.css">
    <link rel="stylesheet" href="Shop/css/normalize.min.css">
    <link rel="stylesheet" href="Shop/css/font-awesome.min.css">
    <link rel="stylesheet" href="Shop/css/animate.css">
    <link rel="stylesheet" href="Shop/css/templatemo-misc.css">
    <link rel="stylesheet" href="Shop/css/templatemo-style.css">

    <script src="Shop/js/vendor/modernizr-2.6.2.min.js"></script>

</head>
<body>
    <!--[if lt IE 7]>
    <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
    <![endif]-->

    
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
                            <h1><a href="#">Guitar ¯\_(ツ)_/¯ Store</a></h1>
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
        <div class="main-nav">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-sm-7">
                        <div class="list-menu">
                            <ul>
                                <li><a href="products?category=Electric guitar">Electric</a></li>
                                <li><a href="products?category=Acoustic guitar">Acoustic</a></li>
                                <li><a href="products?category=Bass guitar">Bass</a></li>
                            </ul>
                        </div> <!-- /.list-menu -->
                    </div> <!-- /.col-md-6 -->
                    <div class="col-md-6 col-sm-5">
                        <div class="notification">
							<a href="productsCart?show=true">
							<img src="Shop/images/products/cart.png" alt="" width=45px height=45px>
							<span>Items in cart:</span>
							<c:choose>
								<c:when test="${not empty sessionScope['cart']}">
									<span id="cartAmount">${sessionScope['cart'].getTotal()}</span>
								</c:when>
								<c:otherwise>
									<span id="cartAmount">0</span>
								</c:otherwise>
							</c:choose>	
							</a>
                        </div>
                    </div> <!-- /.col-md-6 -->
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </div> <!-- /.main-nav -->
    </header> <!-- /.site-header -->

    <div class="content-section">
        <div class="container">
            <div class="row">
			<c:if test="${not empty requestScope['product']}" > 
                <div class="col-md-4">
                    <div class="product-image">
                        <img src="Shop/images/products/${requestScope['product'].id}.jpg" alt="">
                    </div> <!-- /.product-image -->
				</div>	
				<div class="col-md-8">	
                    <div class="product-information">
						<br/>
                        <h2>${requestScope['product'].name}</h2>
                        <p>${requestScope['product'].description}</p>
                        <p class="product-infos">
                            <span>Price: ${requestScope['product'].price} UAH</span>
                        </p>
                        <ul class="product-buttons">
                            <li>
								<img src="Shop/images/products/plus.png" onclick="plus(${requestScope['product'].id})"  width=25 height=25>
								<input type="text" name="amount" value="1" id="amount${requestScope['product'].id}" style="height:40px; width:50px"/>
								<img src="Shop/images/products/minus.png" onclick="minus(${requestScope['product'].id})"  width=25 height=25>
								<input type="submit" class="s-button" onclick="ajax(${requestScope['product'].id})" id="but" value="Buy">
                            </li>
                        </ul>
                    </div> <!-- /.product-information -->
                </div> <!-- /.col-md-8 -->
			</c:if>	
            </div> <!-- /.row -->
        </div> <!-- /.container -->
    </div> <!-- /.content-section -->

    <footer class="site-footer">
        <div class="main-footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <div class="footer-widget">
                            <h3 class="widget-title">About Us</h3>
                            Guitar store is a Ecommerce project made while studying at ITEA Java Web course.
                            <ul class="follow-us">
                                <li><a href="#"><i class="fa fa-facebook"></i>Facebook</a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i>Twitter</a></li>
                            </ul> <!-- /.follow-us -->
                        </div> <!-- /.footer-widget -->
                    </div> <!-- /.col-md-3 -->
                    <div class="col-md-3">
                        <div class="footer-widget">
                            <h3 class="widget-title">Why Choose Us?</h3>
                            Kool Store is free responsive eCommerce template provided by templatemo website. You can use this layout for any website.
                            <br><br>Tempore cum mollitia eveniet laboriosam corporis voluptas earum voluptate. Lorem ipsum dolor sit amet.
                            <br><br>Credit goes to <a rel="nofollow" href="http://unsplash.com">Unsplash</a> for all images.
                        </div> <!-- /.footer-widget -->
                    </div> <!-- /.col-md-3 -->
                    <div class="col-md-2">
                        <div class="footer-widget">
                            <h3 class="widget-title">Useful Links</h3>
                            <ul>
                                <li><a href="#">Our Shop</a></li>
                                <li><a href="#">Partners</a></li>
                                <li><a href="#">Gift Cards</a></li>
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Help</a></li>
                            </ul>
                        </div> <!-- /.footer-widget -->
                    </div> <!-- /.col-md-2 -->
                    <div class="col-md-4">
                        <div class="footer-widget">
                            <h3 class="widget-title">Our Newsletter</h3>
                            <div class="newsletter">
                                <form action="#" method="get">
                                    <p>Sign up for our regular updates to know when new products are released.</p>
                                    <input type="text" title="Email" name="email" placeholder="Your Email Here">
                                    <input type="submit" class="s-button" value="Submit" name="Submit">
                                </form>
                            </div> <!-- /.newsletter -->
                        </div> <!-- /.footer-widget -->
                    </div> <!-- /.col-md-4 -->
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </div> <!-- /.main-footer -->
        <div class="bottom-footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <span>Copyright &copy; 2084 <a href="#">Company Name</a></span>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium, expedita soluta mollitia accusamus ut architecto maiores cum fugiat. Pariatur ipsum officiis fuga deleniti alias quia nostrum veritatis enim doloremque eligendi?</p>
                    </div> <!-- /.col-md-12 -->
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </div> <!-- /.bottom-footer -->
    </footer> <!-- /.site-footer -->

    
    <script src="Shop/js/vendor/jquery-1.10.1.min.js"></script>
    <script>window.jQuery || document.write('<script src="Shop/js/vendor/jquery-1.10.1.min.js"><\/script>')</script>
    <script src="Shop/js/jquery.easing-1.3.js"></script>
    <script src="Shop/js/bootstrap.js"></script>
    <script src="Shop/js/plugins.js"></script>
    <script src="Shop/js/main.js"></script>
	
			<script>
	
		function plus(id){
			var num = document.getElementById("amount"+id).value;
			num++;
			var res = document.getElementById("amount"+id);
			res.value = num;
		}
		
		function minus(id){
			var num = document.getElementById("amount"+id).value;
			num--;
			var res = document.getElementById("amount"+id);
			if(res.value>1){
				res.value = num;
			} 
		}
		
		function buy(id){
			var amount = document.getElementById("amount"+id).value;
			//alert("ID: "+id+" Amount: "+amount);
		}
		
		function ajax(id){
			$.ajax({
			  url: "http://localhost:8080/MyShopSpring/productsCart",
			  type:"POST",
			  data: {
				zipcode: 97201,
				buy: id,
				amount: document.getElementById("amount"+id).value
			  },
			  success: function( result ) {
				var amount = document.getElementById("cartAmount");
				var number = +document.getElementById("amount"+id).value;
				var newAmount = +amount.innerHTML;
				newAmount += number;
				amount.innerHTML = +newAmount;
			  }
			});	
		}
	
	</script>


</body>
</html>