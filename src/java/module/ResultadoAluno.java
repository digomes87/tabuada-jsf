package module;

/**
 *
 * @author Diego
 */

public class ResultadoAluno {
    private String matricula;
    private String nome;
    private int pontuacao;

    // Construtor
    public ResultadoAluno(String matricula, String nome, int pontuacao) {
        this.matricula = matricula;
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    // Getters e Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
