import java.util.Scanner;

public class test {
    private static Scanner in;
    public static void main(String[] args) {
        in = new Scanner(System.in);
        System.out.println("Ingresa tu nombre");
        String name = in.nextLine();
        System.out.println("Vos sos una cacorra " + name);
    }
}