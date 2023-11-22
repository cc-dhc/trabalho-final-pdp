import java.util.List;

public class Voo {
    private final String nome;
    private final String horario;
    private List<Passageiro> lista;
    private final int listaMax = 10;
    private List<Passageiro> fila;
    private final int filaMax = 5;

    public Voo(String nome, String horario) {
        this.nome = nome;
        this.horario = horario;
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
            if (fila.size() == filaMax) return false;

            fila.add(passageiro);
            return true;
        }

        lista.add(passageiro);

        return true;
    }

    public void remover(Passageiro passageiro) {
        if (lista.remove(passageiro) && !fila.isEmpty()) {
            Passageiro passageiroFila = fila.remove(0);
            passageiroFila.setPoltrona(passageiro.getPoltrona());
            lista.add(passageiroFila);
        }
    }

    public void salvar() {
        // todo
    }

    private void carregar() {
        // todo
    }
}
