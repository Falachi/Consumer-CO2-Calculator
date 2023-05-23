package OOP_Practical;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class userLogIn {

    private static String name;
    private static int age;
    private static String title;
    private static String gender;
    private static String occupation;

    public static int userType(){
        String[] option = {"Login", "Register"};
        int a = JOptionPane.showOptionDialog(
                null,
                "Welcome. Please login or register to continue.",
                "Login",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                option,
                0);
        return a;
    }

    public static void userSignUp() throws IOException {

        String[] options = new String[]{"Continue"};
        ImageIcon icon1 = new ImageIcon("src/images/GP8.png");

        ImageIcon icon10 = new ImageIcon("src/images/GP0.png");
        JOptionPane.showMessageDialog(null, "Please provide us with some information regarding yourself, as this will enchance your personal experience.",
                "Informative Box", JOptionPane.INFORMATION_MESSAGE, icon10);

        String[] acceptableValues = {"Mr", "Ms","Mrs","Dr"};
        title = (String)JOptionPane.showInputDialog(null,
                "How shall we address you:",
                "Personal Info",
                1,
                null,
                acceptableValues,
                acceptableValues[1]);

        name = JOptionPane.showInputDialog("Enter Your Name:");

        String age1 = (String)JOptionPane.showInputDialog(null,
                "How old are you?",
                "Personal Info",
                3,
                null,
                null,
                "Enter your age.");
        age = Integer.parseInt(age1);

        String[] acceptableValues1 = {"Male", "Female","I would rather not to say"};
        gender = (String)JOptionPane.showInputDialog(null,
                "What is your Gender?",
                "Personal Info",
                1,
                null,
                acceptableValues1,
                acceptableValues[1]);

        String[] acceptableValues2 = {"Worker", "Student", "Business Person", "Retired", "Else"};
        occupation = (String)JOptionPane.showInputDialog(null,
                "What is your occupation?",
                "Personal Info",
                3,
                null,
                acceptableValues2,
                acceptableValues[1]);

        File makeFile = new File("user\\" + name + ".txt");

        if(makeFile.createNewFile()){
            FileWriter writeFile = new FileWriter("user\\" + name + ".txt", true);
            writeFile.write(title + "\n" + name + "\n" + age + "\n" + gender + "\n" + occupation);
            writeFile.close();
        }else{
            String secondOption[] = {"No", "Yes"};
            int overwrite = JOptionPane.showOptionDialog(null,
                    "Error. User already exist. Would you like to overwrite existing user?",
                    null,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null,
                    secondOption,
                    0);
            if(overwrite == 1){
                FileWriter writeFile = new FileWriter("user\\" + name + ".txt");
                writeFile.write(title + "\n" + name + "\n" + age + "\n" + gender + "\n" + occupation);
                writeFile.close();
            }
        }
    }

    public static int loginUser(userProfile userData) throws IOException {

        int status = 0;

        String username = JOptionPane.showInputDialog(
                null,
                "Insert username:",
                null,
                1);

        File testUser = new File("user\\" + username + ".txt");

        if(testUser.createNewFile()){
            JOptionPane.showMessageDialog(null,
                    "Error. User does not found. Please try again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            testUser.delete();
        }else{

            Scanner read = new Scanner(testUser);

            for(int i = 0; i < 5; i++){
                String data = read.nextLine();

                switch (i){
                    case 0:
                        userData.setTitle(data);
                        break;
                    case 1:
                        userData.setName(data);
                        break;
                    case 2:
                        int userAge = Integer.parseInt(data);
                        userData.setAge(userAge);
                        break;
                    case 3:
                        userData.setGender(data);
                        break;
                    case 4:
                        userData.setOccupation(data);
                        break;
                }
            }
            read.close();
            status = 1;
        }
    return status;
    }
}
