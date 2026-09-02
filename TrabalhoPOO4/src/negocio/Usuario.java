package negocio;

public class Usuario {
    private String nome;
    private char funcao;
    private String senha;

    public Usuario(char funcao) {
        if (funcao == 'O'){
            this.nome = "Ouvinte";
            this.funcao = funcao;
            this.senha = "1234";
        }

        if (funcao == 'A'){
            this.nome = "Admin";
            this.funcao = funcao;
            this.senha = "5678";
        }
    }

    public void imprimir() {
        if (funcao == 'A') {
            System.out.println("Administrador: " + nome + ", " + senha);
        }

        if (funcao == 'O') {
            System.out.println("Ouvinte: " + nome + ", " + senha);
        }
    }
}
