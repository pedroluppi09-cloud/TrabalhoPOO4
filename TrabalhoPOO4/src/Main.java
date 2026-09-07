import negocio.Genero;
import negocio.Musica;
import negocio.Sistema;
import negocio.Usuario;
import ui.UIadmin;
import ui.UIouvinte;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scn = new Scanner(System.in);

    static void main() {
        Sistema S = new Sistema();
        UIouvinte UIouvinte = new UIouvinte();
        UIadmin UIadmin = new UIadmin();

        ArrayList<Usuario> U = new ArrayList<>();

        U.add(new Usuario("Ouvinte1", "123", 'O'));
        U.add(new Usuario("Ouvinte2", "456", 'O'));
        U.add(new Usuario("Admin1", "135", 'A'));
        U.add(new Usuario("Admin2", "246", 'A'));

        // init musicas
        Musica M;

        String[] nomes = {"Highway to Hell", "Bohemian Rhapsody", "The Thrill Is Gone", "Sweet Home Chicago", "Take Five", "What a Wonderful World",
                "Thriller", "Shape of You", "Evidências", "Fio de Cabelo", "Lose Yourself", "Juicy", "Ninguém Explica Deus", "Aos Olhos do Pai", "Titanium", "Levels",
                "Como Nossos Pais", "Aquele Abraço", "Master of Puppets", "The Number of the Beast"};

        String[] artista = {"AC/DC", "Queen", "B.B. King", "Buddy Guy", "Dave Brubeck", "Louis Armstrong", "Michael Jackson", "Ed Sheeran", "Chitãozinho & Xororó",
                "Chitãozinho & Xororó", "Eminem", "The Notorious B.I.G.", "Preto no Branco", "Diante do Trono", "David Guetta", "Avicii", "Elis Regina", "Gilberto Gil",
                "Metallica", "Iron Maiden"};

        Genero[] genero = {Genero.ROCK, Genero.BLUES, Genero.JAZZ, Genero.POP, Genero.SERTANEJO, Genero.HIPHOP, Genero.GOSPEL, Genero.ELETRO, Genero.MPB, Genero.HEAVYMETAL};

        for(int i = 0; i < 20; i++){
            M = new Musica(nomes[i], artista[i], genero[i/2]);
            S.adicionarMusica(M);
        }

        System.out.println("--------------------------------------------");

        // menu inicial
        int opcao = 0;

        do {
            System.out.println("0 - SAIR");
            System.out.println("1 - Selecionar Usuario");
            opcao = scn.nextInt();
            System.out.println("--------------------------------------------");

            switch (opcao){
                case 1:
                    //Selecionar o Usuário
                    String formato = "%-10s %-1s";
                    System.out.printf(formato, "NOME", "FUNÇÃO");
                    System.out.println();
                    for(int i = 0; i < U.size(); i++){
                        if (U.get(i).getFuncao() == 'O'){
                            System.out.printf(formato, U.get(i).getNome(), "Ouvinte");
                        } else {
                            System.out.printf(formato, U.get(i).getNome(), "Administrador");
                        }
                        System.out.println();
                    }
                    System.out.println("--------------------------------------------");

                    boolean existe = false;
                    Usuario Uatual = null;

                    System.out.println("Selecione o usuário (digite o nome):");
                    do {
                        String nome = scn.next();

                        for(int i = 0; i < U.size(); i++){
                            if (U.get(i).getNome().equalsIgnoreCase(nome)){
                                Uatual = U.get(i);
                                existe = true;
                                break;
                            }
                        }

                        if (!existe)
                            System.out.println("Usuário não encontrado");

                    } while (!existe);

                    boolean senhaCorreta = false;

                    System.out.println("Digite a senha do usuário:");
                    do {
                        String senha = scn.next();

                        if (senha.equals(Uatual.getSenha())){
                            senhaCorreta = true;
                            System.out.println("Cadastro feito com sucesso");
                        } else {
                            System.out.println("Senha Incorreta");
                        }
                    } while (!senhaCorreta);

                    if (Uatual.getFuncao() == 'O'){
                        UIouvinte.menuInicial(Uatual);
                    } else {
                        UIadmin.menuInicial(Uatual);
                    }
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }
}
