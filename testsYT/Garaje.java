package Java;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Garaje {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        ArrayList<ArrayList<String>> userGarage = new ArrayList<ArrayList<String>>();
        ArrayList<String> userGarage1 = new ArrayList<String>();
        ArrayList<String> userGarage2 = new ArrayList<String>();
        ArrayList<String> userGarage3 = new ArrayList<String>();

        String [][] carsColors = {
            {"Red Ferrari", "Blue Ferrari", "Black Ferrari"},
            {"Red Bugatti", "Blue Bugatti", "Black Bugatti"},
            {"Red Nissan", "Blue Nissan", "Black Nissan"}
        };

        System.out.println("Welcome to Myckie's Car Shop!");
        int carModel = 0;
        int carColor = 0;

        System.out.println("Pick a car! these are the availible references:");

        for (int i = 0; i < carsColors.length; i++) {
            System.out.println();
            for (int j = 0; j < carsColors[i].length; j++) {
                System.out.printf("%20s ", carsColors[i][j]);
            }
        }
        System.out.println();
        while (true) {
            System.out.println();
            if (userGarage3.size() == 3) {
                System.out.println("Your garage is full!");
                System.out.println();
                break;
            }
            while (true) {
                System.out.println("Models: Ferrari [0], Bugatti [1], and Nissan [2]");
                System.out.println();
                carModel = scan.nextInt();
                scan.nextLine();

                if (carModel < 0 || carModel > 2) {
                    System.out.println("Invalid input. Please try again.");
                }
                else {
                break;
                }
            }
            System.out.println();
            while (true) {
                System.out.println("Colors: Red [0], Blue [1], and Black [2]");
                System.out.println();
                carColor = scan.nextInt();
                scan.nextLine();

                if (carColor < 0 || carColor > 2) {
                    System.out.println("Invalid input. Please try again.");
                
                }
                else {
                break;   
                }
            }
            System.out.println("Thank you for choosing " + carsColors[carModel][carColor] + "!");

            if (userGarage1.size() == 3) {
                if (userGarage2.size() == 3) {
                    userGarage3.add(carsColors[carModel][carColor]);
                }
                else {
                    userGarage2.add(carsColors[carModel][carColor]);    
                }
            }
            else {
                userGarage1.add(carsColors[carModel][carColor]);
            }
            System.out.println();
            System.out.println("Would you like to choose another car? (Y/N)");
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("N")) {
                break;
            }
        }

        userGarage.add(userGarage1);
        userGarage.add(userGarage2);
        userGarage.add(userGarage3);

        scan.close();

        System.out.println();
        System.out.println("Here are the cars in your garage:");
        System.out.println();
        for (int i = 0; i < userGarage.size(); i++) {
            System.out.println("FLOOR " + (i+1) + ":");
            System.out.println();
            for (int j = 0; j < userGarage.get(i).size(); j++) {
                int Hp = random.nextInt(1000)+ 1000;
                System.out.printf("a %s, nice![HP: %d]", userGarage.get(i).get(j), Hp);
                System.out.println();
            }
            System.out.println();
        }
    }
}
