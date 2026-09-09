package ui;

import negocio.Musica;
import negocio.Sistema;
import negocio.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class UIavaliacoes {
    Scanner scn = new Scanner(System.in);

    public void menuInicial(Usuario u) {
        int opcao;
        Sistema S = Sistema.getInstance();
        String formatoMusica = "%-4s %-25s %-25s %-15s %-1s";

        do {
            System.out.println("0 - SAIR");
            System.out.println("1 - Fazer a avaliação de uma música");
            System.out.println("2 - Editar a avaliação de uma música");
            System.out.println("3 - Excluir a avaliação de uma música");
            System.out.println("4 - Ver avaliações já feitas por você");
            System.out.println("5 - Listar avaliações de determinada música");
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
                    System.out.printf(formato, "ID", "NOME", "ARTISTA", "NOTA ATUAL", "GENERO");
                    System.out.println();

                    for (int i = 0; i < copia.size(); i++) {
                        copia.get(i).imprimirColuna(formato);
                        System.out.println();
                    }

                    System.out.println("Insira o ID da música que deseja alterar");

                    do {
                        idMusica = scn.nextInt();

                        for (int i = 0; i < copia.size(); i++) {
                            if (idMusica == copia.get(i).getId()) {
                                consi = i;
                                existe = true;
                                break;
                            }
                        }

                        if (!existe)
                            System.out.println("Insira um ID válido");

                    } while (!existe);
                    break;
                }
                default: {
                    break;
                }
            }
        } while (opcao != 0);
    }
}
