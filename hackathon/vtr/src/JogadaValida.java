public class JogadaValida {

    static boolean jogadaValida(String posicoesLivres, int linha, int coluna) {

        // Formatar a jogada no formato "linha+coluna"
        String jogada = linha + "" + coluna;
    
        // Verificar se a jogada está presente na lista de posições livres
        return posicoesLivres.contains(jogada);
    }
}