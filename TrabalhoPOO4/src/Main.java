import negocio.Genero;
import negocio.Musica;
import negocio.Sistema;
import negocio.Usuario;

public class Main {
    static void main() {
        Sistema S = new Sistema();
        // inicia com 2 usuários
        Usuario Ouvinte = new Usuario('O');
        Usuario Admin = new Usuario('A');

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

        System.out.println("Usuários cadastrados (nome, senha): ");
        Ouvinte.imprimir();
        Admin.imprimir();


    }
}
