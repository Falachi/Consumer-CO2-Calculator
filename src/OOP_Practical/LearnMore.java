package OOP_Practical;

import javax.swing.*;

public class LearnMore {

    private static String[] finalOption = {"Back", "Back to Main Menu"};
    private static int a;

    public static String information(){
        String[] optionList = {"Global CO2 Issue", "Industrial", "Residential", "Transportation", "Recyclables"};
        ImageIcon image = new ImageIcon("src\\images\\LearnMoreicon.png");

        String firstOption = (String)JOptionPane.showInputDialog(
                null,
                "Click on the subject you wish to learn more of.",
                "Learn More",
                1,
                image,
                optionList,
                0);
        if(firstOption == null){
            firstOption = "lidjsalsjdsad";
        }

        return firstOption;
    }

    public static int finalDecision(){
        String[] Options = {"Back", "Back to Main Menu"};

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

    public static int GlobalCO2(){
        ImageIcon image = new ImageIcon("src\\images\\globe.png");
        String info = "About 43.1 billion tons of CO2 were emitted to the atmosphere from human activities in 2019. The amount is so huge that it can form a giant cube measuring 30km on each side.\n" +
                "Despite legistrations from countries all over the globe, CO2 emissions has not gone down since 1800s. In 2018, it grew faster than any other time. Currently, global temperature\n" +
                "will raise by 3.7 degree Celcius by 2100. Getting that number down to below 3 degree Celsius is now impossible, according to University of Tasmania." +
                "\n\nCopyright © 2022 TheWorldCounts";
        String info2 = "The extreme CO2 emissions are mostly from burning fossil fuels. Just 2018:\n" +
                "• Coal: 14.7 billion tons\n" +
                "• Oil: 12.4 billion tons\n" +
                "• Gas: 7.5 billion tons\n" +
                "Deforestation and climate change also contribute indirectly to the increase of CO2. Deforestation leads to less CO2 absorbed by the tree, as well as emitting through\n" +
                "usage of industrial vehicles, tools, and burning of forest. Deforestation accounts for 10-15% of the global CO2 emission." +
                "\n\nCopyright © 2022 TheWorldCounts";

        JOptionPane.showMessageDialog(
                null,
                info,
                "Global CO2 Issue",
                0,
                image);
        a = JOptionPane.showOptionDialog(
                null,
                info2,
                "Global CO2 Issue",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                image,
                finalOption,
                0);
        return a;
    }

    public static int industrial(){
        ImageIcon image = new ImageIcon("src\\images\\industry.jpg");
        String info = "The industrial revolution brought impact on the economic and social organization,\n" +
                "and introduced commodities made in big quantities. However, it has expelled copious amounts\n" +
                "of carbon dioxide into the atmosphere, triggering an unnatural amount of global temperture increase.\n" +
                "Since 1880, it has increased to 14.4 degree Celcius as of 2015, 50 times faster than the rate of warming\n" +
                "during the previous 21,000 years.\n\n" +
                "The world is now completely dependent and rapidly depleting the plant's fossil fuels. In 1750, there were\n" +
                "280 ppm of carbon dioxide in the atmosphere, but by 2005, the levels of carbon dioxide had risen to 380 ppm,\n" +
                "an increase of over one-third. Besides an increase in global temperature, they contribute a lot of pollutions\n" +
                "on the air, soil, water and wildlife.";

        a = JOptionPane.showOptionDialog(
                null,
                info,
                "Industrial",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                image,
                finalOption,
                0);
        return a;
    }

    public static int residential(){
        ImageIcon image = new ImageIcon("src\\images\\residential.jpg");
        String info = "Climate-related disasters were the leading cause of internal displacement over the last decade, displacing\n" +
                "an estimated 20 million people per year. Those who are homeless or do not have access to robust or safe housing\n" +
                "are disproportionately affected, as they frequently reside in locations prone to floods, hurricanes and cyclones,\n" +
                "storm surges, mudslides, earthquakes, and tsunamis. Furthermore, when states implement disaster risk management\n" +
                "measures, they frequently overlook the impact on vulnerable people and their right to shelter.\n\n" +
                "The manner in which the right to housing is to be implemented has climate change consequences. The building and\n" +
                "construction sector is projected to account for 39% of global energy-related carbon dioxide emissions, the\n" +
                "majority of which is emitted in the United States.\n\n" +
                "The Special Rapporteur emphasises in the report that indigenous peoples contributed the least to the climate\n" +
                "problem yet are the most affected by it. They are now on the front lines of every tragedy, from Arctic glacier\n" +
                "melting to Amazon deforestation to rising sea levels engulfing islands in Oceania. She stated that when taking\n" +
                "action to combat climate change, States Parties must respect, promote, and recognise the rights of indigenous peoples.\n" +
                "However, in the Special Rapporteur's experience, indigenous peoples' human rights, particularly their rights to\n" +
                "self-determination and to live in dignity and security, are rarely taken into account in the implementation of the\n" +
                "Paris Agreement.\n\n" +
                "© OHCHR 1996-2022";

        a = JOptionPane.showOptionDialog(
                null,
                info,
                "Residential",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                image,
                finalOption,
                0);
        return a;
    }

    public static int transportation(){
        ImageIcon image = new ImageIcon("src\\images\\transportation.png");
        String info = "The combustion of fossil fuels such as gasoline and diesel emits carbon dioxide, a greenhouse gas, into the atmosphere.\n" +
                "Carbon dioxide (CO2) and other greenhouse gases such as methane (CH4), nitrous oxide (N2O), and hydrofluorocarbons (HFCs) are\n" +
                "driving the Earth's atmosphere to warm, resulting in climate changes that we can already experience.\n\n" +
                "Transportation-related greenhouse gas (GHG) emissions account for around 27% of total U.S. GHG emissions, making it the greatest\n" +
                "source of GHG emissions. GHG emissions in the transportation industry increased more than any other sector in absolute terms\n" +
                "between 1990 and 2020.\n\n" +
                "Automobiles aren't the only polluters; aeroplanes, ships, and trains contribute significantly to global greenhouse gas emissions.\n" +
                "\n" +
                "Aircraft are the third-largest source of greenhouse gas pollution in the US transportation sector, accounting for roughly 9% of\n" +
                "total transportation emissions. Domestic aviation emissions are also increasing at an alarming rate, up 17% since 1990.\n" +
                "\n" +
                "Ships are a major source of nitrous oxide and black carbon, in addition to emitting over 3% of the world's CO2 (soot). With increased\n" +
                "international trade predicted in the next years, emissions from ships and boats might rise by up to 250 percent by 2050. In certain\n" +
                "countries, however, completely electric freight and passenger ferries are already in use.";

        a = JOptionPane.showOptionDialog(
                null,
                info,
                "Transportation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                image,
                finalOption,
                0);
        return a;
    }

    public static int recyclables(){
        ImageIcon image = new ImageIcon("src\\images\\recyclables.png");
        String info = "Reducing garbage, recycling, and composting are all good ways to reduce greenhouse gas emissions like carbon dioxide and methane.\n" +
                "It can accomplish these goals in two ways:\n" +
                "• by helping save energy in the processing of materials for industrial and consumer use.\n" +
                "• by reducing the flow of materials (especially food and other organic wastes) into landfills where anaerobic decomposition produces methane.\n\n" +
                "Large amounts of energy are required every time a new product is manufactured from raw ingredients. We can consider the function of energy\n" +
                "in four stages of product development: the extraction of raw materials, the production of these resources into products, consumer use of the\n" +
                "products, and product disposal. Recycling saves energy in most circumstances, resulting in fewer fossil fuels consumed and fewer greenhouse\n" +
                "gas emissions that contribute to climate change.\n\n" +
                "Metal recycling is a particularly effective technique to save energy. Aluminum cans made from recycled aluminium scraps, for example, consume\n" +
                "95 percent less energy than cans made from bauxite ore, the raw material used to generate aluminium. Another example is steel: recycled steel\n" +
                "uses 75 percent less energy than steel made from iron ore as a raw material.";

        a = JOptionPane.showOptionDialog(
                null,
                info,
                "Recyclables",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                image,
                finalOption,
                0);
        return a;
    }
}
