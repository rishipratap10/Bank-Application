package business;



/** *************************************
 * Class: CIST 2372 Java Programming II
 * Spring: 2018
 * Instructor: Ronald Enz
 * Date: 06/18/2018
 * Lab 
 *Login servlet
 * @author Levi Llewellyn *************************************
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import business.*;
/**
 *
 * @author Kiaito
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class loginservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id, pass, valid;
      // getting the data from the login page
        id = request.getParameter("id");
        pass = request.getParameter("pass");
        //print the  id and password in server log
        System.out.println(pass + id);
        
        //creating new customer object
        Customer c1 = new Customer();
        c1.selectDB(Integer.parseInt(id));
        String pwdb = c1.getcustPassword();
        //c1.display();

        //establish the session
        HttpSession ses1;
        ses1 = request.getSession();
        //setting the object in session
        ses1.setAttribute("c1", c1);
        //System.out.println("Customer added to Session/scheduling JStudentLookup.jsp");

        System.out.println(pass);
        System.out.println(pwdb);
        
           //testing the pwd againt database
        if ((pass.equals(pwdb))) {
            //forward to displaying list of accounts 
            RequestDispatcher rd = request.getRequestDispatcher("/displayAccounts.jsp");
             rd.forward(request, response);  

        } else {
            // forward to error page 
            RequestDispatcher rd = request.getRequestDispatcher("/errorpage.jsp");
             rd.forward(request, response); 
        }

        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
