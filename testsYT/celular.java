package Java;

public class celular extends disp{
    String marca;
    String model;
    int year;
    celular(String marca, String model, int year){
        this.marca = marca;
        this.model = model;
        this.year = year;
    }
    void turnOn(){
        System.out.println("turning on your "+year+" "+marca+" "+model+".");
    }
}
