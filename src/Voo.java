import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Voo {
    private final String nome;
    private final String horario;
    private List<Passageiro> lista;
    private final int listaMax = 10;
    private List<Passageiro> fila;
    private final int filaMax = 5;

    private static int passagemCounter = 0;

    private Passageiro[] poltronas;

    public Voo(String nome, String horario) {
        this.nome = nome;
        this.horario = horario;
        this.poltronas = new Passageiro[10];
        this.fila = new ArrayList<>();
        this.lista = new ArrayList<>();
        carregar();
    }

    public int gerarPassagem() {
        return passagemCounter++;
    }

    public String getNome() {
        return nome;
    }

    public void mostrarLista() {
        System.out.println(
                lista.stream().map(Passageiro::mostrar).collect(Collectors.joining("\n"))
        );
    }

    public void mostrarFila() {
        System.out.println(
                fila.stream().map(Passageiro::mostrar).collect(Collectors.joining("\n"))
        );
    }

    public Passageiro pesquisarCpf(String cpf) {
        return lista.stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public Passageiro pesquisarNome(String nome) {
        return lista.stream()
                .filter(p -> p.getNome().equals(nome))
                .findFirst()
                .orElse(null);
    }

    public boolean cadastrar(Passageiro passageiro) {
        if (lista.size() == listaMax) {
            if (fila.size() == filaMax) {
                System.out.println("Fila Cheia, a reserva não pode ser feita");
                return false;
            }
            passageiro.setPoltrona("Espera");

            fila.add(passageiro);
            return true;
        }

        for (int i=0; i<poltronas.length; i++) {
            if (poltronas[i] == null) {
                passageiro.setPoltrona(indexToPoltrona(i));
                poltronas[i] = passageiro;
                break;
            }
        }

        lista.add(passageiro);

        return true;
    }

    private String indexToPoltrona(int index) {
        if (index % 2 == 0) {
            return (index/2) + "A";
        } else {
            return (index/2) + "B";
        }
    }

    private int poltronaToIndex(String poltrona) {
        int i = 2 * Integer.parseInt(String.valueOf(poltrona.charAt(0)));
        if (poltrona.charAt(1) == 'A') {
            return i;
        } else {
            return i + 1;
        }
    }

    public void remover(Passageiro passageiro) {
        if (lista.remove(passageiro) && !fila.isEmpty()) {
            Passageiro passageiroFila = fila.remove(0);
            passageiroFila.setPoltrona(passageiro.getPoltrona());
            lista.add(passageiroFila);
            poltronas[poltronaToIndex(passageiro.getPoltrona())] = passageiroFila;
        }
    }

    public void salvar() {
        File file = new File(nome+".txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileWriter fw = new FileWriter(nome+".txt");
            BufferedWriter writer = new BufferedWriter(fw);
            List<String> arquivo = new ArrayList<>();
            arquivo.addAll(
                    lista.stream().map(Passageiro::toCSV).collect(Collectors.toList())
            );
            arquivo.addAll(
                    fila.stream().map(Passageiro::toCSV).collect(Collectors.toList())
            );

            writer.write(String.join("\n", arquivo));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getHorario() {
        return horario;
    }

    private static void setPassagemCounter(int n) {
        passagemCounter = n;
    }

    private void carregar() {
        File file = new File(nome+".txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileReader fr = new FileReader(nome+".txt");
            BufferedReader reader = new BufferedReader(fr);
            List<Passageiro> arquivo = reader.lines().map(Passageiro::new).collect(Collectors.toList());
            arquivo.stream()
                    .max(Comparator.comparing(Passageiro::getPassagem)).ifPresent(maior -> setPassagemCounter(maior.getPassagem() + 1));

            arquivo.forEach(p -> {
                        if (p.getPoltrona().equals("Espera")) {
                            fila.add(p);
                        } else {
                            lista.add(p);
                            poltronas[poltronaToIndex(p.getPoltrona())] = p;
                        }
                    });
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
