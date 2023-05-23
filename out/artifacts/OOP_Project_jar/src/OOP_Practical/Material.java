package OOP_Practical;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Random;

public class Material {

    private static double carbonDioxide;

    public static int materialEmission() throws IOException {
        String[] options = new String[]{"Continue"};
        ImageIcon icon1 = new ImageIcon("src/images/GP8.png");
        String trivia = getTrivia();

        int firstOption = JOptionPane.showOptionDialog(
                null,
                "Did you know?\n" + trivia,
                ".",
                JOptionPane.YES_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                icon1,
                options,
                0);

        switch (firstOption) {
            case 0: //if user chose Transportation
                carbonDioxide = materialTypeData();
                break;
            case 1: //if user chose materials
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
                    "Your total carbon dioxide emission is " + carbonDioxide + "g.\n Would you like to save your data?",
                    "Summary",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    summaryList,
                    0);
        }
        return save;
    }

    static String getTrivia(){
        String trivia = "Head Empty";
        Random random = new Random();
        int trivialRoulette = random.nextInt(0, 4);

        switch (trivialRoulette){
            case 1:
                trivia = "Approximately 100,000 sea turtles and other marine animals die every year\nbecause they either mistake the bags for food or get strangled in them";
                break;
            case 2:
                trivia = "Half of all plastic produced is designed to be used only once. The world produced about 380 million metric tons of plastic in 2015.\nAbout 55% of that plastic waste was discarded, 25% incinerated and 20% recycled,\nmeaning the majority of the bottles visualised above would likely end up in the environment,\nlandfill sites, or oceans around the world.";
                break;
            case 3:
                trivia = "Globally, 65 billion gloves are used every month. The tally for face masks is nearly twice that—129 billion a month.\nThat translates into 3 million face masks used per minute.";
                break;
            case 4:
                trivia = "Fun fact: aluminium is the most recyclable material!\nAluminium cans can be recycled and be back on the shelf in as little as 6 weeks\nbut takes around 250 years to decompose.";
                break;
            case 5:
                trivia = "The study says tobacco's total annual carbon footprint is 84 million tonnes,\n which is almost as high as the greenhouse gas emissions of Peru, and more than twice that of Wales.\n Tobacco production also requires intensive use of natural resources\nand uses chemicals that pollute ecosystems and harm the health of local people.";
                break;
        }
        return trivia;
    }

    public static double materialTypeData(){

        String[] ItemList = new String[]{"Plastic bags","Plastic bottles","Face masks","Cans","Cigarettes"};
        String PlasticItem;
        ImageIcon icon3 = new ImageIcon("src/images/GP8.png");
        double ItemNumber = 0;

        PlasticItem = (String)JOptionPane.showInputDialog(
                null,
                "Plastic item you would like to measure its carbon footprint",
                "Plastic Items List",
                1,
                icon3,
                ItemList,
                0);
        ItemNumber = Double.parseDouble(JOptionPane.showInputDialog(
                null,
                "Please enter your daily usage",
                "items used",
                1));

        double co2 = calculateCarbon(PlasticItem, ItemNumber);

        return co2;
    }

    private static final DecimalFormat decimalRounding = new DecimalFormat("#.##");

    private static double calculateCarbon(String PlasticItem, double quantity) {
        double carbonDioxide = 0;
        decimalRounding.setRoundingMode(RoundingMode.DOWN);

        switch (PlasticItem) {
            case "Plastic bags":
                carbonDioxide = quantity * 1.58;
                break;
            case "Plastic bottles":
                carbonDioxide = quantity * 56;
                break;
            case "Face masks":
                carbonDioxide = quantity * 32.7;
                break;
            case "Cans":
                carbonDioxide = quantity * 77.1;
                break;
            case "Cigarettes":
                carbonDioxide = quantity * 1.22;
                break;
        }
        return Double.parseDouble(decimalRounding.format(carbonDioxide));
    }

    public static void writeMaterialData() throws IOException {
        LocalDate currentDate = LocalDate.now();
        File databaseSaved = new File("material_data\\" + String.valueOf(currentDate) + ".txt");

        try (FileWriter writeFile = new FileWriter("material_data\\" + String.valueOf(currentDate) +".txt", true)) {
            writeFile.write(String.valueOf(carbonDioxide)+"\n");
        }
    }
}
