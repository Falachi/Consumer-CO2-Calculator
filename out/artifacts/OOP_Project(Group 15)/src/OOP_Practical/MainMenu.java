package OOP_Practical;

import javax.swing.*;
import java.io.IOException;

public class MainMenu {

    public static void preMenu(userProfile user){
        ImageIcon icon3 = new ImageIcon("src/images/GP8.png");
        ImageIcon icon10 = new ImageIcon("src/images/GP0.png");

        JOptionPane.showMessageDialog(null,"Thank you " + user.getTitle() + "." + user.getName() + " for using our application \n We hope you will enjoy your journey with us",
                "Welcome to your new environmental journey", JOptionPane.INFORMATION_MESSAGE, icon10);

        JOptionPane.showMessageDialog(null, "And now, we would like to introduce you to your next step of saving the environment \n through analysing your plastic usage and what other alternatives you might use.",
                "Our World Needs Our Help", JOptionPane.INFORMATION_MESSAGE, icon3);
    }

    public static void quitMenu(){
        ImageIcon icon = new ImageIcon("src\\images\\goodbye.png");

        JOptionPane.showMessageDialog(null,
                "Thanks for using the app. See you.",
                "Goodbye",
                0,
                icon);
    }

    public static int firstMenu(userProfile user){
        String[] acceptableValues = {"Activities", "Forecasting", "Learn More", "Quit"};
        int a;

        String input = (String)JOptionPane.showInputDialog(null,
                "Hello " + user.getName() + ". Please pick one of the options.",
                "Main Page",
                1,
                null,
                acceptableValues,
                0);

        if(input == acceptableValues[0]){
            a = 0;
        }else if(input == acceptableValues[1]){
            a = 1;
        }else if(input == acceptableValues[2]){
            a = 2;
        }else{
            a = -1;
        }
    return a;
    }

    public static int activities(){
        ImageIcon icon = new ImageIcon("src/images/GP8.png");
        String[] option = {"back", "transportation", "material"};

        int a = JOptionPane.showOptionDialog(null,
                "Would you like to record transportation or materials emission?",
                "Activities",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                icon,
                option,
                0);

        if(a == 1){
            a = 4;
        }else if(a == 2){
            a = 5;
        }else{
            a = 100;
        }

        return a;
    }

    public static void learnMore(){
        int i = 0;
        do {
            String learnMore = LearnMore.information();

            switch (learnMore) {
                case "Global CO2 Issue":
                    i = LearnMore.GlobalCO2();
                    break;
                case "Industrial":
                    i = LearnMore.industrial();
                    break;
                case "Residential":
                    i = LearnMore.residential();
                    break;
                case "Transportation":
                    i = LearnMore.transportation();
                    break;
                case "Recyclables":
                    i = LearnMore.recyclables();
                    break;
                default:
                    i = 1;
                    break;
            }
        }while(i == 0);
    }

    public static void transportation() throws IOException {
        int i = 0;
        do{
            int save = Transportation.transportationEmission();
            int finalDecision;

            switch (save){
                case 0:
                    Transportation.writeData();
                    finalDecision = Transportation.finalDecision();
                    if(finalDecision == 1){
                        i = 1;
                    }
                    break;
                case 1:
                    finalDecision = Transportation.finalDecision();
                    if (finalDecision == 1){
                        i = 1;
                    }
                    break;
                default:
                    i = 1;
                    break;
            }
        }while(i == 0);
    }

    public static void material() throws IOException {
        int i = 0;
        do{
            int save = Material.materialEmission();
            int finalDecision;

            switch (save){
                case 0 -> {
                    Material.writeMaterialData();
                    finalDecision = Transportation.finalDecision();
                    if(finalDecision == 1){
                        i = 1;
                    }
                    break;
                }
                case 1 -> {
                    finalDecision = Transportation.finalDecision();
                    if (finalDecision == 1){
                        i = 1;
                    }
                    break;
                }
                default -> i = 1;
            }
        }while(i == 0);
    }

    public static int forecasting() throws IOException {


        double firstData = 0;
        double secondData = 0;
        double totalData;
        double finalData = 0.00;

        int[] returnedValue = {100, 2};
        int a = 0;

        for(int i = 0; i < 5; i++){
            if (i==0){
                i = Forecasting.ResultsAction();
                a = 0;
            }
            else if(i ==1){
                String forecastType = Forecasting.timeValue();
                if(forecastType == null){
                    forecastType = "njfdsf";
                    i = -1;
                }

                firstData = Forecasting.getActivities();
                secondData = Forecasting.getTransportation();
                totalData = Forecasting.add(firstData, secondData);

                switch (forecastType){
                    case "Weekly":
                        finalData = Forecasting.weekly(totalData);
                        break;
                    case "Monthly":
                        finalData = Forecasting.monthly(totalData);
                        break;
                    case "Yearly":
                        finalData = Forecasting.yearly(totalData);
                        break;
                    default:
                        i = -1;
                        break;
                }
            }
            else if(i == 2){
                i = Forecasting.FirstOption(finalData, firstData, secondData);
            }
            else if(i == 3){
                i = Forecasting.SecondOption();

            }
            else if(i == 4){
                a = Forecasting.ThirdOption();
                if(a==0){
                    i = 2;
                }
                if(a==1){
                    i = 10;
                    a = 2;
                }
                if(a==2){
                    a = 0;
                }
            }
        }
        return returnedValue[a];
    }
}
