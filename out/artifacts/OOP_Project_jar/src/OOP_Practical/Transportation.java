package OOP_Practical;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Random;

public class Transportation {

    private static double carbonDioxide;

    public static int transportationEmission() throws IOException {
        String[] options = new String[]{"Continue", "Back"};
        ImageIcon firstChoiceImage = new ImageIcon("globe.png");
        String trivia = getTrivia();

        int firstOption = JOptionPane.showOptionDialog(
                null,
                "Did you know?\n" + trivia,
                "Record Carbon Dioxide Emission",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                firstChoiceImage,
                options,
                0);

        switch (firstOption) {
            case 0: //if user chose Transportation
                carbonDioxide = transportationTypeData();
                break;
            case 1: //if user chose back
                break;
            default: //just in case
                JOptionPane.showMessageDialog(
                        null,
                        "You didn't select anything.",
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
                break;
        }

        String[] summaryList = new String[]{"save", "do not save"};

        int save = -1;
        if (firstOption == 0) {
            save = JOptionPane.showOptionDialog(
                    null,
                    "Your carbon dioxide emission is " + carbonDioxide + "kg. \n\nPublic transportation produces far fewer quantities of air pollutants, like carbon monoxide,\ncarbon dioxide, and nitrogen oxides, per passenger mile. If the destination is close you can\nopt for biking or walking. Not only you're saving the environment but also getting healthy!\n\nWould you like to save your data?",
                    "Summary",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    summaryList,
                    0);
        }
        return save;
    }

    public static int finalDecision(){
        String[] Options = {"Input Another", "Back to Menu"};

        int finalDecision = JOptionPane.showOptionDialog(
                null,
                "Would you like to input another data?",
                null,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                Options,
                0);

        return finalDecision;
    }

    private static final DecimalFormat decimalRounding = new DecimalFormat("#.##");

    static double calculateCarbon(String vehicleType, double distance){
        double carbonDioxide = 0;
        decimalRounding.setRoundingMode(RoundingMode.DOWN);

        switch(vehicleType){
            case "Motorcycle":
                carbonDioxide = distance * 100.9;
                break;
            case "Sedan":
                carbonDioxide = distance * 120.4;
                break;
            case "SUV":
                carbonDioxide = distance * 149.5;
                break;
            case "Lorry":
                carbonDioxide = distance * 180.5;
                break;
            case "Pickup Truck":
                carbonDioxide = distance * 170.3;
                break;
        }
        carbonDioxide = carbonDioxide / 1000;

        return Double.parseDouble(decimalRounding.format(carbonDioxide));
    }

    public static String getTrivia() {
        String trivia = "Head Empty";
        Random random = new Random();
        int trivialRoulette = random.nextInt(0, 4);

        switch (trivialRoulette) {
            case 0:
                trivia = "More than a third of food produced globally never makes it to the table. \n Some of this wasted food spoils in transit, while consumers throw some of this food out. \n Food loss and waste account for around 8.2 percent of the total human-made greenhouse gas emissions.";
                break;
            case 1:
                trivia = "Greenhouse gases may be a result of natural occurrence or human activity. These gases include carbon dioxide (CO2), methane (CH4), water vapor, nitrous oxide (N2O) and ozone (O3). \n Fluorinated gases are also considered to be greenhouse gases. Greenhouse gases act like a heat-trapping blanket, making the Earth habitable for humans. \n However, human activities have increased emissions of greenhouse gases into the atmosphere beyond what the Earth can support, resulting in climate change.";
                break;
            case 2:
                trivia = "The Earth receives solar radiation from the sun. Passing through the atmosphere, some radiation is absorbed by the Earth, \nwhile some is reflected back to space. When the exchange of incoming and outgoing radiation occurs, some of the radiation\nbecomes trapped by gases in the atmosphere. This creates a “greenhouse” effect and warms the planet.";
                break;
            case 3:
                trivia = "The majority of scientists agree that many of these effects are caused by human contribution to the greenhouse effect. \nExtreme weather events, droughts, heat waves and rising sea levels are already having \ndevastating effects on the most vulnerable countries and communities.";
                break;
            default:
                trivia = "You missed an extra.";
        }
        return trivia;
    }

    public static double transportationTypeData(){

        String[] vehicleList = new String[]{"Motorcycle", "Sedan", "SUV", "Lorry", "Pickup Truck"};
        String vehicleType;
        ImageIcon carImage = new ImageIcon("car.png");
        double distanceMeter = 0;

        vehicleType = (String)JOptionPane.showInputDialog(
                null,
                "Please pick the type of vehicle used.",
                "Type of Vehicle",
                1,
                carImage,
                vehicleList,
                0);
        distanceMeter = Double.parseDouble(JOptionPane.showInputDialog(
                null,
                "Please insert the distance travelled in kilometers. You may use decimal.",
                "Distance Taken",
                1));

        double co2 = calculateCarbon(vehicleType, distanceMeter);

        return co2;
    }
    public static void writeData() throws IOException {
        LocalDate currentDate = LocalDate.now();
        File databaseSaved = new File("transportation_data\\" + String.valueOf(currentDate) + ".txt");

        FileWriter writeFile = new FileWriter("transportation_data\\" + String.valueOf(currentDate) + ".txt", true);

        writeFile.write(String.valueOf(Transportation.carbonDioxide) + "\n");
        writeFile.close();
    }
}
