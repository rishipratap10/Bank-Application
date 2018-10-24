
/** *************************************
 * Class: CIST 2372 Java Programming II
 * Spring: 2018
 * Instructor: Ronald Enz
 * Date: 06/18/2018
 * Account lookup class
 *
 * @author Levi Llewellyn ****************
 */
<%-- 
    Document   : acctlookup
    Created on : Jun 11, 2018, 5:11:03 PM
    Author     : Kiaito
--%>

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
           

        </header>
        <body>
            <main>
 <img src="bagmoney.jpg">
                <div id="main">
                    <h2> Fill in the fields below to look up account information</h2>
                </div>
                <div class="form">
                    <form action="AccountLookup" method="Post">

                        Account Number:
                        <input type="text" placeholder="Account number" name="acctnumber">
                        <br><br>
                        Customer Id:
                        <input type="text" placeholder="Id number" name="customerID">
                        <br><br>
                        Account Type:
                        <input type="text" placeholder="Account Type" name="acctType">
                        <br><br>
                        Balance:
                        <input type="text" placeholder="Balance" name="Balance">
                        <br><br>
                        <button type="submit" value="Submit" name="Submit" class="butt">Submit</button>
                        <button type="reset" value="reset" name="reset" class="butt">Clear</button>
                        <br><br>

                    </form>
                </div>


                <nav>
                    <div class="nav">
                        <ul>
                            <li>
                                <a href="index.jsp">Return to Home Page </a>
                            </li>
                            <li>
                                <a href="login.jsp"> LogIn </a>
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
