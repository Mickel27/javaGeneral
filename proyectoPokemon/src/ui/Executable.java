package ui;

import java.util.Scanner;
import model.PokemonCard;

public class Executable {

    private static Scanner in;
    private static PokemonCard[] collection;
    private static int numero;
    public static void main(String[] args) {
        initializer();
        registerPokemon();
    }
    public static void initializer(){
        in = new Scanner(System.in);
        collection = new PokemonCard[185];
    }
    public static void registerPokemon() {
        System.out.println("Ingrese el nombre del bicho: ");
        String name = in.nextLine();
        System.out.println("Ingrese el tipo del bicho: ");
        String type = in.nextLine();
        System.out.println("Ingrese los puntos de vida(HP): ");
        int hp = in.nextInt();
        System.out.println("Ingrese los puntos de ataque (AP): ");
        int ap = in.nextInt();

        PokemonCard newPokemonCard = new PokemonCard(name, type, hp, ap);

        if (savePokemonCard(newPokemonCard)){
            System.out.println("Guardado con éxito!");
        }
        else{
            System.out.println("ERROR: memoria llena");
        }
        System.out.println(getPokemonCardList());
    }

    public static boolean savePokemonCard(PokemonCard newCard) {
        for (int i = 0; i < 184; i++) {
            if (collection[i] == null) {
                collection[i] = newCard;
                return true;
            }
        }
        return false;
    }

    public static String getPokemonCardList() {
        String lista = "";
        for (int i = 0; i < collection.length; i++) {
            if (collection[i]==null) {
                return lista;
            }
            else{
                lista+="POKEMON #"+(i+1)+"\nNombre: "+collection[i].getName()+"\n";
                lista+="Tipo: "+collection[i].getType()+"\n";
                lista+="HP: "+collection[i].getHealthPoints()+"\n";
                lista+="ATK: "+collection[i].getAttackPower()+"\n";
            }
        }
        return lista;
    }

}