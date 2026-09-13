package ui;

import negocio.Musica;
import negocio.Playlist;
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
                    boolean adicionou = false;
                    Playlist P = null;
                    String nome;
                    String descricao;

                    do {
                        System.out.println("Nome da Playlist:");
                        nome = scn.nextLine();
                        scn.nextLine();

                        System.out.println("Descricao: ");
                        descricao = scn.nextLine();
                        scn.nextLine();

                        P = Playlist.getInstance(nome, descricao, U);

                        if (P == null){
                            System.out.println("Erro no cadastro da playlist");
                        } else {
                            adicionou = S.adicionarPlaylist(P, U.getId());

                            if (adicionou){
                                System.out.println("Playlist adicionada com sucesso!");
                            } else {
                                System.out.println("Erro no cadastro da playlist (você já criou uma cadastrada com esse nome)");
                            }
                        }
                    } while (!adicionou);
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
