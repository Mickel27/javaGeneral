package ui;
import java.util.Scanner;
import java.util.Random;
public class Battleship1D {
    private static Scanner in;
    private static int[] jugador, computador, iniciosBarcosBot, iniciosBarcosJugador;
    public static void main(String[] args) {
        in = new Scanner(System.in);
        do{
            computador = new int[10];
            iniciosBarcosBot = new int[3];
            iniciosBarcosJugador = new int[3];
            jugador = new int[10];
            barcosBot();
            mostrarTableros(computador);
            colocarBarcos();
            in.nextLine();
            while (true) {
                System.out.println("TABLERO ENEMIGO");
                mostrarTableros(computador);
                System.out.println("Introduce tu tiro");
                in.reset();
                turno();
                if (!noHayGanador()) {
                    break;
                }
                turnoBot();
                if (!noHayGanador()) {
                    break;
                }
                System.out.println("TU TABLERO");
                mostrarTableros(jugador);
            }
        }while(jugarDeNuevo());
    }
    public static boolean revisarSolapamiento(int intento, int longitud) {
        
        if (computador[intento] == 1 ||  computador[intento+longitud-1] == 1) {
            return true;
        }
        if (intento+longitud>=9) {
            if (computador[intento+longitud] == 1) {
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    public static void barcosBot() {
        for (int i = 1; i <= 3; i++) { // Se corrige para evitar el barco de tamaño 0
            Random random = new Random();
            int casillaElegida = random.nextInt(10-i);

            //System.out.println("INTENTO CASILLA: " + (casillaElegida+1)); // debug

            while (revisarSolapamiento(casillaElegida, i)) {
                casillaElegida = random.nextInt(10-i);
                //System.out.println("INTENTO CASILLA: " + (casillaElegida+1)); // debug
            }
            for (int j = 0; j < i; j++) {
                computador[casillaElegida + j] = 1;
            }
            iniciosBarcosBot[i-1] = casillaElegida;
            
            //System.out.println("Barco de " + i + " casilla/s colocado en posicion " + (iniciosBarcosBot[i-1]));
            //System.out.println(iniciosBarcosBot[i-1]);
            //mostrarTableros(computador);
        }
        for (int i = 0; i < computador.length; i++) {
            if (computador[i] == 0) {
                computador[i] = 4;
            }
        }
    }
    public static void colocarBarcos() {
        System.out.println("Coloca tus barcos (de 1 a 3 casillas: Lancha, medico y de municion)");
        for (int i = 1; i < 4; i++){
            for (int j = 0; j < 10; j++) {
                System.out.print(jugador[j] + "|");
            }
            System.out.println();
            System.out.println("Barco de " + i + " casilla/s");
            System.out.println("Introduce la casilla inicial");
            int casillaElegida = in.nextInt();
            casillaElegida-=1;
            while (casillaElegida < 0 || casillaElegida+i > 10) {
                System.out.println("Introduce una casilla válida");
                casillaElegida = in.nextInt();
                casillaElegida-=1;
            }
            for (int j = 0; j < i; j++) {
                if (jugador[casillaElegida+j] == 1) {
                    System.out.println("Otro barco ya ocupa este lugar. Introduce una casilla válida");
                    casillaElegida = in.nextInt();
                    casillaElegida-=1;
                }
            }
            for (int j = 0; j < i; j++) {
                jugador[casillaElegida+j] = 1;
            }
            iniciosBarcosJugador[i-1] = casillaElegida;
        }
    }
    public static void mostrarTableros(int[] lista) {
        System.out.println("-------casillas-------");
        System.out.println("|1|2|3|4|5|6|7|8|9|10|");
        System.out.print("|");
        for (int i = 0; i < 10; i++) {
            if (lista == computador && (lista[i] == 4 || lista[i] == 1)) {
                System.out.print("?|");
            }
            else if (lista == jugador && lista[i] == 4) {
                System.out.print("0|");
            }
            else{
                System.out.print(lista[i] + "|");
            }
        }
        System.out.println("\n");
    }
    public static void turnoBot() {
        Random random = new Random();
        int intentoBot = random.nextInt(10);
        while (jugador[intentoBot] == 2 || jugador[intentoBot] == 3 || jugador[intentoBot] == 4) {
            intentoBot = random.nextInt(10);
        }
        System.out.println("El rival ha lanzado a la posicion " + (intentoBot+1) + "...");
        if (jugador[intentoBot] == 1) {
            jugador[intentoBot] = 2;
            System.out.println("Le ha atinado!");
        }
        else{
            System.out.println("Ha fallado!");
            jugador[intentoBot] = 4;
        }
        revisarHundido(jugador, iniciosBarcosJugador);
    }
    public static void turno() {
        int intento = in.nextInt();
        while (intento> 10 || intento <= 0) {
            System.out.println("Error: ingresa una casilla valida.");
            intento = in.nextInt();
        }
        intento-=1;
        while (computador[intento] == 3 || computador[intento] == 2) {
            System.out.println("Ya disparaste a este barco!");
            intento = in.nextInt();
        }
        if (computador[intento] == 1) {
            System.out.println("Tocado");
            computador[intento] = 2;
        }
        else{
            System.out.println("Agua");
            computador[intento] = 0;
        }
        revisarHundido(computador, iniciosBarcosBot);
    }
    public static void revisarHundido(int[] tablero, int[]inicios) {
        for (int i = 0; i < 3; i++) {
            int inicioBarcoABuscar = inicios[i];
            boolean hundido = true;
            for (int j = 0; j <= i; j++) {
                if (tablero[inicioBarcoABuscar + j] != 2) {
                    hundido = false;
                    break;
                }
            }
            if (hundido) {
                for (int j = 0; j <=i; j++) {
                    tablero[inicioBarcoABuscar + j] = 3;
                }
            }    
        }
    }
    public static boolean noHayGanador() {
        boolean ganaUsuario = true;
        for (int i = 0; i < 10; i++) {
            if (computador[i] == 1) {
                ganaUsuario = false;
            }
        }
        if (ganaUsuario) {
            System.out.println("Has ganado!");
            System.out.println("TABLERO ENEMIGO");
            mostrarTableros(computador);
            System.out.println("TU TABLERO");
            mostrarTableros(jugador);
            return false;
        }
        boolean ganaBot = true;
        for (int i = 0; i < 10; i++) {
            if (jugador[i] == 1) {
                ganaBot = false;
            }
        }
        if (ganaBot) {
            System.out.println("Has perdido!");
            System.out.println("TABLERO ENEMIGO");
            mostrarTableros(computador);
            System.out.println("TU TABLERO");
            mostrarTableros(jugador);
            return false;
        }
        return true;
    }
    public static boolean jugarDeNuevo() {
        in.nextLine();
        System.out.println("Desea jugar otra vez? S/N");
        String jugarOtraVez = in.nextLine();
        jugarOtraVez.toLowerCase();
        while (!jugarOtraVez.matches("s") && !jugarOtraVez.matches("n")) {
            System.out.println("Inserte una respuesta valida S/N");
            jugarOtraVez = in.nextLine();

        }
        if (jugarOtraVez.matches("n")) {
            return false;
        }
        return true;
    }
}