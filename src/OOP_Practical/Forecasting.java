package OOP_Practical;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class Forecasting {

    private static LocalDate date = LocalDate.now();

    private static int a;
    //getter method for Activities
    public static double getActivities() throws IOException {

        double a = 0;

        File readFile = new File("material_data\\" + date + ".txt");
        if(readFile.createNewFile()){
            a = 0;
            readFile.delete();
        }else{
            Scanner read = new Scanner(readFile);
            while(read.hasNextLine()){
                String data = read.nextLine();
                double b = Double.parseDouble(data);
                a += b;
            }
            read.close();
            a /= 1000;
        }

        return a;
    }

    //getter method for Transportation page
    public static double getTransportation() throws IOException {
        double a = 0;

        File readFile = new File("transportation_data\\" + date + ".txt");
        if(readFile.createNewFile()){
            a = 0;
            readFile.delete();
        }else{
            Scanner read = new Scanner(readFile);
            while(read.hasNextLine()){
                String data = read.nextLine();
                double b = Double.parseDouble(data);
                a += b;
            }
            read.close();
        }

        return a;
    }

    public static double add(double data1, double data2){
        data1 += data2;
        return data1;
    }
    public static double weekly(double data){
        data *= 7;
        return data;
    }

    public static double monthly(double data){
        data *= 30;
        return data;
    }

    public static double yearly(double data){
        data *= 365;
        return data;
    }

    public static int ResultsAction(){

        String[] option = {"Back", "Next"};
        int a = JOptionPane.showOptionDialog(null,
                "In this page, you will be able to see a whole overview of your results that you have input under the \"Activities\" page." + "\n" +
                        "You will also be able to see a daily global average result.",
                "Results Page",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                option,
                0);

        if(a == 1){
            a = 0;
        }else if( a == 0){
            a = 5;
        }

        return a;
    }

    public static String timeValue(){
        String[] timeValues = {"Weekly", "Monthly", "Yearly", "Back"};
        String timeInput = (String)JOptionPane.showInputDialog(null,
                "Please select your preferred forecast of weekly, monthly, or yearly.",
                "Forecasting",
                1,  //changed this
                null,
                timeValues,
                timeValues[0]);

        return timeInput;
    }

    private static final DecimalFormat decimalRounding = new DecimalFormat("#.##");

    public static int FirstOption(double data, double data1, double data2){
        JFrame frame = new JFrame();
        String[] options1 = new String[2];
        options1[0] = "Back";
        options1[1] = "Next";

        data = Double.parseDouble(decimalRounding.format(data));
        data1 = Double.parseDouble(decimalRounding.format(data1));
        data2 = Double.parseDouble(decimalRounding.format(data2));

        a = JOptionPane.showOptionDialog(frame.getContentPane(), "Your results overview are: " + "\n• Material: " + data1 + "kg" + "\n• Transportation: " + data2 + "kg" + "\n• Total: " +data + "kg", "Results Page", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options1, 0);

        if (a == 1){
            a = 2;
        }

        return a;
    }

    public static int SecondOption(){
        ImageIcon globalTrendImage = new ImageIcon("global_trend.png");
        JLabel iconLabel = new JLabel(globalTrendImage);
        JPanel iconPanel = new JPanel(new GridBagLayout());
        iconPanel.add(iconLabel);

        JPanel textPanel = new JPanel(new GridLayout(0,1));
        textPanel.add(new JLabel ("The global average results today is 417.35ppm. Below is a line graph of daily carbon dioxide emissions over 10 years: "));


        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(textPanel);
        mainPanel.add(iconPanel, BorderLayout.SOUTH);
        JFrame frame = new JFrame();

        String[] options2 = new String[2];
        options2[0] = "Previous";
        options2[1] = "Next";
        a = JOptionPane.showOptionDialog(frame.getContentPane(), mainPanel, "Results Page", 0, JOptionPane.INFORMATION_MESSAGE, null, options2, 0);

        switch (a){
            case 0:
                a++;
                break;
            case 1:
                a = 3;
        }


        return a;
    }

    public static int ThirdOption(int articleNumber, String[] article){
        JFrame frame = new JFrame();
        String[] options3 = new String[3];
        options3[0] = "Previous";
        options3[1] = "Go to Articles";
        options3[2] = "Back to Main";

        a = JOptionPane.showOptionDialog(frame.getContentPane(), "Here are some suggestions of articles for you to read about the environment: " + article[articleNumber], "Results Page", 0, JOptionPane.INFORMATION_MESSAGE, null, options3, 0);

        return a;
    }
}
