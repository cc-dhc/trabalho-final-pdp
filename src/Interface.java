public class Interface {
    public static void menuVoo() {
        String menu = "[1] BH-RIO\n" +
                "[2] BH-SP\n" +
                "[3] BH-BRASÍLIA";
        imprimirTitulo();
        System.out.println("\n\t\tMENU DE VOO\n");
        System.out.println(menu);
        System.out.print("\nDigite sua opção: ");
    }

    public static void menuPrincipal(Voo voo) {
        String menu = "[1] Mostrar Lista de Passageiros\n" +
                      "[2] Pesquisar Passageiro por CPF\n" +
                      "[3] Pesquisar Passageiro por Nome\n" +
                      "[4] Cadastrar Passageiro\n" +
                      "[5] Remover Passageiro\n" +
                      "[6] Mostrar Lista de Espera\n" +
                      "[0] Salvar e sair\n";

        imprimirTitulo();
        System.out.print(" - " + voo.getNome());
        System.out.println("\n\t\tMENU DE OPCOES\n");
        System.out.println(menu);
        System.out.print("Digite sua opção: ");
    }

    private static void imprimirTitulo() {
        System.out.print("\nEMPRESA AÉREA QUEDA LIVRE");
    }

    public static void imprimirOpcaoInvalida() {
        System.out.println("OPÇÃO INVÁLIDA");
    }

    public static void espera() {
        System.out.println("Digite <Enter> para continuar...");
    }
}
