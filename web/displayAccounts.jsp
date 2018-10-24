<%@page import="business.Accounts"%>
<%@page import="business.Customer"%>
package business;
/** *************************************
* Class: CIST 2372 Java Programming II
* Spring: 2018
* Instructor: Ronald Enz
* Date: 06/18/2018
* Lab 
*Login servlet
* @author Levi Llewellyn ***************
*/

<%-- 
    Document   : login
    Created on : Jun 11, 2018, 5:03:07 PM
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

                      <% Customer c1;
                        c1 = (Customer) session.getAttribute("c1");
                        Accounts a1;
                        a1 = (Accounts) session.getAttribute("a1");
                    %>

                    <h2> Hello <%= c1.getcustFirstName() + " " + c1.getcustLastName()%> </h2>
                    <h4> Here is a list of all your accounts</h4>
                    

                        <%for (int i = 0; i < c1.alists.count; i++) {
         
                                out.println("<h1>Account #: " + c1.alists.alist[i].getActNo() +   "  Type:   " + c1.alists.alist[i].gettype() + "  Balance:    "
                                        + c1.alists.alist[i].getBalance()+"</h1>");
                                

                        %><br><%  }%>



                    

                </div>

                <nav>
                    <div class="nav">
                        <ul>
                            <li>
                                <a href="index.jsp">Return to the Home Page</a>
                            </li>
                            <li>
                    <a href="acctlookup.jsp">Account Lookup</a>
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