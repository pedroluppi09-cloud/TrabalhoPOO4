package ui;

import negocio.Sistema;
import negocio.Usuario;

import java.util.Scanner;

public class UIadmin {
    Sistema S = Sistema.getInstance();

    UImusicas UImusicas = new UImusicas();
    UIavaliacoes UIavaliacoes = new UIavaliacoes();
    UIplaylists UIplaylists = new UIplaylists();
    UIlistagens UIlistagens = new UIlistagens();

    public void menuInicial(Usuario U) {
        int opcao = 0;
        Scanner scn = new Scanner(System.in);

        do {
            System.out.println("0 - SAIR");
            System.out.println("1 - Menu Músicas");
            System.out.println("2 - Menu Playlists");
            System.out.println("3 - Menu Avaliações");
            System.out.println("4 - Menu Listagens");
            opcao = scn.nextInt();

            switch (opcao){
                case 1:
                    UImusicas.menuInicial(U);
                    break;
                case 2:
                    UIplaylists.menuInicial(U);
                    break;
                case 3:
                    UIavaliacoes.menuInicial(U);
                    break;
                case 4:
                    UIlistagens.menuInicial(U);
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }
}
