public class Interface {
    public static void menuVoo() {
        String menu = "[1] BH-RIO\n" +
                "[2] BH-SP\n" +
                "[3] BH-BRASÍLIA";
        imprimirTitulo();
        System.out.println("\t\t\tMENU DE VOO");
        System.out.println(menu);
        System.out.print("Digite sua opção: ");
    }

    public static void menuPrincipal(Voo voo) {
        // todo
    }

    private static void imprimirTitulo() {
        System.out.println("EMPRESA AÉREA QUEDA LIVRE");
    }

    public static void imprimirOpcaoInvalida() {
        System.out.println("OPÇÃO INVÁLIDA");
    }
}
