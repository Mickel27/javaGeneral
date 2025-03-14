package model;

public class PokemonCard {
    private String name;
    private String type;
    private int healthPoints;
    private int attackPower;

    public  PokemonCard(String name, String type, int healthPoints, int attackPower){
        this.name = name;
        this.type = type;
        this.healthPoints = healthPoints;
        this.attackPower = attackPower;
    }

    // Modificadores set

    public void setName(String name){
        this.name = name;
    }
    public void setType(String type){
        this.type = type;
    }

    public void setHealthPoints(int healthPoints){
        this.healthPoints = healthPoints;
    }

    public void setAttackPower(int attackPower){
        this.attackPower = attackPower;
    }

    //Analizadores get

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }
    public int getHealthPoints(){
        return healthPoints;
    }
    public int getAttackPower(){
        return attackPower;
    }
}