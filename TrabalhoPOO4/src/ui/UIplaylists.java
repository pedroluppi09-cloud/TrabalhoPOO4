package ui;

import negocio.Musica;
import negocio.Sistema;
import negocio.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class UIplaylists {
    static Scanner scn = new Scanner(System.in);

    public void menuInicial(Usuario U, ArrayList<Usuario> usuarios) {
        int opcao;
        Sistema S = Sistema.getInstance();

        do {
            System.out.println("0 - SAIR");
            System.out.println("1 - Criar uma playlist");
            System.out.println("2 - Inserir Música em playlist");
            System.out.println("3 - Remover Música de playlist");
            System.out.println("4 - Editar informações de playlist");
            System.out.println("5 - Excluir Playlist");
            System.out.println("6 - Listar suas playlists");
            System.out.println("7 - Compartilhar playlist com usuário");
            System.out.println("8 - Criar playlist com formulário");
            opcao = scn.nextInt();

            ArrayList<Musica> copia = S.pegarVetorMusicas();
            switch (opcao){
                case 1: {
                    break;
                }
                case 2:{
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    break;
                }
                case 6: {
                    break;
                }
                case 7: {
                    break;
                }
                case 8: {
                    break;
                }
                default: {
                    break;
                }
            }
        } while (opcao != 0);


    }
}
