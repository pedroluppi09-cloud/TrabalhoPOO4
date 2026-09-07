package ui;

import negocio.Sistema;
import negocio.Usuario;

import java.util.Scanner;

public class UIouvinte {
    UIadmin UIadmin = new UIadmin();

    public void menuInicial(Usuario U) {
        int opcao = 0;
        Scanner scn = new Scanner(System.in);

        Sistema S = Sistema.getInstance();

        UIavaliacoes UIavaliacoes = new UIavaliacoes();
        UIplaylists UIplaylists = new UIplaylists();
        UIlistagens UIlistagens = new UIlistagens();

        do {
            System.out.println("0 - SAIR");
            System.out.println("1 - Menu Playlists");
            System.out.println("2 - Menu Avaliações");
            System.out.println("3 - Menu Listagens");
            opcao = scn.nextInt();

            switch (opcao){
                case 1:
                    UIplaylists.menuInicial(U);
                    break;
                case 2:
                    UIavaliacoes.menuInicial(U);
                    break;
                case 3:
                    UIlistagens.menuInicial(U);
                    break;
                default:
                    break;
                }
            } while (opcao != 0);
    }
}
