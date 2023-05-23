package OOP_Practical;

import javax.swing.*;

public class Login_Signup {

    public static String name;

    public static void signup(){
        name = JOptionPane.showInputDialog(
                null,
                "Welcome. Please insert your name.",
                null,
                1);
    }
}
