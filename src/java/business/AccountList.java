package business;

/** *************************************
 * Class: CIST 2372 Java Programming II
 * Spring: 2018
 * Instructor: Ronald Enz
 * Date: 06/18/2018
 * Lab 
 *Account list class
 * @author Levi Llewellyn *************************************
 */
public class AccountList {

    //list of accounts array
    public int count = 0;
    public Accounts alist[] = new Accounts[10];

    //addaccount method
    public void addAccount(Accounts a1) {
        alist[count] = a1;
        count++;
    }
    //Display method
    public void display() {
        for (int x = 0; x < count; x++) {
            alist[x].display();
           
        }
    }
    //testing main
    public static void main(String[] args) {
        AccountList ra = new AccountList();
        ra.addAccount(new Accounts(876, "joe", "smole", 76598));
        ra.display();

    }
}
