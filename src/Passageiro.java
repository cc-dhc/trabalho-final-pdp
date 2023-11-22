import java.time.LocalDateTime;

public class Passageiro {
    private String cpf;
    private String nome;
    private final String endereco;
    private final String telefone;
    private final int passagem;
    private String poltrona;
    private final Voo voo;
    private final String horario;

    public Passageiro(String cpf, String nome, String endereco, String telefone,
                      int passagem, String poltrona, Voo voo, String horario) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.passagem = passagem;
        this.poltrona = poltrona;
        this.voo = voo;
        this.horario = horario;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(String poltrona) {
        this.poltrona = poltrona;
    }

    public String toCSV() {
        return "";
    }
}
