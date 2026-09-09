package ui;

import negocio.Genero;
import negocio.Musica;
import negocio.Sistema;

import java.util.ArrayList;
import java.util.Scanner;

public class UImusicas {
    Scanner scn = new Scanner(System.in);

    public void menuInicial(char tipo) {
        int opcao = 0;
        Sistema S = Sistema.getInstance();
        Genero[] genero = {Genero.ROCK, Genero.BLUES, Genero.JAZZ, Genero.POP, Genero.SERTANEJO, Genero.HIPHOP, Genero.GOSPEL, Genero.ELETRO, Genero.MPB, Genero.HEAVYMETAL};
        String formato = "%-4s %-25s %-25s %-15s %-1s";

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

            System.out.println("--------------------------------------------");

            switch (opcao){
                case 1: { // LISTAR TODAS AS MÚSICAS
                    ArrayList<Musica> copia = S.pegarVetorMusicas();

                    if (copia.isEmpty()){
                        System.out.println("Nenhuma música cadastrada");
                    } else {
                        System.out.printf(formato, "ID", "NOME", "ARTISTA", "NOTA ATUAL", "GENERO");
                        System.out.println();

                        for (int i = 0; i < copia.size(); i++){
                            if (!copia.get(i).isExcluido()){
                                System.out.printf(formato, copia.get(i).getId(), copia.get(i).getNome(), copia.get(i).getArtista(),
                                        copia.get(i).getNotaAtual() + "/10", copia.get(i).getGenero());
                                System.out.println();
                            }
                        }
                    }
                    break;
                }
                case 2: { // LISTAR TODAS AS MÚSICAS DE UM GÊNERO
                    ArrayList<Musica> copia = S.pegarVetorMusicas();

                    if (copia.isEmpty()) {
                        System.out.println("Nenhuma música cadastrada");
                    } else {
                        Genero genEnum = null;
                        boolean generoValido = false;

                        System.out.println("Escolha 1 gênero (nome):");
                        System.out.println("ROCK, BLUES, JAZZ, POP, SERTANEJO, HIPHOP, GOSPEL, ELETRO, MPB, HEAVYMETAL");

                        do {
                            String gen = scn.nextLine();

                            for (int i = 0; i < genero.length; i++){
                                if (genero[i].name().equalsIgnoreCase(gen)){
                                    generoValido = true;
                                    genEnum = genero[i];
                                    break;
                                }
                            }

                            if (generoValido){
                                System.out.printf(formato, "ID", "NOME", "ARTISTA", "NOTA ATUAL", "GENERO");
                                System.out.println();

                                for (int i = 0; i < copia.size(); i++){
                                    if (!copia.get(i).isExcluido() && copia.get(i).getGenero().equals(genEnum)) {
                                        System.out.printf(formato, copia.get(i).getId(), copia.get(i).getNome(), copia.get(i).getArtista(),
                                                copia.get(i).getNotaAtual() + "/10", copia.get(i).getGenero());
                                        System.out.println();
                                    }
                                }
                            }
                        } while (!generoValido);

                        break;
                    }
                }
                case 3: { // LISTAR TODAS AS MÚSICAS POR UM TERMO QUALQUER
                    ArrayList<Musica> copia = S.pegarVetorMusicas();
                    String parte = "";

                    if (copia.isEmpty()) {
                        System.out.println("Nenhuma música cadastrada");
                    } else {
                        System.out.println("Insira uma tag para pesquisar");

                        do {
                            parte = scn.nextLine();

                            if (parte.isEmpty()) {
                                System.out.println("Insira um termo para a pesquisa");
                            }
                        } while (parte.isEmpty());

                        ArrayList<Musica> resultado = new ArrayList<>();

                        do {
                            for (int i = 0; i < copia.size(); i++){
                                if (!copia.get(i).isExcluido() && copia.get(i).verPrefixoComum(parte, resultado)){
                                    resultado.add(copia.get(i));
                                }
                            }

                            String consParte = parte;
                            parte = "";

                            for (int i = 0; i < consParte.length() - 1; i++){
                                parte += String.valueOf(consParte.charAt(i));
                            }
                        } while (!parte.isEmpty());

                        if (resultado.isEmpty()){
                            System.out.println("Nenhuma música encontrada");
                        } else {
                            System.out.printf(formato, "ID", "NOME", "ARTISTA", "NOTA ATUAL", "GENERO");
                            System.out.println();

                            for (int i = 0; i < resultado.size(); i++){
                                System.out.printf(formato, resultado.get(i).getId(), resultado.get(i).getNome(), resultado.get(i).getArtista(),
                                        resultado.get(i).getNotaAtual(), resultado.get(i).getGenero());
                                System.out.println();
                            }
                        }
                    }
                    break;
                }
                case 4: { // LISTAR TODAS AS MÚSICAS PELA NOTA
                    ArrayList<Musica> copia = S.pegarVetorMusicas();
                    int opcaoMaiorMenor = 0;
                    int nota;
                    boolean teveTermo = false;

                    do {
                        System.out.println("Escolha entre:");
                        System.out.println("0 - menor ou igual:");
                        System.out.println("1 - maior ou igual:");
                        opcaoMaiorMenor = scn.nextInt();
                    } while (opcaoMaiorMenor != 0 && opcaoMaiorMenor != 1);

                    do {
                        System.out.println("Escolha a nota (entre 0 e 10):");
                        nota = scn.nextInt();
                    } while (nota < 0 || nota > 10);

                    if (opcaoMaiorMenor == 1){
                        S.sortearMusicaOrdemCcodigoCrescente(copia);
                    } else {
                        S.sortearMusicaOrdemCcodigoDecrescente(copia);
                    }

                    System.out.printf(formato, "ID", "NOME", "ARTISTA", "NOTA ATUAL", "GENERO");
                    System.out.println();

                    for (int i = 0; i < copia.size(); i++){
                        if (!copia.get(i).isExcluido()){
                            if (opcaoMaiorMenor == 0 && copia.get(i).getNotaAtual() <= nota){
                                System.out.printf(formato, copia.get(i).getId(), copia.get(i).getNome(), copia.get(i).getArtista(),
                                        copia.get(i).getNotaAtual() + "/10", copia.get(i).getGenero());
                                System.out.println();
                                teveTermo = true;
                            }

                            if (opcaoMaiorMenor == 1 && copia.get(i).getNotaAtual() >= nota){
                                System.out.printf(formato, copia.get(i).getId(), copia.get(i).getNome(), copia.get(i).getArtista(),
                                        copia.get(i).getNotaAtual() + "/10", copia.get(i).getGenero());
                                System.out.println();
                                teveTermo = true;
                            }
                        }
                    }
                    if (!teveTermo)
                        System.out.println("Nenhuma musica encontrada com essa estatística");

                    break;
                }
                case 5: { // CADASTRAR MÚSICAS
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
                case 6: { // EDITAR MÚSICAS
                    if (tipo == 'A'){
                        boolean existe = false;
                        int idMusica;
                        int consi = 0;
                        Musica musicaEsc = null;
                        ArrayList<Musica> copia = S.pegarVetorMusicas();

                        System.out.printf(formato, "ID", "NOME", "ARTISTA", "NOTA ATUAL", "GENERO");
                        System.out.println();

                        for (int i = 0; i < copia.size(); i++){
                            System.out.printf(formato, copia.get(i).getId(), copia.get(i).getNome(), copia.get(i).getArtista(),
                                    copia.get(i).getNotaAtual(), copia.get(i).getGenero());
                            System.out.println();
                        }

                        System.out.println("Insira o ID da música que deseja alterar");

                        do {
                            idMusica = scn.nextInt();

                            for (int i = 0; i < copia.size(); i++){
                                if (idMusica == copia.get(i).getId()){
                                    musicaEsc = copia.get(i);
                                    consi = i;
                                    existe = true;
                                    break;
                                }
                            }

                            if (!existe)
                                System.out.println("Insira um ID válido");

                        } while (!existe);

                        boolean alterou = false;

                        do {
                            boolean generoValido = false;
                            Genero genEnum = null;

                            System.out.println("Nome [" + musicaEsc.getNome() + "]:");
                            String nome = scn.nextLine();

                            System.out.println("Artista [" + musicaEsc.getArtista() + "]:");
                            String artista = scn.nextLine();

                            System.out.println("Genero [" + musicaEsc.getGenero().name() + "]");
                            System.out.println("ROCK, BLUES, JAZZ, POP, SERTANEJO, HIPHOP, GOSPEL, ELETRO, MPB, HEAVYMETAL");
                            String gen = scn.nextLine();

                            for (int i = 0; i < genero.length; i++){
                                if (genero[i].name().equalsIgnoreCase(gen)){
                                    generoValido = true;
                                    genEnum = genero[i];
                                    break;
                                }
                            }

                            if (generoValido){
                                musicaEsc.setNome(nome);
                                musicaEsc.setArtista(artista);
                                musicaEsc.setGenero(genEnum);

                                alterou = S.alterarMusica(musicaEsc, consi);

                                if (!alterou)
                                    System.out.println("Não foi possível editar a música. Ela possui nome e artista repetidos");
                            }

                        } while (!alterou);
                    }
                    break;
                }
                case 7: { // EXCLUIR MÚSICAS
                    if (tipo == 'A') {
                        boolean excluiu = false;
                        boolean existe = false;
                        int idMusica;
                        int consi = 0;
                        ArrayList<Musica> copia = S.pegarVetorMusicas();

                        System.out.printf(formato, "ID", "NOME", "ARTISTA", "NOTA ATUAL", "GENERO");
                        System.out.println();

                        for (int i = 0; i < copia.size(); i++) {
                            System.out.printf(formato, copia.get(i).getId(), copia.get(i).getNome(), copia.get(i).getArtista(),
                                    copia.get(i).getNotaAtual(), copia.get(i).getGenero());
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

                        excluiu = S.excluirMusica(consi);

                        if (!excluiu) {
                            System.out.println("Ocorreu algum erro na exclusão");
                        } else {
                            System.out.println("Registro excluido com sucesso");
                        }
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
