package ui;

import negocio.Genero;
import negocio.Musica;
import negocio.Sistema;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class UImusicas {
    Scanner scn = new Scanner(System.in);

    public void menuInicial(char tipo) {
        int opcao = 0;
        Sistema S = Sistema.getInstance();
        Genero[] genero = {Genero.ROCK, Genero.BLUES, Genero.JAZZ, Genero.POP, Genero.SERTANEJO, Genero.HIPHOP, Genero.GOSPEL, Genero.ELETRO, Genero.MPB, Genero.HEAVYMETAL};

        do {
            System.out.println("--------------------------------------------");
            System.out.println("0 - SAIR");
            System.out.println("1 - Listar todas as Músicas");
            System.out.println("2 - Listar Músicas pelo Gênero");
            System.out.println("3 - Listar Músicas por nome parecido");
            System.out.println("4 - Listar Músicas pela Nota");

            if (tipo == 'A'){
                System.out.println("5 - Cadastrar música");
                System.out.println("6 - Atualizar música");
                System.out.println("7 - Excluir música");
            }

            opcao = scn.nextInt();
            scn.nextLine();

            switch (opcao){
                case 1: {
                    ArrayList<Musica> copia = S.pegarVetorMusicas();
                    String formato = "%-4s %-20s %-20s %-5s %-1s";

                    if (copia.isEmpty()){
                        System.out.println("Nenhuma música cadastrada");
                    } else {
                        System.out.printf(formato, "ID", "NOME", "ARTISTA", "NOTA ATUAL", "GENERO");
                        System.out.println();

                        for (int i = 0; i < copia.size(); i++){
                            System.out.printf(formato, copia.get(i).getId(), copia.get(i).getNome(), copia.get(i).getArtista(),
                                    copia.get(i).getNotaAtual() + "/10", copia.get(i).getGenero());
                            System.out.println();
                        }
                    }
                    break;
                }
                case 2: {
                    ArrayList<Musica> copia = S.pegarVetorMusicas();
                    String formato = "%-4s %-20s %-20s %-5s %-1s";

                    System.out.println("Escolha 2 gêneros (nome). Digite '@' nos campos caso opite por somente 1 gênero ou nenhum gênero:");
                    System.out.println("ROCK, BLUES, JAZZ, POP, SERTANEJO, HIPHOP, GOSPEL, ELETRO, MPB, HEAVYMETAL");

                    boolean existe;

                    do {
                        existe = false;
                        System.out.println("Genero ");
                        String gen1 = scn.next();
                        String gen2 = scn.next();

                        if (!gen1.equals("@")){
                            for (int i = 0; i < genero.length; i++){
                                if (genero[i].name().equalsIgnoreCase(gen1)){
                                    existe = true;
                                    break;
                                }
                            }
                        }

                        if (!gen2.equals("@")){
                            for (int i = 0; i < genero.length; i++){
                                if (genero[i].name().equalsIgnoreCase(gen2)){
                                    existe = true;
                                    break;
                                }
                            }
                        }

                        if (gen1.equals("@") && gen2.equals("@"))
                            existe = true;

                    } while (!existe);
                    String gen1 = scn.next();
                    String gen2 = scn.next();

                    break;
                }
                case 3: {

                }
                case 4: {

                }
                case 5: {
                    if (tipo == 'A'){
                        String nome = "", artista = "", gen = "";
                        Genero genEnum = null;
                        Musica M = null;
                        boolean generoValido = false;
                        boolean adicionou = false;

                        do {
                            System.out.println("Nome:");
                            nome = scn.nextLine();

                            System.out.println("Artista:");
                            artista = scn.nextLine();

                            System.out.println("Genero:");
                            System.out.println("ROCK, BLUES, JAZZ, POP, SERTANEJO, HIPHOP, GOSPEL, ELETRO, MPB, HEAVYMETAL");
                            gen = scn.nextLine();

                            for (int i = 0; i < genero.length; i++){
                                if (genero[i].name().equalsIgnoreCase(gen)){
                                    generoValido = true;
                                    genEnum = genero[i];
                                    break;
                                }
                            }

                            if (generoValido){
                                M = Musica.getInstance(nome, artista, genEnum);
                            }

                            if (M == null) {
                                System.out.println("Erro no cadastro. Insira as informações válidas");
                            } else {
                                adicionou = S.adicionarMusica(M);

                                if (!adicionou) {
                                    System.out.println("Não foi possível adicionar a música. Ela possui nome e artista repetidos");
                                } else {
                                    System.out.println("Musica cadastrada com sucesso");
                                }
                            }

                        } while (!adicionou);
                    }
                    break;
                }
                case 6: {
                    if (tipo == 'A'){

                    }
                    break;
                }
                case 7: {
                    if (tipo == 'A'){

                    }
                    break;
                }
                default: {
                    break;
                }
            }
        } while (opcao != 0);
    }
}
