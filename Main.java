import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Voo voo1 = new Voo("BH-RIO", "15:35");
        Voo voo2 = new Voo("BH-SP", "17:10");
        Voo voo3 = new Voo("BH-BRASÍLIA", "20:45");

        Voo currentVoo = null;

        do {
            Interface.menuVoo();
            int op = scanner.nextInt();

            switch (op) {
                case 1: currentVoo = voo1; break;
                case 2: currentVoo = voo2; break;
                case 3: currentVoo = voo3; break;
                default: Interface.imprimirOpcaoInvalida();
            }
        } while(currentVoo == null);

        int opcao;

        do {
            Interface.menuPrincipal(currentVoo);
            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcao) {
                case 1: {
                    currentVoo.mostrarLista();
                } break;

                case 2:  {
                    System.out.println("Pesquisar por CPF:");
                    String cpf = scanner.nextLine();
                    Passageiro passageiro = currentVoo.pesquisarCpf(cpf);
                   if (passageiro == null) {
                       System.out.println("Passageiro não consta nesse voo");
                   } else {
                       passageiro.mostrar();
                   }
                } break;

                case 3: {
                    System.out.println("Pesquisar por Nome:");
                    String nome = scanner.nextLine();
                    Passageiro passageiro = currentVoo.pesquisarNome(nome);
                    if (passageiro == null) {
                        System.out.println("Passageiro não consta nesse voo");
                    } else {
                        passageiro.mostrar();
                    }
                } break;

                case 4: {
                    System.out.println("Cadastro de Passageiro");

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    if (currentVoo.pesquisarCpf(cpf) != null) {
                        System.out.println("Passageiro já cadastrado.");
                        Interface.espera();
                        scanner.nextLine();

                        break;
                    }

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();

                    Passageiro passageiro = new Passageiro(cpf, nome, endereco, telefone,
                            currentVoo.gerarPassagem(), "Espera", currentVoo.getNome(), currentVoo.getHorario());

                    if (currentVoo.cadastrar(passageiro)) {
                        System.out.println("Passageiro cadastrado com sucesso.");
                    }

                } break;
                case 5: {
                    System.out.println("Digite o cpf do passageiro a ser excluído:");
                    String cpf = scanner.nextLine();
                    Passageiro passageiro = currentVoo.pesquisarCpf(cpf);

                    if (passageiro != null) {
                        currentVoo.remover(passageiro);
                        System.out.println("Passageiro removido com sucesso.");
                    } else {
                        System.out.println("Passageiro não encontrado.");
                    }
                } break;
                case 6:{
                    currentVoo.mostrarFila();
                } break;
                case 0: {
                    voo1.salvar();
                    voo2.salvar();
                    voo3.salvar();
                } break;
                default: Interface.imprimirOpcaoInvalida();
            }
        } while(opcao != 0);
    }
}