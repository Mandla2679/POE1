/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registration_.redo;
import javax.swing.*;

/**
 *
 * @author RC_Student_lab
 */
public class Registration_Redo {

    /**
     * @param args the command line arguments
     */
       public static class Part1 {
        public String Username;
        public String Password;
        public String cellphone;

        // Method to check username
        public void CheckUserName() {
            boolean Underscore = Username.contains("_");
            if (Underscore && Username.length() <= 5) {
                JOptionPane.showMessageDialog(null, "Username successfully captured");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Username is incorrectly formatted.\n" +
                        "Please ensure your username contains an underscore\n" +
                        "and is no more than five characters in length.");
            }
        }

        // Creating the check password method
        public void CheckPasswordComplexity() {
            boolean Capital = Password.matches(".*[A-Z].*"); // Fixed: check for at least one capital letter
            boolean Special = Password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*"); // Fixed regex
            boolean containdigit = Password.matches(".*\\d.*"); // Fixed regex to check for any digit

            if (Capital && Special && containdigit && Password.length() >= 8) {
                JOptionPane.showMessageDialog(null, "Password successfully captured");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Password is not correctly formatted;\n" +
                        "please ensure that the password contains at least eight\n" +
                        "characters, a capital letter, a number, and a special character.");
            }
        }

        // Creating the check phone number method
        public void CheckPhonenumber() {
            if (cellphone != null && cellphone.startsWith("+27") && cellphone.length() == 12 && cellphone.matches("\\+27\\d{9}")) {
                JOptionPane.showMessageDialog(null, "Cell phone number successfully added.");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Cell phone number incorrectly formatted or does not contain international code.");
            }
        }

        // Method to register user
        public void RegisterUser() {
            Username = JOptionPane.showInputDialog("Enter user name");
            CheckUserName();//calling method

            Password = JOptionPane.showInputDialog("Enter user password");
            CheckPasswordComplexity();//calling method

            cellphone = JOptionPane.showInputDialog("Enter user cellphone number with +27");
            CheckPhonenumber();//calling method
        }

        // Inner static class for Login functionality
        public static class Login {

            // Login method to check if credentials match
            public static boolean loginUser(String correctUsername, String correctPassword) {
                String enteredUsername = JOptionPane.showInputDialog("Enter username to login:");
                String enteredPassword = JOptionPane.showInputDialog("Enter password to login:");
                return enteredUsername.equals(correctUsername) && enteredPassword.equals(correctPassword);
            }

            // Returns login status message
            public static String returnLoginStatus(boolean isLoggedIn, String firstName, String lastName) {
                if (isLoggedIn) {
                    return "Welcome " + firstName + ", " + lastName + ", it is great to see you again.";
                } else {
                    return "Username or password incorrect, please try again.";
                }
            }

            // Method to run the login flow
            public static void loginFlow(String correctUsername, String correctPassword, String firstName, String lastName) {
                boolean isLoggedIn = loginUser(correctUsername, correctPassword);
                String message = returnLoginStatus(isLoggedIn, firstName, lastName);
                JOptionPane.showMessageDialog(null, message);
            }
        }
    }

    public static void main(String[] args) {
        Part1 usersign_in = new Part1();
        usersign_in.RegisterUser();

        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");

        // Call static login method from the Login class
        Part1.Login.loginFlow(usersign_in.Username, usersign_in.Password, firstName, lastName);
    }
}

