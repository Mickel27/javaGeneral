package Java;
import java.util.Random;
public class Garage {
    car [] userGarage = new car[3];
    bike [] userBikeGarage = new bike[3];
    void register (car userCar) {
        int random = new Random().nextInt(10);
        if (random == 0) {
            System.out.println("Oh no, your personal driver crashed! your "+userCar.year+" "+userCar.model+" was totaled :(");
        }
        else if (userGarage[2] != null) {
            System.out.println("your garage is full! The car will be gifted to the next customer. you lost $" + userCar.price);
        }
        else {
            System.out.println("Your "+userCar.year+" "+userCar.model+" has arrived your garage.");
            for (int i = 0; i < userGarage.length; i++) {
                if (userGarage[i] == null) {
                    userGarage[i] = userCar;
                    break;
                }
            }
            if (userGarage[2] != null) {
                System.out.println("your garage is full! The car will be gifted to the next customer. you lost $" + userCar.price);
            }
        }
    }
    void registerBike (bike userBike) {
        int random = new Random().nextInt(10);
        if (random == 0) {
            System.out.println("Oh no, your personal driver crashed! your "+userBike.year+" "+userBike.model+" was totaled :(");
        }
        else if (userGarage[2] != null) {
            System.out.println("your garage is full! The car will be gifted to the next customer. you lost $" + userBike.price);
        }
        else {
            System.out.println("Your "+userBike.year+" "+userBike.model+" has arrived your garage.");
            for (int i = 0; i < userGarage.length; i++) {
                if (userBikeGarage[i] == null) {
                    userBikeGarage[i] = userBike;
                    break;
                }
            }
            if (userBikeGarage[2] != null) {
                System.out.println("your garage is full! The car will be gifted to the next customer. you lost $" + userBike.price);
            }
        }
    }
    void showGarage() {
        System.out.println("CAR GARAGE:");
        for (int i = 0; i < userGarage.length; i++) {
            if (userGarage[i] != null) {
                System.out.println("["+(i+1)+"]: "+userGarage[i]);
            }
        }
        System.out.println("BIKE GARAGE:");
        for (int i = 0; i < userBikeGarage.length; i++) {
            if (userBikeGarage[i] != null) {
                System.out.println("["+(i+1)+"]: "+userBikeGarage[i]);
            }
        }
    }
}