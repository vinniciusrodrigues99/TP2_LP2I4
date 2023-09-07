import java.util.UUID;
//Vinnicius O. Rodrigues
public class Aluno {
    // Atributos
    private String endereco;
    private String nome;
    private int idade;
    private UUID uuid;

    // método Construtor
    public Aluno(UUID uuid, String nome, int idade, String endereco) {
        this.uuid = uuid;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Getters
    public String getEndereco() {
        return endereco;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public UUID getUuid() {
        return uuid;
    }

    // setters
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
