import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Passageiro {
    private final String cpf;
    private final String nome;
    private final String endereco;
    private final String telefone;
    private final int passagem;
    private String poltrona;
    private final String voo;
    private final String horario;

    public Passageiro(String cpf, String nome, String endereco, String telefone,
                      int passagem, String poltrona, String voo, String horario) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.passagem = passagem;
        this.poltrona = poltrona;
        this.voo = voo;
        this.horario = horario;
    }

    public Passageiro(String csv) {
        List<String> data = Arrays.stream(csv.trim().split(", ")).collect(Collectors.toList());
        data = data.stream()
                .map(s -> {
                    if (s.charAt(0) == '\"' && s.charAt(s.length()-1) == '\"') {
                        s = s.substring(1, s.length()-1);
                    }
                    return s.trim();
                })
                .collect(Collectors.toList());
        this.cpf = data.get(0);
        this.nome = data.get(1);
        this.endereco = data.get(2);
        this.telefone = data.get(3);
        this.passagem = Integer.parseInt(data.get(4));
        this.poltrona = data.get(5);
        this.voo = data.get(6);
        this.horario = data.get(7);
    }

    public String toCSV() {
        return "\""+cpf+"\", \""+nome+"\", \""+endereco+"\", \""+telefone+"\", "+passagem+", \""+poltrona+"\", \""+voo+"\", \""+horario+"\"";
    }

    public String mostrar() {
        return "CPF: " + cpf + "\t\t" +
                "Nome: " + nome + "\t\t" +
                "Passagem: " + passagem + "\t\t" +
                "Poltrona: " + poltrona;
    }

    public int getPassagem() {
        return passagem;
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
}
