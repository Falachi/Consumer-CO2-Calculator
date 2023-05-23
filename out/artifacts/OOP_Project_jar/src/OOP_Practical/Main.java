package OOP_Practical;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int status = 0;
        userProfile user = new userProfile();

        //User Loop for Login and Register
        do {
            int loginRegister = userLogIn.userType();

            switch (loginRegister){
                case 0:
                    status = userLogIn.loginUser(user);
                    break;
                case 1:
                    userLogIn.userSignUp();
                    status = userLogIn.loginUser(user);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Error. Please try again.");
                    status = 1;
            }

        }while(status == 0);

        if(status == 1){
            mainLoop(user);
            MainMenu.quitMenu();
        }
    }

    public static void mainLoop(userProfile user) throws IOException {
        int status = 0;

        MainMenu.preMenu(user);

        do {
            int choice = MainMenu.firstMenu(user);

            for(int i = choice; i < 100;){

                switch (i){
                    case 0:
                        //Activities
                        i = MainMenu.activities();
                        break;
                    case 1:
                        //Forecasting
                        JOptionPane.showMessageDialog(null,
                                "Not yet added");
                        i = 100;
                        break;
                    case 2:
                        //Learn More
                        MainMenu.learnMore();
                        i = 100;
                        break;
                    case 3:
                        //Quit
                        i = 100;
                        status = 1;
                        break;
                    case 4:
                        //transportation
                        MainMenu.transportation();
                        i = 100;
                        break;
                    case 5:
                        MainMenu.material();
                        i = 100;
                        break;
                    default:
                        i = 100;
                        status = 1;
                        break;
                }
            }
        }while(status == 0);
    }
}
