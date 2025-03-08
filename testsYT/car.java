package Java;

public class car extends tricks{

    String model;
    int year;
    double price;

    car(String model, int year, double price){
        this.model = model;
        this.year = year;
        this.price = price;
    }
    public String toString(){
        return model+"\n"+year+"\n"+price;
    }
    void drift() {
        System.out.println("drift!");
    }
    void speed(){
        System.out.println("You go 150 in a 60!"); 
    }
}