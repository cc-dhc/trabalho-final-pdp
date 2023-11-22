import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Voo voo1 = new Voo("BH-RJ", "15:35");
        Voo voo2 = new Voo("BH-SP", "17:10");
        Voo voo3 = new Voo("BH-BRASÍLIA", "20:45");

        Voo currentVoo = null;

        do {
            Interface.menuVoo();
            int op = scanner.nextInt();

            switch (op) {
                case 1 -> currentVoo = voo1;
                case 2 -> currentVoo = voo2;
                case 3 -> currentVoo = voo3;
                default -> Interface.imprimirOpcaoInvalida();
            }
        } while(currentVoo == null);

        Interface.menuPrincipal(currentVoo);

    }
}