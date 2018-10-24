package business;


/** *************************************
 * Class: CIST 2372 Java Programming II
 * Spring: 2018
 * Instructor: Ronald Enz
 * Date: 06/18/2018
 * Lab 
 *Account class
 * @author Levi Llewellyn *************************************
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Accounts {
    //variables
    int acctNo;
    String cid;
    String type;
    double balance;

    public Accounts() {
      //blank constructor
    }

    public Accounts(int actNo, String cidd, String typpe, double lance) {
        acctNo = actNo;

        acctNo = actNo;
        cid = cidd;
        type = typpe;
        balance = lance;

    }
     //getters and setters
    public void setActNo(int act) {
        acctNo = act;
    }

    public int getActNo() {
        return acctNo;
    }

    public void setcid(String cidd) {
        cid = cidd;
    }

    public String getcid() {
        return cid;
    }

    public void settype(String typpe) {
        type = typpe;
    }

    public String gettype() {
        return type;
    }

    public void setBalance(double lance) {
        balance = lance;
    }

    public double getBalance() {
        return balance;
    }
    //display method
    /*
    Displaying the information   
    */
    public void display() {
        System.out.println("Your account number is: " + acctNo);
        System.out.println("Your account user Id is: " + cid);
        System.out.println("Your account type is: " + type);
        System.out.println("Your account balance is: " + balance);
        System.out.println("-------------------------------------");
    }
    //select database method
    public void selectDB(int actNo) {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/ChattBankMDB.mdb");
            Statement stmt = con.createStatement();

            String sql = "select * from Accounts WHERE AcctNo = " + actNo;
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                acctNo = rs.getInt(1);
                cid = rs.getString(2);
                type = rs.getString(3);
                balance = rs.getDouble(4);

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //deposit method
    public void deposit(double dep) {
        getBalance();
        balance += dep;
        
        //database connection
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/ChattBankMDB.mdb");

            String sql = "UPDATE Accounts set Balance = " + balance + " WHERE AcctNo = " + getActNo();
            //System.out.println(sql);
            Statement stmt;
            stmt = con.createStatement();
            stmt.execute(sql);
            System.out.println(sql);

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
      //withdrawl method 
    public void withdrawl(double with) {
        getBalance();
         balance += with;
        
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"
                    + "/Users/Kiaito/Downloads/ChattBankMDB.mdb");

            String sql = "UPDATE Accounts set Balance = " + balance + " WHERE AcctNo = " + getActNo();
            //System.out.println(sql);
            Statement stmt;
            stmt = con.createStatement();
            stmt.execute(sql);
            System.out.println(sql);

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        Accounts c1 = new Accounts();
        c1.selectDB(90000);
        //String pw = c1.getcustPassword();
        //c1.display();
        //c1.deposit(1);
        //c1.withdrawl(8);
        //c1.selectDB(90000);
        c1.display();
    }

}
