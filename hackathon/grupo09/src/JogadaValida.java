//Maria Eduarda
public class JogadaValida {

    static boolean JogadaValidagadaValida(String posicoesLivres, int linha, int coluna) {

        // Formata a jogada na forma "linha,coluna"
        String jogada = linha + "," + coluna;
    
        // Verifica se a jogada está presente na string de posições livres
        return posicoesLivres.contains(jogada);
    }
}