import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String companySuffix ="chacompany.com";
    private int mailboxCapacity =500;
    private int defaultPasswordLength =10;
    private String alternativeEmail;

    // constructor to receive the first and last name
    public Email (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName=lastName;

        // Call a method asking got the department - return the department
        this.department = setDepartment();

        // Call a methode that returns a random password
        this.password=randomPassword(defaultPasswordLength);
        System.out.println("Your password is : " + this.password);

        // Combine elements to generate email
       email=firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("New worker : " + firstName+ "\nDEPARTMENT CODE\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "development";
        } else if (depChoice == 3) {
            return "accounting";
        } else {
            return "";
        }
    }

    // Generate a random password

    private String randomPassword (int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#&!?$%";
        char[] password = new char[length];
        for (int i=0; i<length;i++){
          int rand= (int) (Math.random() * passwordSet.length());
          password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    // Set the alternative email

    public void setAlternativeEmail(String alternativeEmail) {
        this.alternativeEmail = alternativeEmail;
    }

    // Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: "+firstName+" "+ lastName+" "+
                "\nCOMPANY EMAIL: " + email +" "+
                "\nMAILBOX CAPACITY: "+ mailboxCapacity + " mb";
    }
}
