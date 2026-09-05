import negocio.Usuario;

public class Main {
    static void main() {
        // inicia com 2 usuários
        Usuario Ouvinte = new Usuario('O');
        Usuario Admin = new Usuario('A');

        System.out.println("Usuários cadastrados (nome, senha): ");
        Ouvinte.imprimir();
        Admin.imprimir();

        System.out.println("ronaldo");
    }
}
