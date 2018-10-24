/** *************************************
 * Class: CIST 2372 Java Programming II
 * Spring: 2018
 * Instructor: Ronald Enz
 * Date: 06/27/2018
 * errorpage
 *lab6
 * @author Levi Llewellyn ****************
 */
<%-- 
    Document   : login
    Created on : Jun 11, 2018, 5:03:07 PM
    Author     : Kiaito
--%>

<%@page import="business.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!Doctype html>
<html lang="en-us">
<head>
	<link rel="stylesheet" type="text/css" href="mycs.css">
	<meta charset="UTF-8">
    <meta name="description" content="Web development prtfolio website">
    <meta name="keywords" content="webdesign, website development, programmer">
    <meta name="author" content="Levi llewellyn">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Log In Page</title>
    
</head>
<div class="wrapper">
<header> 
    <img src="head.jpeg">
    
	</header>
<body>
<main>
        
    <div id="main">
    <h1> Please use the form below to log into your account</h1>
</div>
<div class="form">
    <form method="Post" action="myselet">
       Username:
       <input type="text" placeholder="Customer Id" name="id">
       <br><br>
       Password:
       <input type="password" placeholder="Password" name="pass">
       <br><br>
       <input type="submit" value="Sign IN" class="but">
       <br><br>
       <input type="forgot" value="forgot" class="butt">
        <input type="reset" value="Reset" class="butt">
       
       <br><br>
   </form>
    <h1> Error try again </h1>
    <% Customer c1; c1 = (Customer)session.getAttribute("c1");%>
    <p> <h3>Could not login with user id <%=c1.getcustId() %></h3></p>
   </div>
<nav>
        <div class="nav">
            <ul>
                <li>
                    <a href="index.jsp">Home</a>
                </li>
                <li>
                        <a href="acctlookup.jsp">Accounts</a>
                </li>
                <li>
                    <a href="#">Home Loans</a>
                </li>
                <li>
                    <a href="#">Auto Loans</a>
                </li>
            </ul>
        </div>
    </nav>
</main>   
</div>
		<footer>Copyright &copy;2016 Levi Llewellyn 
			<a href="mailto:levi@yourmon.com">
				<br>levi.llewellyniskng@gmail.com
			</a>
        </footer>
        </body>
	</div>
</html>
