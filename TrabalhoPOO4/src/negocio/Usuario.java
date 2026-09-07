package negocio;

public class Usuario {
    private String nome;
    private char funcao;
    private String senha;

    public Usuario(String nome, String senha, char funcao) {
        this.nome = nome;
        this.funcao = funcao;
        this.senha = senha;
    }

    public Usuario(Usuario u) {
        this.nome = u.nome;
        this.funcao = u.funcao;
        this.senha = u.senha;
    }

    public void imprimir() {
        if (funcao == 'A') {
            System.out.println("Administrador: " + nome + ", " + senha);
        }

        if (funcao == 'O') {
            System.out.println("Ouvinte: " + nome + ", " + senha);
        }
    }

    public String getNome() {
        return nome;
    }

    public char getFuncao() {
        return funcao;
    }

    public String getSenha() {
        return senha;
    }
}
