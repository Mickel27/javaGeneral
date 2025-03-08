package Java;

public class bike extends tricks{
    String model;
    int year;
    double price;

    bike(String model, int year, double price){
        this.model = model;
        this.year = year;
        this.price = price;
    }
    public String toString(){
        return model+"\n"+year+"\n"+price;
    }
    void wheelie() {
        System.out.println("wheelie!");
    }
    void frontWheelie() {
        System.out.println("front wheelie!");
    }
}