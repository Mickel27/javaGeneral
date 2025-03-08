package Java;
import java.util.Scanner;

public class Vehicles {
    static void CreateCar(Scanner scan, Garage garage) {
        
        System.out.println("Enter car model: ");
        String model = scan.nextLine();

        System.out.println("Enter car year: ");
        int year = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter car price: ");
        double price = scan.nextDouble();
        scan.nextLine();
        car userCar = new car(model, year, price);
        
        System.out.println("you created a " + userCar.year + " " + userCar.model + " worth $" + userCar.price+ ".");
        System.out.println("Go take it for a spin!");
        while (true) {
            System.out.println("Choose the number for the trick you want to perform (0 to stop):");
            System.out.println("1: wheelie");
            System.out.println("2: front wheelie");
            System.out.println("3: rev");
            System.out.println("4: speed");
            System.out.println("5: drift");
            int choice = scan.nextInt();
            scan.nextLine();
            if (choice == 1) {
                userCar.wheelie();
            }
            else if (choice == 2) {
                userCar.frontWheelie();
            }
            else if (choice == 3) {
                userCar.rev();
            }
            else if (choice == 4) {
                userCar.speed();
            }
            else if (choice == 5) {
                userCar.drift();
            }
            else if (choice == 0) {
                System.out.println("exiting...");
                break;
            }
            else {
                System.out.println("didnt understand cuh");
            }
        }
        garage.register(userCar);
    }
    static void CreateBike(Scanner scan, Garage garage) {
        
        System.out.println("Enter bike model: ");
        String model = scan.nextLine();

        System.out.println("Enter bike year: ");
        int year = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter bike price: ");
        double price = scan.nextDouble();
        scan.nextLine();
        bike userBike = new bike(model, year, price);
        
        System.out.println("you created a " + userBike.year + " " + userBike.model + " worth $" + userBike.price+ ".");
        System.out.println("Go take it for a spin!");
        while (true) {
            System.out.println("Choose the number for the trick you want to perform (0 to stop):");
            System.out.println("1: wheelie");
            System.out.println("2: front wheelie");
            System.out.println("3: rev");
            System.out.println("4: speed");
            System.out.println("5: drift");
            int choice = scan.nextInt();
            scan.nextLine();
            if (choice == 1) {
                userBike.wheelie();
            }
            else if (choice == 2) {
                userBike.frontWheelie();
            }
            else if (choice == 3) {
                userBike.rev();
            }
            else if (choice == 4) {
                userBike.speed();
            }
            else if (choice == 5) {
                userBike.drift();
            }
            else if (choice == 0) {
                System.out.println("exiting...");
                break;
            }
            else {
                System.out.println("didnt understand cuh");
            }
        }
        garage.registerBike(userBike);
    }

    public static void main(String[] args) {
        Garage garage = new Garage();
        Scanner scan = new Scanner(System.in);
        boolean Buying = true;
        System.out.println("welcome to my car shop. Create a car.");
        while (Buying) {
            while (true) {
                System.out.println("Would you like to create a car or a bike? (c/b)");
                String type = scan.nextLine();
                if (type.toLowerCase().equals("b")) {
                    CreateBike(scan, garage);
                    break;
                }
                else if (type.toLowerCase().equals("c")) {
                    CreateCar(scan, garage);
                    break;
                }
                else {
                    System.out.println("didnt understand cuh");
                }
            }
            
            System.out.println("would you like to create another vehicle? (y/n)");
            String answer = scan.nextLine();
            if (answer.toLowerCase().equals("n")) {
                Buying = false;
            }
        }
        scan.close();
        System.out.println("\nYou created the following vehicles:");
        garage.showGarage();
    }  
}