public class JogadaValida {

    static boolean jogadaValida(String posicoesLivres, int linha, int coluna) {

        // Formatar a jogada no formato "linha+coluna" (e.g., "01" para linha 0, coluna 1)
        String jogada = linha + "" + coluna;
    
        // Verificar se a jogada está presente na lista de posições livres
        return posicoesLivres.contains(jogada);
    }
}