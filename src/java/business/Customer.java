package business;


/** *************************************
 * Class: CIST 2372 Java Programming II
 * Spring: 2018
 * Instructor: Ronald Enz
 * Date: 06/18/2018
 * Lab 3
 *Customer class
 * @author Levi Llewellyn *************************************
 */
import java.sql.*;

public class Customer {

    private int custId;
    private String custPassword;
    private String custFirstName;
    private String custLastName;
    private String custAddress;
    private String custEmail;
   public AccountList alists = new AccountList();

    public Customer() {
        custId = 0;
        custPassword = "";
        custFirstName = "";
        custLastName = "";
        custAddress = "";
        custEmail = "";

    }
   // contructor that take all argument 
    public Customer(int Id, String password, String firstname, String lastname, String address, String email) {

        custId = Id;
        custPassword = password;
        custFirstName = firstname;
        custLastName = lastname;
        custAddress = address;
        custEmail = email;
    }
//Getters and Setters
    public void setcustId(int id) {
        custId = id;
    }

    public int getcustId() {
        return custId;
    }

    public void setcustPassword(String pw) {
        custPassword = pw;
    }

    public String getcustPassword() {
        return custPassword;
    }

    public void setcustFirstName(String fn) {
        custFirstName = fn;
    }

    public String getcustFirstName() {
        return custFirstName;
    }

    public void setcustLastName(String ln) {
        custLastName = ln;
    }

    public String getcustLastName() {
        return custLastName;
    }

    public void setcustAddress(String add) {
        custLastName = add;
    }

    public String getcustAddress() {
        return custAddress;
    }

    public void setcustEmail(String el) {
        custEmail = el;
    }

    public String getcustEmail() {
        return custEmail;
    }
          //display method
    public void display() {
        System.out.println("Your Customer Id is: " + custId);
        System.out.println("Your password is: " + custPassword);
        System.out.println("Your firstname is: " + custFirstName);
        System.out.println("Your lasttname is: " + custLastName);
        System.out.println("Your address is: " + custAddress);
        System.out.println("Your email is: " + custEmail);
        //tSystem.out.println("your account"+ alist);
        alists.display();
    }
   //Selecting from the database
    public void selectDB(int Id) {
        try {
            //database connection
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/ChattBankMDB.mdb");
            Statement stmt = con.createStatement();

            String sql = "select * from Customers WHERE CustID = " + Id;
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //getting results 
                custId = rs.getInt(1);
                custPassword = rs.getString(2);
                custFirstName = rs.getString(3);
                custLastName = rs.getString(4);
                custAddress = rs.getString(5);
                custEmail = rs.getString(6);
                getAccount();
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
     
    //insets method
    
          //delete method 
    public void deleteDB() {

        try { //database connection
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/ChattBankMDB.mdb");

            String sql = "Delete * from Customers WHERE id = " + custId;
            //System.out.println(sql);

            Statement stmt = con.createStatement();
            int n = stmt.executeUpdate(sql);

            if (n == 1) {
                System.out.println("DataDeleted");
            } else {
                System.out.println("Error Deleting.....");
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    //main method to test
    public static void main(String[] args) {

        Customer c1 = new Customer();
        c1.selectDB(3001);
        
        c1.display();

    }
    
    
         //get account 
    public void getAccount(){
    
try {       Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/ChattBankMDB.mdb");
            Statement stmt = con.createStatement();

            String sql = "select AcctNo from Accounts where Cid= " + getcustId();
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            Accounts a1;
             int acctNo;       
            while (rs.next()) {
             acctNo = rs.getInt(1);
             a1 = new Accounts();
             a1.selectDB(acctNo);
             alists.addAccount(a1);
             //a1.display();            
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
